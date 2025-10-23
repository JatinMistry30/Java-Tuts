import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Principle Amount");
        double principle = input.nextDouble();

        System.out.println("Enter the rate of interest in percentage");
        double rate = input.nextDouble();

        System.out.println("Enter the time period in years:");
        double time = input.nextDouble();

        double SimpleInterest = (principle * rate * time) /100;

        System.out.println("The simple interest is:" +SimpleInterest);

        input.close();
    }
}
