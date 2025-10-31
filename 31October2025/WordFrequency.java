import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter a phrase
        System.out.println("Enter the phrase:");
        String stringInput = in.nextLine();

        // Convert the string to lowercase to make the counting case-insensitive
        String lowerCaseString = stringInput.toLowerCase();

        // Split the string into words (using space as the delimiter)
        String[] words = lowerCaseString.split("\\s+");

        // Create a map to store word frequency
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Iterate over the words and count the frequency of each word
        for (String word : words) {
            // If the word already exists in the map, increment its count
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Print the word frequencies
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Close the scanner
        in.close();
    }
}
