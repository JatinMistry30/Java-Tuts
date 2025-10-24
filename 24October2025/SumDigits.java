import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int inpNumber = number.nextInt();
        int result = 0;

        while (inpNumber > 0) {
            int digit = inpNumber % 10;  
            result += digit; 
            inpNumber /= 10;
        }

        System.out.println("The Sum is " + result);
        number.close();
    }
}
