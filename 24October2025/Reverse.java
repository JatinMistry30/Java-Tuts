import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int inpNumber = number.nextInt();
        // int temp = inpNumber;
        int result = 0;
        int digit = 0;
        while (inpNumber > 0) {
            digit = inpNumber % 10;
            result = result * 10 + digit;
            inpNumber = inpNumber / 10;
        }

        System.out.println("The is Reverse" + result);
        number.close();
    }
}
