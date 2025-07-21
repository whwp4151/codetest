package inf.bak;

import java.io.*;

public class Bak3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[1000001];
        String line = br.readLine();
        String[] s = line.split(" ");
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(s[i])]++;
        }
        int x = Integer.parseInt(br.readLine());

        br.close();

        int j=0;
        for (int i=1; i<=1000000; i++) {
            if (count[i] > 0) {
                arr[j++] = i;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int pairValue = x - arr[i];
            if (1 <= pairValue && pairValue <= 1000000) {
                answer += count[pairValue];
            }
        }

        answer /= 2;
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }

}
