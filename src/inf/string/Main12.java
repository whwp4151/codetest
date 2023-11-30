package inf.string;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            builder.append(c);
        }
        System.out.println(builder);
    }

}
