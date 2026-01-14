import java.util.Scanner;

public class PrintAvg {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[] arr1 = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr1[i] = inp.nextInt();
            sum += arr1[i];
        }

        double average = sum / 3.0;
        System.out.println("Average: " + average);

        inp.close();
    }
}
