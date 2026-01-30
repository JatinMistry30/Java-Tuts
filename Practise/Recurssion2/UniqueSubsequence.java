import java.util.HashSet;

public class UniqueSubsequence {

    public static void printSubsequence(String str, int idx, String newString, HashSet<String> set) {
        // Base case
        if (idx == str.length()) {
            if (!set.contains(newString)) {
                System.out.println(newString);
                set.add(newString);
            }
            return;
        }

        char currChar = str.charAt(idx);

        // To be added
        printSubsequence(str, idx + 1, newString + currChar, set);

        // To not be added
        printSubsequence(str, idx + 1, newString, set);
    }

    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        printSubsequence(str, 0, "", set);
    }
}
