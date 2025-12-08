package fastcampus.part2.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1780 {

    private static int[][] arr;
    private static int cnt1 = 0;
    private static int cnt2 = 0;
    private static int cnt3 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(N, 0, 0);

        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
    }

    private static void solve(int N, int r, int c) {
        if (isSame(N, r, c)) {
            if (arr[r][c] == 0) {
                cnt2++;
            } else if (arr[r][c] == 1) {
                cnt3++;
            } else {
                cnt1++;
            }
            return;
        }

        int length = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solve(length, r + i * length, c + j * length);
            }
        }
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
