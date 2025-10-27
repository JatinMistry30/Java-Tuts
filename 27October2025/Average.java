
public class Average {
    public static void main(String[] args) {
        int arr[] = { 100, 125, 75, 12, 200 };
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        System.out.println(average);
    }
}
