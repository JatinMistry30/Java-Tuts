import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class NodeJSRunner extends JFrame {
    private JTextArea codeArea;
    private JTextArea outputArea;
    private JTextField commandField;
    private JButton runButton;
    private JButton saveButton;
    private JButton loadButton;
    private File currentFile;

    public NodeJSRunner() {
        setTitle("Node.js Runner");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top panel with buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        runButton = new JButton("Run Code");
        saveButton = new JButton("Save File");
        loadButton = new JButton("Load File");
        
        topPanel.add(runButton);
        topPanel.add(saveButton);
        topPanel.add(loadButton);

        // Code editor area
        codeArea = new JTextArea();
        codeArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        codeArea.setTabSize(2);
        codeArea.setText("// Write your Node.js code here\nconsole.log('Hello from Node.js!');\n");
        JScrollPane codeScroll = new JScrollPane(codeArea);
        codeScroll.setBorder(BorderFactory.createTitledBorder("Code Editor"));

        // Output area
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(40, 40, 40));
        outputArea.setForeground(Color.WHITE);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createTitledBorder("Output"));

        // Split pane for code and output
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, codeScroll, outputScroll);
        splitPane.setResizeWeight(0.6);

        // Bottom panel with command line
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        JLabel cmdLabel = new JLabel("Command:");
        commandField = new JTextField("node temp.js");
        JButton execButton = new JButton("Execute");
        
        bottomPanel.add(cmdLabel, BorderLayout.WEST);
        bottomPanel.add(commandField, BorderLayout.CENTER);
        bottomPanel.add(execButton, BorderLayout.EAST);

        // Add all panels
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Event listeners
        runButton.addActionListener(e -> runCode());
        execButton.addActionListener(e -> executeCommand());
        saveButton.addActionListener(e -> saveFile());
        loadButton.addActionListener(e -> loadFile());
        
        // Ctrl+Enter to run
        codeArea.getInputMap().put(KeyStroke.getKeyStroke("control ENTER"), "runCode");
        codeArea.getActionMap().put("runCode", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                runCode();
            }
        });
    }

    private void runCode() {
        try {
            // Create temp file
            File tempFile = File.createTempFile("nodejs_runner_", ".js");
            tempFile.deleteOnExit();
            
            // Write code to temp file
            Files.writeString(tempFile.toPath(), codeArea.getText());
            
            // Run Node.js
            executeNodeCommand("node " + tempFile.getAbsolutePath());
            
        } catch (Exception ex) {
            outputArea.setText("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void executeCommand() {
        String command = commandField.getText().trim();
        if (command.isEmpty()) {
            outputArea.setText("Please enter a command");
            return;
        }
        executeNodeCommand(command);
    }

    private void executeNodeCommand(String command) {
        outputArea.setText("Executing: " + command + "\n\n");
        
        // Run in separate thread to avoid freezing GUI
        new Thread(() -> {
            try {
                ProcessBuilder pb = new ProcessBuilder();
                
                // Split command into parts
                String[] parts = command.split("\\s+");
                pb.command(parts);
                
                // Redirect error stream
                pb.redirectErrorStream(true);
                
                // Start process
                Process process = pb.start();
                
                // Read output
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
                );
                
                StringBuilder output = new StringBuilder("Executing: " + command + "\n\n");
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                
                // Wait for completion
                int exitCode = process.waitFor();
                output.append("\n--- Process finished with exit code: ").append(exitCode).append(" ---");
                
                // Update output area on GUI thread
                SwingUtilities.invokeLater(() -> outputArea.setText(output.toString()));
                
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> 
                    outputArea.setText("Error executing command:\n" + ex.getMessage())
                );
            }
        }).start();
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save JavaScript File");
        
        if (currentFile != null) {
            fileChooser.setSelectedFile(currentFile);
        }
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            
            // Add .js extension if not present
            if (!currentFile.getName().endsWith(".js")) {
                currentFile = new File(currentFile.getAbsolutePath() + ".js");
            }
            
            try {
                Files.writeString(currentFile.toPath(), codeArea.getText());
                setTitle("Node.js Runner - " + currentFile.getName());
                outputArea.setText("File saved: " + currentFile.getAbsolutePath());
            } catch (IOException ex) {
                outputArea.setText("Error saving file: " + ex.getMessage());
            }
        }
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load JavaScript File");
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            
            try {
                String content = Files.readString(currentFile.toPath());
                codeArea.setText(content);
                setTitle("Node.js Runner - " + currentFile.getName());
                commandField.setText("node " + currentFile.getAbsolutePath());
                outputArea.setText("File loaded: " + currentFile.getAbsolutePath());
            } catch (IOException ex) {
                outputArea.setText("Error loading file: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Check if Node.js is installed
        try {
            ProcessBuilder pb = new ProcessBuilder("node", "--version");
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Node.js is not installed or not in PATH!\nPlease install Node.js first.",
                "Node.js Not Found",
                JOptionPane.ERROR_MESSAGE);
        }
        
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(NodeJSRunner::new);
    }
}