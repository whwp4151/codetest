package fastcampus.part3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak2624 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[k + 1][T + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            for (int value = 0; value <= T; value++) {
                for (int j = 0; j <= cnt; j++) {
                    int next = value + coin * j;
                    if (next > T) {
                        break;
                    }

                    dp[i][next] += dp[i - 1][value];
                }
            }
        }

        System.out.println(dp[k][T]);
    }

}
