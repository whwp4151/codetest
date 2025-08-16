package inf.bak.binarysearch;

import java.io.*;

public class Bak2417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        bw.write(isExist(N) + "\n");
        bw.flush();
    }

    private static long isExist(long n) {
        long l = 0;
        long r = Long.MAX_VALUE;
        long sqrt = -1;
        while (l <= r) {
            long m = (l + r) / 2;
            if (isSqrt(m, n)) {
                r = m - 1;
                sqrt = m;
            } else {
                l = m + 1;
            }
        }
        return sqrt;
    }

    private static boolean isSqrt(long q, long n) {
        if (q == 0) return n <= 0;

        // q * q가 오버플로 안 나는 경우
        if (q <= Long.MAX_VALUE / q) {
            return q * q >= n;
        }

        // q * q가 오버플로 날 정도로 큰 경우,
        // 무조건 n보다 크다고 봐도 됨 (n < 2^63 조건이 있으므로)
        return true;
    }
}
