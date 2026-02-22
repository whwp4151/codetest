package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak2206 {

    private static int N;
    private static int M;
    private static int[][] arr;
    private static int[][][] visited;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = charArray[j] - '0';
            }
        }
        br.close();

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        boolean isEscapes = false;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.r == N -1 && poll.c == M - 1) {
                isEscapes = true;
                System.out.println(visited[poll.r][poll.c][poll.isBreak]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= N || c < 0 || c >= M) {
                    continue;
                }

                if (visited[r][c][poll.isBreak] == 0) {
                    if (arr[r][c] == 0) {
                        visited[r][c][poll.isBreak] = visited[poll.r][poll.c][poll.isBreak] + 1;
                        queue.add(new Node(r, c, poll.isBreak));
                    } else if (arr[r][c] == 1 && poll.isBreak == 0) {
                        visited[r][c][1] = visited[poll.r][poll.c][poll.isBreak] + 1;
                        queue.add(new Node(r, c, 1));
                    }
                }
            }
        }

        if (!isEscapes) {
            System.out.println("-1");
        }
    }

    private static class Node {
        int r, c;
        int isBreak;
        public Node(int r, int c, int isBreak) {
            this.r = r;
            this.c = c;
            this.isBreak = isBreak;
        }
    }

}
