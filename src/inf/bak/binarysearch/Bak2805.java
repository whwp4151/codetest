package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        int l = 0;
        int r = 2_000_000_000;
        int height = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (sumHeight(arr, m, M)) {
                l = m + 1;
                height = m;
            } else {
                r = m - 1;
            }
        }

        bw.write(height + "");
        bw.flush();
    }

    private static boolean sumHeight(int[] arr, int x, int M) {
        long sum = 0;
        for (int j : arr) {
            if (j > x) {
                sum += j - x;
            }
        }
        return sum >= M;
    }

}
