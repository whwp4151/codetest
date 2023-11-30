package inf.string;

import java.util.*;

public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char c = str2.charAt(0);
        int cnt = 0;
        for (char s : str1.toCharArray()) {
            if (s == c) cnt++;
        }

        System.out.println(cnt);
    }

}
