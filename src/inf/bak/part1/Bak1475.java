package inf.bak.part1;

import java.io.*;

public class Bak1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        br.close();

        int[] arr = new int[10];
        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';
            arr[n]++;
        }

        int answer = 1;
        for (int i = 0; i < 9; i++) {
            int cnt = arr[i];
            if (i == 6) {
                int temp = (int) Math.round((arr[i] + arr[9]) / 2.0);
                answer = Math.max(answer, temp);
            } else if (cnt >= 2) {
                answer = Math.max(answer, cnt);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
