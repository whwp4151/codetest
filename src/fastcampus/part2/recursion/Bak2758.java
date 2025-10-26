package fastcampus.part2.recursion;

import java.io.*;
import java.util.*;

public class Bak2758 {

    private static long[][] cache = new long[21][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 2001; j++) {
                cache[i][j] = -1;
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(recursion(n, m) + "\n");
        }

        bw.flush();
    }

    private static long recursion(int n, int m) {
        if (m <= 0) return 0;
        if (n == 1) return m;

        if (cache[n][m] == -1) {
            cache[n][m] = recursion(n - 1, m / 2) + recursion(n, m - 1);
        }

        return cache[n][m];
    }

}
