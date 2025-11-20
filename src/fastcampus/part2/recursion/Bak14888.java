package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak14888 {

    private static int N;
    private static int[] arr;
    private static int[] num = new int[4];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        recursive(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recursive(int index, int sum) {
        if (index == N) {
            if (max < sum) max = sum;
            if (min > sum) min = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (num[i] > 0) {
                num[i]--;
                if (i == 0) {
                    recursive(index + 1, sum + arr[index]);
                } else if (i == 1) {
                    recursive(index + 1, sum - arr[index]);
                } else if (i == 2) {
                    recursive(index + 1, sum * arr[index]);
                } else {
                    recursive(index + 1, sum / arr[index]);
                }
                num[i]++;
            }
        }
    }

}
