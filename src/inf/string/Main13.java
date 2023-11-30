package inf.string;

import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String[] split = str.split("\\s");
        String answer = "";
        int max = 0;
        for (String s : split) {
            if (max < s.length()) {
                max = s.length();
                answer = s;
            }
        }

        System.out.println(answer);
    }

}
