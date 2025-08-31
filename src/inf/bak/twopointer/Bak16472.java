package inf.bak.twopointer;

import java.io.*;

public class Bak16472 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        br.close();

        int L = arr.length;
        int j = 0;
        int answer = 0;
        int[] count = new int[26];
        for (int i = 0; i < L; i++) {
            while (j < L) {
                count[arr[j++] - 'a']++;

                if (isCount(count, N)) {
                    count[arr[--j] - 'a']--;
                    break;
                }
            }

            answer = Math.max(answer, j - i);

            count[arr[i] - 'a']--;
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static boolean isCount(int[] count, int N) {
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                cnt++;
            }
        }

        return cnt > N;
    }

}
