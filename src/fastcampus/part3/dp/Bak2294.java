package fastcampus.part3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            dp[i] = 100_001;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <= K) {
                dp[arr[i]] = 1;
            }
        }
        br.close();

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
//                if (i + arr[j] <= K) {
//                    dp[i + arr[j]] = Math.min(dp[i + arr[j]], dp[i] + 1);
//                }
                if (i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        if (dp[K] == 100_001) {
            System.out.println("-1");
        } else {
            System.out.println(dp[K]);
        }
    }

}
