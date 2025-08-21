package inf.bak.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class Bak2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 1 ≤ N ≤ 10,000
        int M = Integer.parseInt(st.nextToken());   // 1 ≤ M ≤ 300,000,000

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int j = 0;
        int sum = arr[0];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (sum < M && j < N - 1) {
                sum += arr[++j];
            }

            if (sum == M) {
                answer++;
            }

            sum -= arr[i];
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
