public class MoveChar {
    public static void moveCharacter(String str, int idx, int count, String newString) {

        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            count++;
            moveCharacter(str, idx + 1, count , newString);
        } else {
            newString += currChar;
            moveCharacter(str, idx + 1, count, newString);
        }
    }

    public static void main(String[] args) {
        String str = "axbcxxd";
        moveCharacter(str, 0, 0, "");
    }
}
