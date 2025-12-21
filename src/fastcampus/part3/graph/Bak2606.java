package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak2606 {

    private static int N, M;
    private static boolean[][] graph;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }

        bfs(1);

        System.out.println(answer);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[poll][i]) {
                    queue.offer(i);
                    answer++;
                    visited[i] = true;
                }
            }
        }
    }

}
