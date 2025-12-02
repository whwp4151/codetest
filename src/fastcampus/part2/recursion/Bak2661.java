package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak2661 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        br.close();

        recursive(0);
    }

    private static boolean recursive(int index) {
        if (index == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]);
            }
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            arr[index] = i;
            if (!validate(index)) {
                if (recursive(index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean validate(int index) {
        for (int i = 1; i <= (index + 1) / 2; i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[index - j] != arr[index - i - j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }

}
