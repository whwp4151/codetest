package inf.bak;

import java.util.Scanner;

public class Bak10431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int[][] testCase = new int[P][21];
        for (int i = 0; i < P; i++) {
            for (int j = 0; j < 21; j++) {
                testCase[i][j] = sc.nextInt();
            }
        }

        int[][] answer = new int[P][2];
        for (int i = 0; i < P; i++) {
            answer[i][0] = testCase[i][0];

            for (int j = 2; j < 21; j++) {
                for (int k = j - 1; k >= 1; k--) {
                    if (testCase[i][k] > testCase[i][j]) {
                        answer[i][1]++;
                    }
                }
            }
        }

        for (int i = 0; i < P; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }

}
