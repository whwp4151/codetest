package inf.bak.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class Bak16713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] prefix = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] ^ arr[i];
        }

        int answer = 0;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            answer ^= prefix[j] ^ prefix[i-1];
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
