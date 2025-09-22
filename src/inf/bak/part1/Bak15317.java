package inf.bak.part1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak15317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] budget = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(cost);
        Arrays.sort(budget);

        int answer = 0;
        int l = 0;
        int r = Math.min(N, M);
        while (l <= r) {
            int m = (l + r) / 2;
            if (getMinimumSupport(cost, budget, m) <= X) {
                answer = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static long getMinimumSupport(int[] cost, int[] budget, int m) {
        long needSupport = 0;

        for (int i = 0; i < m; i++) {
            needSupport += Math.max(cost[i] - budget[budget.length - m + i], 0);
        }

        return needSupport;
    }

}
