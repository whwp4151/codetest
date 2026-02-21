package fastcampus.part3.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak9019 {

    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }

        bw.flush();
    }

    private static void bfs(int A, int B) throws IOException {
        int[] visited = new int[10_000];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, ""));
        visited[A] = 1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.value == B) {
                bw.write(poll.command + "\n");
                break;
            }

            int d = (poll.value * 2) % 10000;
            if (visited[d] == 0) {
                queue.add(new Node(d, poll.command + "D"));
                visited[d] = 1;
            }

            int s = (poll.value == 0) ? 9999 : poll.value - 1;
            if (visited[s] == 0) {
                queue.add(new Node(s, poll.command + "S"));
                visited[s] = 1;
            }

            int l = (poll.value % 1000) * 10 + (poll.value / 1000);
            if (visited[l] == 0) {
                queue.add(new Node(l, poll.command + "L"));
                visited[l] = 1;
            }

            int r = (poll.value % 10) * 1000 + (poll.value / 10);
            if (visited[r] == 0) {
                queue.add(new Node(r, poll.command + "R"));
                visited[r] = 1;
            }

        }
    }

    private static class Node {
        int value;
        String command;
        public Node(int value, String command) {
            this.value = value;
            this.command = command;
        }
    }

}
