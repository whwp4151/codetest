package fastcampus.part2.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bak10597 {

    private static int N;
    private static char[] arr;
    private static boolean[] check = new boolean[101];
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        N = arr.length <= 9 ? arr.length : (arr.length - 9) / 2 + 9;

        recursive(0);
    }

    private static void recursive(int index) {
        if (index >= arr.length) {
            for (int n : answer) {
                System.out.print(n + " ");
            }
            System.exit(0);
        }

        int num1 = getInt(index, index);
        if (!check[num1]) {
            if (num1 > N) return;

            check[num1] = true;
            answer.add(num1);
            recursive(index + 1);
            answer.remove(answer.size() - 1);
            check[num1] = false;
        }

        if (index + 1 < arr.length) {
            int num2 = getInt(index, index + 1);
            if (!check[num2]) {
                if (num2 > N) return;

                check[num2] = true;
                answer.add(num2);
                recursive(index + 2);
                answer.remove(answer.size() - 1);
                check[num2] = false;
            }
        }
    }

    private static int getInt(int start, int end) {
        if (start == end) {
            String s = String.valueOf(arr[start]);
            return Integer.parseInt(s);
        }

        String s = String.valueOf(arr[start]) + arr[end];
        return Integer.parseInt(s);
    }

}
