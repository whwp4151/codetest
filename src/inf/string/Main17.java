package inf.string;

import java.util.Scanner;

public class Main17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        str = str.toLowerCase();

        int lt = 0;
        int rt = str.length()-1;
        String result = "YES";
        while (lt<rt) {
            char lc = str.charAt(lt);
            char rc = str.charAt(rt);

            if (lc != rc) {
                result = "NO";
                break;
            }
            lt++;
            rt--;
        }

        System.out.println(result);
    }

}
