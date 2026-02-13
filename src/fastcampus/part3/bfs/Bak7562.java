package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak7562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] length = new int[T];
        Node[] nows = new Node[T];
        Node[] ends = new Node[T];

        for (int i = 0; i < T; i++) {
            length[i] = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            nows[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            ends[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        for (int i = 0; i < T; i++) {
            bfs(length[i], nows[i], ends[i]);
        }
    }

    private static void bfs(int l, Node now, Node end) {
        int[][] visited = new int[l][l];
        Queue<Node> queue = new LinkedList<>();
        queue.add(now);
        visited[now.r][now.c] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.r == end.r && poll.c == end.c) {
                System.out.println(visited[poll.r][poll.c]);
                return;
            }

            int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
            int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
            for (int i = 0; i < 8; i++) {
                int r = poll.r + dy[i];
                int c = poll.c + dx[i];

                if (r < 0 || r >= l || c < 0 || c >= l) {
                    continue;
                }

                if (visited[r][c] == 0) {
                    queue.add(new Node(r, c));
                    visited[r][c] = visited[poll.r][poll.c] + 1;
                }
            }
        }
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
