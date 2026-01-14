public class Circumference {
    double circleCircumference(int r1){
        return 2 * Math.PI * r1;
    }
    public static void main(String args[]){
        Circumference  c = new Circumference();
        System.out.println(c.circleCircumference(5));
    }
}
