package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak10971 {

    private static int N;
    private static int[][] arr;
    private static boolean[] check;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            recursive(i, 0, 0, 0);
        }

        System.out.println(MIN);
    }

    private static void recursive(int start, int node, int sum, int cnt) {
        if (cnt == N && start == node) {
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i] && arr[node][i] != 0) {
                check[i] = true;
                recursive(start, i, sum + arr[node][i], cnt + 1);
                check[i] = false;
            }
        }
    }

}
