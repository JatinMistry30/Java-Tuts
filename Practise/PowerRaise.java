import java.util.Scanner;

public class PowerRaise {

    double power(double base, double expo) {
        return Math.pow(base, expo);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the Base:");
        double base = in.nextDouble();
        System.out.println("Enter the Power:");
        double exponent = in.nextDouble();

        PowerRaise newPower = new PowerRaise();
        double result = newPower.power(base, exponent);

        System.out.println("The " + base + " to " + exponent + " is " + result);

        in.close();
    }
}
