package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;

public class Bak2295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sums = new int[N*(N+1)/2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);
        // A + B = X - C
        int answer = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int X = arr[i] - arr[j];
                if (isExist(sums, X)) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        bw.write(answer+"\n");
        bw.flush();
    }

    private static boolean isExist(int[] sums, int x) {
        int l = 0;
        int r = sums.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            if (sums[m] > x) {
                r = m-1;
            } else if (sums[m] < x) {
                l = m+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
