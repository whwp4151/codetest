package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        String[] xarr = new String[M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            xarr[i] = br.readLine();
        }
        br.close();

        Arrays.sort(arr);

        int answer = 0;
        for (String x : xarr) {
            if (isExist(arr, x)) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static boolean isExist(String[] arr, String X) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int compare = arr[m].compareTo(X);
            if (compare > 0) {
                r = m - 1;
            } else if (compare < 0) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
