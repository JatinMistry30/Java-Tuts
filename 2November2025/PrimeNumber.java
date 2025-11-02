
public class PrimeNumber {
    public static int Prime(int num) {
        int count = 0;
        for(int i =1; i<=num;i++){
            if(num % i ==0){
                count++;
            }
        }
        if (count > 2){
            System.out.println("Is NOT prime "+num);
        }else{
            System.out.println("Is prime " +num);
        }
        return 0;
    }
    public static void main(String[] args) {
        Prime(29);
    }    
}
