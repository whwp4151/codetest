package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        int leftValue = 0;
        int rightValue = 0;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int temp = isExist(arr, i);
            int abs = Math.abs(arr[i] + temp);
            if (abs < minAbs) {
                minAbs = abs;
                leftValue = arr[i];
                rightValue = temp;
            }
        }

        bw.write(leftValue + " " + rightValue);
        bw.flush();
    }

    private static int isExist(int[] arr, int i) {
        int l = i + 1;
        int r = arr.length - 1;
        int minAbs = Integer.MAX_VALUE;
        int minIndex = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            int abs = arr[m] + arr[i];
            if (abs > 0) {
                r = m - 1;
            } else if (abs < 0) {
                l = m + 1;
            } else {
                return arr[m];
            }

            abs = Math.abs(abs);
            if (abs < minAbs) {
                minAbs = abs;
                minIndex = m;
            }
        }
        return arr[minIndex];
    }

}
