package fastcampus.part2.queue;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bak1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new Node(i, Integer.parseInt(st.nextToken())));
            }

            System.out.println(queue);

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

    private static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            if (n1.priority > n2.priority) {
                return -1;
            } else if (n1.priority < n2.priority) {
                return 1;
            } else {
                if (n1.index > n2.index) {
                    
                }
            }
        }
    }

}
