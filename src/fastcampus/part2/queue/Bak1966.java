package fastcampus.part2.queue;

import java.io.*;
import java.util.*;

public class Bak1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Node(i, priority));
                priorityQueue.add(priority);
            }

            for (int i = 0; i < N; i++) {
                while (queue.peek().priority < priorityQueue.peek()) {
                    queue.offer(queue.poll());
                }

                if (queue.peek().index == M) {
                    bw.write((i + 1) + "\n");
                    break;
                }

                queue.poll();
                priorityQueue.poll();
            }

        }

        bw.flush();
    }

    private static class Node {
        private int index;
        private int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }

}
