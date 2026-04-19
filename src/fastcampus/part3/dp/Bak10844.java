package fastcampus.part3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int mod = 1_000_000_000;
        int[][] dp = new int[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % mod;
        }
        System.out.println(answer);
    }

}
