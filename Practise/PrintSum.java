import java.util.Scanner;

public class PrintSum {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter the number:");
        int inp1 = in.nextInt();

        for (int i = 1; i <= inp1; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }

        System.out.println("The sum of odd numbers till " + inp1 + " is " + sum);

        in.close();
    }
}
