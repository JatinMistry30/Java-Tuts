import java.util.Scanner;

public class Convertor {
    public static void main(String[] args) {

        Scanner celciusInput = new Scanner(System.in);
        double celcius;

        while (true) {
            System.out.println("Enter temperature in Celsius");
            // Checks if the user wants to exit
            if(celciusInput.hasNextDouble()){
                celcius = celciusInput.nextDouble();
                double fahrenheit = celcius * 9 / 5 + 32;
                System.out.println("Temperature in Fahrenheit:" +fahrenheit);
            }else{
                String input = celciusInput.next();
                if(input.equalsIgnoreCase("exit")) {
                    break;
                }else{
                    System.out.println("Invalid Input");
                }
            }
            break;
        }
        celciusInput.close();
    }
}
