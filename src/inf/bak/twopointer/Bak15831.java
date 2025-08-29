package inf.bak.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class Bak15831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        br.close();

        int j = 0;
        int answer = 0;
        int whiteCount = 0;
        int blackCount = 0;
        for (int i = 0; i < N; i++) {
            while (j < N) {
                if (arr[j] == 'W') {
                    whiteCount++;
                } else {
                    blackCount++;
                }

                if (whiteCount >= W && blackCount <= B) {
                    answer = Math.max(answer, (j - i + 1));
                }

                if (blackCount > B) {
                    blackCount--;
                    break;
                }

                j++;
            }

            if (arr[i] == 'W') {
                whiteCount--;
            } else {
                blackCount--;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
