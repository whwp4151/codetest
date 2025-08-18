package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 1이상 10,000이하
        int N = Integer.parseInt(st.nextToken()); // 1이상 1,000,000이하
        int[] arr = new int[K]; // 2^31-1

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long l = 0;
        long r = Integer.MAX_VALUE;
        long answer = -1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (getSum(arr, m, N)) {
                l = m + 1;
                answer = m;
            } else {
                r = m - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static boolean getSum(int[] arr, long m, int N) {
        long sum = 0;
        for (int len : arr) {
            sum += len / m;
        }
        return sum >= N;
    }

}
