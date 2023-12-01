package inf.string;

import java.util.Scanner;

public class Main112 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();

        String str = scanner.next();

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<str.length(); i+=7) {
            String e = str.substring(i, i+7);

            StringBuilder binary = new StringBuilder();
            for (char c : e.toCharArray()) {
                if (c == '#') binary.append(1);
                else binary.append(0);
            }
            int decimal = Integer.parseInt(binary.toString(), 2);
            builder.append((char) decimal);

        }
        System.out.println(builder);
    }

}
