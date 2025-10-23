import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String[] operation = { "1. Addition", "2. Subtraction", "3. Multiplication", "4. Division" };
        
        for (String op : operation) {
            System.out.println(op);
        }

        Scanner operationInput = new Scanner(System.in);
        int inputNumber;

        while (true) {
            System.out.println("Enter the number corresponding to the operation you want to perform:");
            inputNumber = operationInput.nextInt();

            if (inputNumber >= 1 && inputNumber <= 4) {
                break;
            } else {
                System.out.println("Invalid input. Please choose a number between 1 and 4.");
            }
        }

        String operationSelected = operation[inputNumber - 1];
        System.out.println("You selected: " + operationSelected);

        System.out.println("Enter the first number: ");
        double num1 = operationInput.nextDouble();
        System.out.println("Enter the second number: ");
        double num2 = operationInput.nextDouble();

        switch (inputNumber) {
            case 1:
                double additionResult = num1 + num2;
                System.out.println("The result is: " + additionResult);
                break;
            case 2:
                double subtractionResult = num1 - num2;
                System.out.println("The result is: " + subtractionResult);
                break;
            case 3:
                double multiplicationResult = num1 * num2;
                System.out.println("The result is: " + multiplicationResult);
                break;
            case 4:
                if (num2 != 0) {
                    double divisionResult = num1 / num2;
                    System.out.println("The result is: " + divisionResult);
                } else {
                    System.out.println("Error! Division by zero.");
                }
                break;
        }

        operationInput.close();
    }
}
