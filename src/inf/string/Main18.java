package inf.string;

import java.util.Locale;
import java.util.Scanner;

public class Main18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        str = str.toLowerCase();

        int lt = 0;
        int rt = str.length() - 1;
        String answer = "YES";
        while (lt < rt) {
            char lc = str.charAt(lt);
            char rc = str.charAt(rt);

            if (!Character.isAlphabetic(lc)) {
                lt++;
            } else if (!Character.isAlphabetic(rc)) {
                rt--;
            } else if (lc != rc) {
                answer = "NO";
                break;
            } else {
                lt++;
                rt--;
            }
        }

        System.out.println(answer);
    }

}
