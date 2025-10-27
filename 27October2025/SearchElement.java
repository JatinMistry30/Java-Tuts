import java.util.Arrays;
import java.util.Scanner;

public class SearchElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int arrSize = in.nextInt();

        int arr[] = new int[arrSize];
        System.out.println("You have entered size: " + arrSize);
        System.out.println("Enter the elements you want to set:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Index " + i + ": ");
            arr[i] = in.nextInt();
        }

        System.out.println("The array now is: " + Arrays.toString(arr));

        System.out.print("Enter the element you want to search: ");
        int searchValue = in.nextInt();

        boolean found = false; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                System.out.println("The value " + searchValue + " is found at index " + i);
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println("The value " + searchValue + " is not found in the array.");
        }

        in.close();
    }
}
