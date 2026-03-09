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
            boolean[] visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solution(n, arr, visited);
        }

        bw.flush();
    }

    private static void solution(int n, int[] arr, boolean[] visited) {

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, arr, visited);
            }
        }
    }

    private static void dfs(int index, int[] arr, boolean[] visited) {
        visited[index] = true;
        if (!visited[arr[index]]) {
            dfs(arr[index], arr, visited);
        }
    }

}
