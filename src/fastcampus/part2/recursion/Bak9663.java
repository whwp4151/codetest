package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak9663 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        br.close();

        int answer = recursive(0);
        System.out.println(answer);
    }

    private static int recursive(int row) {
        if (row == N) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < N; col++) {
            if (validate(row, col)) {
                arr[row] = col;
                count += recursive(row + 1);
                System.out.println();
            }
        }

        return count;
    }

    private static boolean validate(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col) {
                return false;
            }

            if (Math.abs(i - row) == Math.abs(arr[i] - col)) {
                return false;
            }
        }

        return true;
    }

}
