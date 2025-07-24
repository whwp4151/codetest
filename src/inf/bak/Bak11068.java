package inf.bak;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bak11068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T  = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            boolean answer = isPalindromeNumber(N);

            bw.write(answer ? "1\n" : "0\n");
        }

        bw.flush();
    }

    private static boolean isPalindromeNumber(int N) {
        for (int B = 2; B <= 64; B++) {
            int n = N;
            List<String> result = new ArrayList<>();
            while (n != 0) {
                int digit = n % B;
                result.add(String.valueOf(digit));
                n /= B;
            }

            boolean isPalindrome = true;
            for (int i = 0; i < result.size() / 2; i++) {
                if (!result.get(i).equals(result.get(result.size() - 1 - i))) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                return true;
            }
        }

        return false;
    }

}
