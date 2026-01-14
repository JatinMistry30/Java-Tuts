public class GreaterFunction {
    int greater(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static void main(String args[]) {
        GreaterFunction obj = new GreaterFunction();
        int result = obj.greater(5,10);

        System.out.println("Greater number is:"+ result);
    }
}
