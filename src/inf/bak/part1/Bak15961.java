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

        int answer = 0;
        int cnt = 0;
        int j = k-1;
        int[] count = new int[d+1];
        for (int i = 0; i < k-1; i++) {
            if (count[arr[i]] == 0) {
                cnt++;
            }
            count[arr[i]]++;
        }
        for (int i = 0; i < N - k + 1; i++) {
            if (count[arr[j]] == 0) {
                cnt++;
            }

            count[arr[j]]++;

            j++;

            boolean isCoupon = false;
            if (count[c] == 0) {
                count[c]++;
                isCoupon = true;
                cnt++;
            }

            answer = Math.max(answer, cnt);

            if (isCoupon) {
                count[c]--;
                cnt--;
            }

            if (count[arr[i]] == 1) {
                cnt--;
            }
            count[arr[i]]--;
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
