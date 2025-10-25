package fastcampus.part2.recursion;

import java.util.*;
import java.io.*;

public class Bak1182 {

    private static int N;
    private static int S;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0);
        System.out.println(answer);
    }

    private static void recursion(int index, int sum) {
        if (index == N) return;
        if (sum + arr[index] == S) answer++;

        recursion(index + 1, sum + arr[index]);
        recursion(index + 1, sum);
    }

}
