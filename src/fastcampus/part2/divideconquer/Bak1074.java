package fastcampus.part2.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1074 {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve(N, r, c);
        System.out.println(count);
    }

    private static void solve(int N, int r, int c) {
        if (N == 0) {
            return;
        }

        int boardSize = (int) Math.pow(2.0, N);
        int mid = boardSize / 2;

        if (r < mid && c < mid) {
            solve(N - 1, r, c);
        } else if (r < mid && c >= mid) {
            count += mid * mid;
            solve(N - 1, r, c - mid);
        } else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            solve(N - 1, r - mid, c);
        } else {
            count += mid * mid * 3;
            solve(N - 1, r - mid, c - mid);
        }
    }

}
