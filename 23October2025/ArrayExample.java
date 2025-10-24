import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // One dimentional Arrays
        // int[] numbers = {2,3,4,5,6,7,8,9};
        // System.out.println(Arrays.toString(numbers));

        // Two dimenstional Array
        // int [] [] numbers = new int[2][3];
        int[][] numbers = {{1,2,3},{4,5,6}};

        numbers[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers));

    }
}
