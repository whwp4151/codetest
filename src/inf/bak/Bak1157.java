package inf.bak;

import java.util.Scanner;

public class Bak1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] counts = new int[26];
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.println((char)(i + 'A') + ": " + counts[i]);
        }

        int max = -1;
        char maxChar = '?';
        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) {
                max = counts[i];
                maxChar = (char) (i + 'A');
            } else if (counts[i] == max) {
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
    }

}
