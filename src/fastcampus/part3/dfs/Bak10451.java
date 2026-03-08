package fastcampus.part3.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Bak10451 {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            boolean[] visited = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solution(N, arr, visited);
        }

        bw.flush();
    }

    private static void solution(int N, int[] arr, boolean[] visited) throws IOException {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, arr, visited);
                count++;
            }
        }

        bw.write(count + "\n");
    }

    private static void dfs(int index, int[] arr, boolean[] visited) {
        visited[index] = true;
        if (!visited[arr[index]]) {
            dfs(arr[index], arr, visited);
        }
    }

}
