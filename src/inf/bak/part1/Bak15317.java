package inf.bak.part1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak15317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] budget = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(cost);
        Arrays.sort(budget);

        int left = 0;
        for (int i = 0; i < M; i++) {
            if (budget[i] >= cost[left]) {
                left++;
                if (left >= N) {
                    break;
                }
            }else if (X > 0 && cost[left] - budget[i] <= X) {
                X -= (cost[left] - budget[i]);
                left++;
                if (left >= N) {
                    break;
                }
            }
        }

        bw.write(left + "\n");
        bw.flush();
    }

}
