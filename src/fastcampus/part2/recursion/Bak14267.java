package fastcampus.part2.recursion;

import java.io.*;
import java.util.*;

public class Bak14267 {

    private static List<Integer>[] tree;
    private static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        point = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                tree[parent].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            point[index] += w;
        }

        recursion(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(point[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void recursion(int node) {
        List<Integer> list = tree[node];
        for (int child : list) {
            point[child] += point[node];
            recursion(child);
        }
    }

}
