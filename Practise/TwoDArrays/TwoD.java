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

        // Output
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < Columns; j++) {
                System.out.print(numbers[i][j] + " ");

            }
            System.out.println();
        }

        sc.close();
    }
}
