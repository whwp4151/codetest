package inf.bak.twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int j = 0;
        long answer = 2000000001;
        for (int i = 0; i < N; i++) {
            long sub = arr[j] - arr[i];
            while (sub < M  && j < N - 1) {
                sub = arr[++j] - arr[i];
            }

            if (sub > M) {
                answer = Math.min(answer, sub);
            } else if (sub == M) {
                answer = sub;
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
