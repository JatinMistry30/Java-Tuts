import java.util.Scanner;
// public class FirstCode {
//     public static void main(String[] args) {
//         for(int i=0 ; i<=100 ; i++){
//             System.out.println(i);
//         }
//     }    
// }

// public class FirstCode {   
//     public static void main(String[] args) {
//         int number = 2;
//         int result;
//         for(int i=1 ; i<=10 ; i++){
//             result = i *number;
//             System.out.println("2 x"+i+"="+result);
//         }
//     }
// }

// public class FirstCode {
//     public static void main(String[] args) {
//         int number = 5;
//         int result = 1; 

//         for (int n = number; n >= 1; n--) {
//             result *= n; 
//         }

//         System.out.println(result);  
//     }
// }

public class FirstCode {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        int inpNumber = number.nextInt();

        if (inpNumber % 2 == 1 || inpNumber == 2) {
            System.out.println("The number " + inpNumber + "is prime number");
        } else {
            System.out.println("The number " + inpNumber + "is not prime number");
        }

        number.close();
    }
}