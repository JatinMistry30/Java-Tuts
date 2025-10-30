import java.lang.StringBuilder;
public class StringPalindrome {
    public static void main(String[] args) {
        String newString = "madams";
        String cleanedString = newString.toLowerCase();
        StringBuilder reversedStrBuilder = new StringBuilder(cleanedString);
        String reversedString = reversedStrBuilder.reverse().toString();
        if(cleanedString.equals(reversedString)){
            System.out.println("The String "+newString+" is an palindrome");
        }else{
            System.out.println("The string "+newString+" is not a palindrome");
        }

    }
}
