package fastcampus.part3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak12851 {

    private static int N;
    private static int K;

    private static int[] visited = new int[100_001];
    private static int[] count = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == K) {
                System.out.println(visited[K]);
                System.out.println(count[K]);
                return;
            }

            int[] next = {poll - 1, poll + 1, poll * 2};
            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) {
                    continue;
                }
                if (visited[next[i]] == 0) {
                    queue.add(next[i]);
                    visited[next[i]] = visited[poll] + 1;
                    count[next[i]] = count[poll];
                } else if (visited[next[i]] == visited[poll] + 1) {
                    count[next[i]] += count[poll];
                }
            }
        }
    }

    private static boolean isRange(int x) {
        return x >= 0 && x < 100_001;
    }

}
