package fastcampus.part2.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak24268 {

    private static int N;
    private static int d;
    private static int[] arr;
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[d];
        checked = new boolean[d];

        int result = recursive(0);
        System.out.println(result);
    }

    private static int recursive(int depth) {
        if (depth == d) {
            return getValue();
        }

        int start = 0;
        if (depth == 0) {
            start = 1;
        }

        for (int i = start; i < d; i++) {
            if (!checked[i]) {
                checked[i] = true;
                arr[depth] = i;
                int result = recursive(depth + 1);
                if (result > N) {
                    return result;
                }
                checked[i] = false;
            }
        }

        return -1;
    }

    private static int getValue() {
        int n = 0;
        for (int i = 0; i < d; i++) {
            n *= d;
            n += arr[i];
        }

        return n;
    }
}
