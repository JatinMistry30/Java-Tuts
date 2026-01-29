public class FirstAndLastOccurance {
    static int first = -1;
    static int last = -1;

    public static void printOccurance(String str, char elementString, int index) {
        if (index == str.length()) {
            System.out.println("First: " + first);
            System.out.println("Last: " + last);
            return;
        }
        if (str.charAt(index) == elementString) {
            if (first == -1) {
                first = index;
            }
            last = index;
        }
        printOccurance(str, elementString, index + 1);
    }

    public static void main(String[] args) {
        String str = "abaacdaefaah";
        printOccurance(str, 'a', 0);
    }
}
