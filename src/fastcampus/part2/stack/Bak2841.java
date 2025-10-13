package fastcampus.part2.stack;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bak2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Stack<Integer>> map = new HashMap<>();

        int answer = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = map.getOrDefault(line, new Stack<>());

            if (!stack.isEmpty() && stack.peek() >= fret) {
                while (!stack.isEmpty() && stack.peek() > fret) {
                    answer++;
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() != fret) {
                    stack.push(fret);
                    answer++;
                }

            } else {
                stack.push(fret);
                answer++;
            }

            map.put(line, stack);
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
