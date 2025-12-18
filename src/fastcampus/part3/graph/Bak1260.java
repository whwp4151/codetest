package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bak1260 {

    private static List<Integer>[] tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            Collections.sort(tree[i]);
        }

        dfs(V);

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        System.out.println();

        bfs(V);
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    private static void bfs(int node) {
        for (int child : tree[node]) {
            if (!visited[child]) {
                System.out.print(child + " ");
                visited[child] = true;
                bfs(child);
            }
        }
    }

}
