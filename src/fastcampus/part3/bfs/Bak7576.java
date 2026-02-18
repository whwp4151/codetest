package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak7576 {

    private static int N;
    private static int M;
    private static int[][] arr;
    private static int[][] visited;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    queue.add(new Node(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        int lastR = 0;
        int lastC = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= N || c < 0 || c >= M) {
                    continue;
                }

                if (arr[r][c] == 0 && visited[r][c] == 0) {
                    arr[r][c] = 1;
                    queue.add(new Node(r, c));
                    visited[r][c] = visited[poll.r][poll.c] + 1;
                    lastR = r;
                    lastC = c;
                }
            }
        }

        if (isComplete()) {
            System.out.println(visited[lastR][lastC] - 1);
        } else {
            System.out.println("-1");
        }
    }

    private static boolean isComplete() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
