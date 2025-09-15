package inf.bak.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bak2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == j || k == i) continue;
                    list.add(i * 100 + j * 10 + k);
                }
            }
        }

        while (N-- > 0) {
            List<Integer> temp = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int n : list) {
                int strikeCount = 0;
                int ballCount = 0;

                int[] nDigits = { n / 100, (n / 10) % 10, n % 10 };
                int[] numberDigits = { number / 100, (number / 10) % 10, number % 10 };

                for (int i = 0; i < 3; i++) {
                    if (nDigits[i] == numberDigits[i]) {
                        strikeCount++;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (i != j && nDigits[i] == numberDigits[j]) {
                                ballCount++;
                                break;
                            }
                        }
                    }
                }

                if (strikeCount == strike && ballCount == ball) {
                    temp.add(n);
                }
            }

            list = temp;
        }

        bw.write(list.size() + "\n");
        bw.flush();
    }

}
