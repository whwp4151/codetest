package fastcampus.part2.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bak1167 {

    private static int V;
    private static List<Node>[] tree;
    private static int max = 0;
    private static int maxNode = 1;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }

                int length = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(n, length));
            }
        }

        visited[1] = true;
        recursive(1, 0);

        for (int i = 1; i <= V; i++) {
            visited[i] = false;
        }
        max = 0;
        visited[maxNode] = true;
        recursive(maxNode, 0);

        System.out.println(max);
    }

    private static void recursive(int index, int length) {
        if (max < length) {
            max = length;
            maxNode = index;
        }

        for (Node node : tree[index]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                recursive(node.num, node.length + length);
            }
        }

    }

    private static class Node {
        int num;
        int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }

}
