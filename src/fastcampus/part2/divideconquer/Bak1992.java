package fastcampus.part2.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak1992 {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        solve(N, 0, 0);
    }

    private static void solve(int N, int r, int c) {
        if (isSame(N, r, c)) {
            System.out.print(arr[r][c]);
            return;
        }

        System.out.print("(");

        int mid = N / 2;
        solve(mid, r, c);
        solve(mid, r, c + mid);
        solve(mid, r + mid, c);
        solve(mid, r + mid, c + mid);

        System.out.print(")");
    }

    private static boolean isSame(int N, int r, int c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[r][c] != arr[r + i][c + j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
