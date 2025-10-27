import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int reversedArr[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArr[arr.length - 1 - i] = arr[i];
        }

        System.out.println(Arrays.toString(reversedArr));
    }    
}
