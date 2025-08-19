package inf.bak.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class Bak6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 100,000
        int M = Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ N
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 1 ≤ 금액 ≤ 10000
        }
        br.close();

        int answer = -1;
        int l = 0;
        int r = N * 10000;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isAmount(arr, m, M)) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static boolean isAmount(int[] arr, int m, int M) {
        int current = m;
        int cnt = 1;
        for (int amount : arr) {
            if (current < amount) {
                current = m;
                cnt++;

                if (current < amount) return false;
            }

            current -= amount;
        }
        return cnt <= M;
    }

}
