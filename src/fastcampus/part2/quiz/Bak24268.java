package fastcampus.part2.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak24268 {

    private static int N;
    private static int d;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[d];

        recursive(0);
    }

    private static void recursive(int depth) {
        if (depth == d) {
            for (int i = 0; i < d; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < d; i++) {
            arr[depth] = i;
            recursive(depth + 1);
        }
    }

}
