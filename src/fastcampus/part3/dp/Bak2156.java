package fastcampus.part3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[][] dp = new int[3][n];
        dp[1][0] = arr[0];
        dp[2][0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
            dp[1][i] = dp[0][i-1] + arr[i];
            dp[2][i] = dp[1][i-1] + arr[i];
        }

        System.out.println(Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]));
    }

}
