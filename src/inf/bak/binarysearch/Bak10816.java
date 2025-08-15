package inf.bak.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] cards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int upperIndex = getUpperIndex(arr, cards[i]);
            int lowerIndex = getLowerIndex(arr, cards[i]);
            bw.write(upperIndex - lowerIndex + " ");
        }

        bw.flush();
    }

    private static int getUpperIndex(int[] arr, int X) {
        int upperIndex = arr.length;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l+r) / 2;
            if (arr[m] <= X) {
                l = m + 1;
            } else {
                r = m - 1;
                upperIndex = m;
            }
        }
        return upperIndex;
    }

    private static int getLowerIndex(int[] arr, int X) {
        int lowerIndex = arr.length;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l+r) / 2;
            if (arr[m] < X) {
                l = m + 1;
            } else {
                r = m - 1;
                lowerIndex = m;
            }
        }
        return lowerIndex;
    }

}
