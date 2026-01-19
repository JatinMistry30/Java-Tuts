package Array;

import java.util.Scanner;

public class ArrayPractise {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int numbers[] = new int[size];

        // Input
        for (int i = 0; i < size; i++) {
            numbers[i] = in.nextInt();
        }

        int x = in.nextInt();

        // Search
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                System.out.println("X found at index: " + i);
            }
        }

        in.close();
    }
}
