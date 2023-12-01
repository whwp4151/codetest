package inf.string;

import java.util.Scanner;

public class Main110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] split = str.split(" ");

        String s = split[0];
        char t = split[1].charAt(0);
        int[] list = new int[s.length()];

        int min = 1000;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t) {
                min = 0;
            }
            list[i] = min++;
        }

        min = 1000;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == t) {
                min = 0;
            }
            list[i] = Math.min(min++, list[i]);
        }

        for (int i : list) {
            System.out.print(i + " ");
        }

    }

}
