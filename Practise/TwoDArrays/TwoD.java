package TwoDArrays;

import java.util.*;

public class TwoD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the Columns:");
        int Columns = sc.nextInt();

        int[][] numbers = new int[rows][Columns];

        // Input
        // Rows
        for (int i = 0; i < rows; i++) {
            // Columns
            for (int j = 0; j < Columns; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }
        System.out.println("This the Array");
        // Output
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Columns; j++) {
                System.out.print(numbers[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println("Enter the value");
        int indexVal = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Columns; j++) {
                if (numbers[i][j] == indexVal) {
                    System.out.println("The value " + indexVal + " is at index: (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Value not found");
        }

        sc.close();
    }
}
