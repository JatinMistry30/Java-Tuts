import java.util.Scanner;

class Demo  {
    public static void main(String args[]){
        // System.out.println("Jatin Mistry");

        Scanner NewInp = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = NewInp.nextLine();

        System.out.println("Name is :"+name);
        

        NewInp.close();
    }
}