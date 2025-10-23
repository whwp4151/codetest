package fastcampus.part2.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bak15681 {

    private static List<Integer>[] tree;
    private static boolean[] check;
    private static int[] child;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        check = new boolean[N + 1];
        child = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        child[R] = recursion(R);

        for (int i = 0; i < Q; i++) {
            bw.write(child[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
    }

    private static int recursion(int node) {
        if (child[node] != 0) {
            return child[node];
        }

        check[node] = true;
        List<Integer> list = tree[node];
        int count = 1;
        for (int i : list) {
            if (!check[i]) {
                count += recursion(i);
            }
        }

        child[node] = count;
        return count;
    }

}
