package inf.bak.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class Bak12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        int[] arr = new int[4]; // {‘A’, ‘C’, ‘G’, ‘T’}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] count = new int[4];
        for (int i = 0; i < P-1; i++) {
            count[getIndex(dna[i])]++;
        }

        int answer = 0;
        for (int i = P - 1; i < S; i++) {
            count[getIndex(dna[i])]++;

            if (isCorrect(count, arr)) {
                answer++;
            }

            count[getIndex(dna[i - P + 1])]--;
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static int getIndex(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean isCorrect(int[] count, int[] arr) {
        for (int i = 0; i < 4; i++) {
            if (count[i] < arr[i]) {
                return false;
            }
        }
        return true;
    }

}
