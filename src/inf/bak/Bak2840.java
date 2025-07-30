package inf.bak;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        int wheelIndex = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            wheelIndex = ((wheelIndex - S) % N + N) % N;
            if (wheel[wheelIndex] == '?') {
                wheel[wheelIndex] = c;
            } else if (wheel[wheelIndex] != c) {
                System.out.println("!");
                return;
            }
        }

        boolean[] used = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') continue;
            if (used[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            used[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < N; i++) {
            bw.write(wheel[(wheelIndex + i) % N]);
        }

        bw.flush();
    }

}
