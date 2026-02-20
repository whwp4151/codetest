package fastcampus.part3.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak5427 {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] arr = new char[h][w];
            for (int i = 0; i < h; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            bfs(w, h, arr);
        }
        br.close();

        bw.flush();
    }

    private static void bfs(int w, int h, char[][] arr) throws IOException {
        int[][] visited = new int[h][w];
        int[][] fired = new int[h][w];

        fire(w, h, arr, fired);

        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == '@') {
                    queue.add(new Node(i, j));
                    visited[i][j] = 1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        boolean isEscaped = false;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (isExit(poll, w, h)) {
                bw.write(visited[poll.r][poll.c] + "\n");
                isEscaped = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= h || c < 0 || c >= w) {
                    continue;
                }

                if (visited[r][c] == 0 && arr[r][c] == '.') {
                    int time = visited[poll.r][poll.c] + 1;
                    if (fired[r][c] == 0 || time < fired[r][c]) {
                        queue.add(new Node(r, c));
                        visited[r][c] = time;
                    }
                }
            }
        }

        if (!isEscaped) {
            bw.write("IMPOSSIBLE\n");
        }
    }

    private static void fire(int w, int h, char[][] arr, int[][] fired) {
        Queue<Node> fire = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == '*') {
                    fire.add(new Node(i, j));
                    fired[i][j] = 1;
                }
            }
        }

        while (!fire.isEmpty()) {
            Node poll = fire.poll();

            for (int i = 0; i < 4; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= h || c < 0 || c >= w) {
                    continue;
                }

                if (fired[r][c] == 0 && arr[r][c] == '.') {
                    fire.add(new Node(r, c));
                    fired[r][c] = fired[poll.r][poll.c] + 1;
                }
            }
        }
    }

    private static boolean isExit(Node now, int w, int h) {
        return now.r == 0 || now.r == h -1 || now.c == 0 || now.c == w - 1;
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
