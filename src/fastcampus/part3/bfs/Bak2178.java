package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak2178 {

    private static int N;
    private static int M;
    private static int[][] arr;
    private static int[][] visited;

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        br.close();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            boolean flag = false;
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= N || c < 0 || c >= M) {
                    continue;
                }

                if (visited[r][c] == 0 && arr[r][c] == 1) {
                    queue.add(new Node(r, c));
                    visited[r][c] = visited[poll.r][poll.c] + 1;
                }

                if (r == N-1 && c == M-1) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        System.out.println(visited[N-1][M-1]);
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
