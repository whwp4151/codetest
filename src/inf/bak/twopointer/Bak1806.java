package inf.bak.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class Bak1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int j = 0;
        int sum = arr[0];
        int answer = 100000;
        for (int i = 0; i < N; i++) {
            while (sum < S && j < N - 1) {
                sum += arr[++j];
            }

            if (sum >= S) {
                answer = Math.min(answer, j - i + 1);
            }

            sum -= arr[i];
        }

        if (answer == 100000) {
            bw.write("0\n");
        } else {
            bw.write(answer + "\n");
        }

        bw.flush();
    }

}
