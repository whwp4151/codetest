package inf.bak;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Bak10448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] triangleNumber = new int[50];
        int idx = 0;
        for (int i = 1; ; i++) {
            int triangle = i * (i + 1) / 2;
            if (triangle > 1000) break; // 최대값 제한
            triangleNumber[idx++] = triangle;
        }

        // 두 수의 합 저장
        Set<Integer> sumOfTwo = new HashSet<>();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx; j++) {
                sumOfTwo.add(triangleNumber[i] + triangleNumber[j]);
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            boolean answer = false;
            for (int j = 0; j < idx; j++) {
                if (sumOfTwo.contains(K - triangleNumber[j])) {
                    answer = true;
                    break;
                }
            }

            bw.write((answer ? "1" : "0") + "\n");
        }
        bw.flush();
    }

}
