import java.util.Scanner;

public class PracString {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String array[] = new String[size];
        int totLenght = 0;

        for (int i = 0; i < size; i++) {
            array[i] = sc.next();
            totLenght += array[i].length();

        }
        System.out.println(totLenght);
    }
}