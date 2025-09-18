package inf.bak.part1;

import java.io.*;
import java.util.StringTokenizer;

public class Bak15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int cnt = 0;
        int[] count = new int[d+1];
        for (int i = 0; i < k-1; i++) {
            if (count[arr[i]]++ == 0) {
                cnt++;
            }
        }

        int answer = cnt;
        for (int i = 0; i < N; i++) {
            if (count[arr[(i + k - 1) % N]]++ == 0) {
                cnt++;
            }

            answer = Math.max(answer, cnt + (count[c] == 0 ? 1 : 0));

            if (count[arr[i]]-- == 1) {
                cnt--;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
