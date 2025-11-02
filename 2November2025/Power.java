
public class Power {
    public static double calculatePower(double base, int exponent){
        double result = 1.0;

        if(exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }
        for(int i = 1; i <=exponent; i++){
            result *= base;
        }
        return result;
    }
    public static void main(String[] args) {
        double base = 2;
        int exponent = 3;

        double result = calculatePower(base, exponent);
        System.out.println(base + " raised to the power of " + exponent +" is " + result);
        
    }    
}
