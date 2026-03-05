package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak1194 {

    private static int N;
    private static int M;
    private static char[][] arr;
    private static int[][][] visited;

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new int[N][M][1 << 6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        br.close();

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '0') {
                    queue.add(new Node(i, j, 0));
                    visited[i][j][0] = 1;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (arr[poll.r][poll.c] == '1') {
                System.out.println(visited[poll.r][poll.c][poll.key] - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= N || c < 0 || c >= M) {
                    continue;
                }

                if (arr[r][c] != '#' && visited[r][c][poll.key] == 0) {
                    if (arr[r][c] == '.' || arr[r][c] == '0' || arr[r][c] == '1') {
                        queue.add(new Node(r, c, poll.key));
                        visited[r][c][poll.key] = visited[poll.r][poll.c][poll.key] + 1;
                    } else if (arr[r][c] >= 'A' && arr[r][c] <= 'F') {
                        if ((poll.key & (1 << (arr[r][c] - 'A'))) == 0) {
                            continue;
                        }
                        queue.add(new Node(r, c, poll.key));
                        visited[r][c][poll.key] = visited[poll.r][poll.c][poll.key] + 1;
                    } else {
                        int nextKey = poll.key | (1 << (arr[r][c] - 'a'));
                        queue.add(new Node(r, c, nextKey));
                        visited[r][c][nextKey] = visited[poll.r][poll.c][poll.key] + 1;
                    }
                }
            }
        }

        System.out.println("-1");
    }

    private static class Node {
        int r, c;
        int key;

        public Node(int r, int c, int key) {
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }

}
