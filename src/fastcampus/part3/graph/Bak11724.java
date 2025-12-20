package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak11724 {

    private static int N;
    private static int answer = 0;
    private static int[][] tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1][node2] = 1;
            tree[node2][node1] = 1;
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(answer);
    }

    private static void bfs(int node) {
        if (!visited[node]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(node);
            visited[node] = true;
            answer++;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();

                for (int i = 1; i <= N; i++) {
                    if (!visited[i] && tree[poll][i] == 1) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

}
