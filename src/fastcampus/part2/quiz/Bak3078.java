package fastcampus.part2.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak3078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int[] size = new int[21];
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int input = br.readLine().length();
            queue.add(input);

            answer += size[input];

            size[input]++;

            if (queue.size() > K) {
                int poll = queue.poll();
                size[poll]--;
            }
        }

        System.out.println(answer);
    }

}
