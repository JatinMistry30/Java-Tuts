import java.util.*;

public class CountVowels {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the phrase");
        String stringInput = in.nextLine();
        String lowerCaseString = stringInput.toLowerCase();
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < lowerCaseString.length(); i++) {
            char currentChar = lowerCaseString.charAt(i);

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o'
                    || currentChar == 'u') {
                vowelCount++;
            } else if ((currentChar >= 'a' && currentChar <= 'z')) {
                consonantCount++;
            }
        }
        System.out.println("Vowels count: " + vowelCount);
        System.out.println("Consonants count: " + consonantCount);
        in.close();
    }
}
