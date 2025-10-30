import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int arr1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int arr2[][] = { { 7, 8 }, { 9, 10 }, { 11, 12 } };

        int result[][] = new int[2][2];
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    sum = sum + arr1[i][k] * arr2[k][j];
                }
                result[i][j] = sum;
                sum = 0;
            }
        }
        System.out.println(Arrays.deepToString(result));
    }
}
