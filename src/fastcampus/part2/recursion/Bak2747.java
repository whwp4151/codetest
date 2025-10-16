package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak2747 {

    private static int[] cache = new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(getFibonacci(n));
    }

    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = getFibonacci(n-2) + getFibonacci(n-1);

        return cache[n];
    }

}
