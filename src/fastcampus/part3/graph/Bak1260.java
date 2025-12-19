package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bak1260 {

    private static int N;
    private static int[][] tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        tree = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1][n2] = 1;
            tree[n2][n1] = 1;
        }
        br.close();

        dfs(V);

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        System.out.println();

        bfs(V);
        System.out.println();
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (tree[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (int i = 1; i <= N; i++) {
                if (tree[poll][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
