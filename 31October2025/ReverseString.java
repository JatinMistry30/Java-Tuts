import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string you want to reverse:");
        String stringInput = in.nextLine();
        StringBuilder reversedStrBuilder = new StringBuilder(stringInput);
        String reversedString = reversedStrBuilder.reverse().toString();
        System.out.println("The reversed string is:"+reversedString);


        in.close();
    }
}
