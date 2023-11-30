package inf.string;

import java.util.Scanner;

public class Main16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int indexOf = str.indexOf(c);
            if (i == indexOf) {
                builder.append(c);
            }
        }

        System.out.println(builder);
    }

}
