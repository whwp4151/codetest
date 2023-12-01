package inf.string;

import java.util.Scanner;

public class Main111 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        str += " ";

        int cnt = 1;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                cnt++;
            } else {
                builder.append(str.charAt(i));
                if (cnt > 1) {
                    builder.append(cnt);
                }
                cnt = 1;
            }
        }

        System.out.println(builder);
    }

}
