import java.io.*;

public class ReaderWriterDemo {

    public static void main(String[] args) {
        try{
            // Writer Hierarchy
            Writer writer = new FileWriter("Example.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("Hello Java");
            bw.newLine();
            bw.write("THis is Reader Write Hierarchy");
            bw.newLine();
            bw.write("Simple and easy example");

            bw.close(); // Closes BufferedWritter and FileWriter

            //Reader Hierarchy
            Reader reader = new FileReader("Example.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}