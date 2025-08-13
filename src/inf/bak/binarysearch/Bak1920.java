package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        int[] xarr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            xarr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i < M; i++) {
            bw.write(isExist(arr, xarr[i]) + "\n");
        }

        bw.flush();
    }

    private static int isExist(int[] arr, int X) {
        int l = 0;
        int r = arr.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            if (arr[m] > X) {
                r = m-1;
            } else if (arr[m] < X) {
                l = m+1;
            } else {
                return 1;
            }
        }

        return 0;
    }

}
