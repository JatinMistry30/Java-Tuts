import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first word");
        String firstString = in.nextLine();
        System.out.println("Enter the Second word");
        String secondString = in.nextLine();
        

        String str1 = firstString.replaceAll("\\s+", "");
        String str2 = secondString.replaceAll("\\s+", "");

        if(str1.length() != str2.length()){
            System.out.println("The strings are not an anagram");
        }else if(str1.length() == str2.length()){
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if(Arrays.equals(arr1, arr2)){
                System.out.println("The string "+firstString+" and "+secondString+" are anagram");
            }
        }

        in.close();
    }
}
