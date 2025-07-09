package inf.bak;

import java.util.Scanner;

public class Bak1543 {

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        String doc = "aaaaaaaa";
        String str = "aaa";
        int i = 0;
        while (true) {
            int i1 = doc.indexOf(str, i);
            if (i1 < 0) {
                break;
            }

            answer++;
            i = i1 + str.length();
        }

        System.out.println(answer);
    }

}
