public class Recursion2 {
    public static int calcPower(int x, int n) {
        if (n == 1) {
            return x;
        }
        if (x == 0) {
            return 0;
        }

        int xPowenm1 = calcPower(x, n - 1);
        int xPown = x * xPowenm1;
        return xPown;
    }

    public static void main(String args[]) {
        int x = 2 , n =5;
        int ans = calcPower(x, n);
        System.out.println(ans);
    }
}
