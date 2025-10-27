package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bak1208 {

    private static int N;
    private static int S;
    private static int[] arr;
    private static long answer = 0;
    private static Map<Integer, Integer> map = new HashMap<>();

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

        int k = N / 2;

        recursion(0, 0, k);
        recursion(k, 0, N);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    private static void recursion(int index, int sum, int end) {
        if (index == end) {
            if (index == N) {
                answer += map.getOrDefault(S - sum, 0);
            } else {
                int prev = map.getOrDefault(sum, 0);
                map.put(sum, prev + 1);
            }
        } else {
            recursion(index + 1, sum + arr[index], end);
            recursion(index + 1, sum, end);
        }
    }

}
