package inf.bak.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class Bak19951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+2];
        int[] prefix = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            prefix[a] += k;
            prefix[b+1] -= k;
        }

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i] + prefix[i-1];
            bw.write(arr[i] + prefix[i] + " ");
        }

        bw.flush();
    }

}
