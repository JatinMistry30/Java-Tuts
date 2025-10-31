import java.util.*;
public class RemoveSpace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the pharse");
        String stringInput = in.nextLine();

        String removedSpaces = stringInput.replaceAll("\\s+", "");
        System.out.println("The spaces are removed: "+removedSpaces);

        in.close();
    }
}
