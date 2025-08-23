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

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int j = 0;
        int answer = 2000000001;
        for (int i = 0; i < N; i++) {
            while (arr[j] - arr[i] < M  && j < N - 1) {
                j++;
            }

            int sub = arr[j] - arr[i];
            if (sub >= M) {
                answer = Math.min(answer, sub);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
