package fastcampus.part3.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Bak9466 {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            int[] depth = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solution(n, arr, depth);
        }

        bw.flush();
    }

    private static void solution(int N, int[] arr, int[] depth) throws IOException {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (depth[i] == 0) {
                depth[i] = 1;
                count += dfs(i, arr, depth);
            }
        }

        bw.write((N - count) + "\n");
    }

    private static int dfs(int index, int[] arr, int[] depth) {
        int next = arr[index];
        int cycleCnt;
        if (depth[next] == 0) {
            depth[next] = depth[index] + 1;
            cycleCnt = dfs(next, arr, depth);
        } else {
            cycleCnt = depth[index] - depth[next] + 1;
        }

        depth[index] = 100001;
        return Math.max(cycleCnt, 0);
    }

}
