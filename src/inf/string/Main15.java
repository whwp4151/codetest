package inf.string;

import java.util.Scanner;

public class Main15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isAlphabetic(aChar)) {
                builder.append(aChar);
            }
        }

        char[] array = builder.reverse().toString().toCharArray();
        int j=0;
        for (int i=0; i<chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = array[j++];
            }
        }

        System.out.println(chars);
    }

}
