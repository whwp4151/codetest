package fastcampus.part2.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bak11725 {

    private static List<Integer>[] tree;
    private static boolean[] check;
    private static int[] answer;
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        check = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        br.close();

        recursion(1);

        for (int i = 2; i < n + 1; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
    }

    private static void recursion(int i) {
        check[i] = true;
        List<Integer> list = tree[i];
        for (int child : list) {
            if (!check[child]) {
                answer[child] = i;
                recursion(child);
            }
        }
    }

}
