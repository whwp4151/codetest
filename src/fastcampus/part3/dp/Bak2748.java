package fastcampus.part3.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak2748 {

    private static final long[] memory = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        fibo3(n);
    }

    private static long fibo1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] = fibo1(n - 1) + fibo1(n - 2);

        return memory[n];
    }

    private static void fibo2(int n) {
        long[] arr = new long[91];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }

    private static void fibo3(int n) {
        long[] arr = new long[92];
        arr[1] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i+1] = arr[i] + arr[i-1];
        }

        System.out.println(arr[n]);
    }

}
