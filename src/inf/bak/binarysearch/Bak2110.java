package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 2 ≤ N ≤ 200,000
        int C = Integer.parseInt(st.nextToken());   // 2 ≤ C ≤ N
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 0 ≤ xi ≤ 1,000,000,000
        }
        br.close();

        Arrays.sort(arr);

        int l = 0;
        int r = arr[N-1];
        int answer = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isCount(arr, m, C)) {
                l = m + 1;
                answer = m;
            } else {
                r = m - 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static boolean isCount(int[] arr, int m, int C) {
        int cnt = 1;
        int current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = current + m;
            if (temp <= arr[i]) {
                cnt++;
                current = arr[i];
            }
        }
        return cnt >= C;
    }

}
