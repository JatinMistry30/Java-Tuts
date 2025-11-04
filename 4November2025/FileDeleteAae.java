import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDeleteAae {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set your parent directory path here
        Path parentDir = Paths.get("C:\\Users\\SHREEASHAPURAMAA\\Desktop\\Jatin\\Jatins Iphone");

        try (Stream<Path> walk = Files.walk(parentDir)) {
            // Collect all files ending with .aae
            List<Path> aaeFiles = walk
                    .filter(p -> !Files.isDirectory(p))
                    .filter(p -> p.toString().toLowerCase().endsWith(".aae"))
                    .collect(Collectors.toList());

            // If no files found
            if (aaeFiles.isEmpty()) {
                System.out.println("No .aae files found.");
                return;
            }

            // Print how many files were found
            System.out.println("Found " + aaeFiles.size() + " .aae files:");
            for (Path file : aaeFiles) {
                System.out.println("  " + file);
            }

            // Ask for confirmation
            System.out.print("\nDo you want to delete all these files? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y")) {
                for (Path file : aaeFiles) {
                    try {
                        Files.delete(file);
                        System.out.println("Deleted: " + file);
                    } catch (IOException e) {
                        System.err.println("Failed to delete: " + file + " -> " + e.getMessage());
                    }
                }
                System.out.println("\nAll selected files deleted successfully.");
            } else {
                System.out.println("\nDeletion cancelled.");
            }

        } catch (IOException e) {
            System.err.println("Error walking the file tree: " + e.getMessage());
        }
        scanner.close();
    }
}
