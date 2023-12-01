package inf.string;

import java.util.Scanner;

public class Main19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        int answer = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer = answer * 10 + Character.digit(c, 10);
            }
        }

        System.out.println(answer);
    }

}
