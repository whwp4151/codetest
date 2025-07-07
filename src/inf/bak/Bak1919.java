package inf.bak;

import java.util.*;

public class Bak1919 {

    public static void main(String[] args) {
        int answer = 0;
        String a = "dared";
        String b = "bread";

        int[] countA = new int[26];
        int[] countB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                answer += Math.abs(countA[i] - countB[i]);
            }
        }

        System.out.println(answer);
    }

}
