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

            Stack<Integer> stack = map.computeIfAbsent(line, k -> new Stack<>());

            while (!stack.isEmpty()) {
                if (stack.peek() > fret) {
                    answer++;
                    stack.pop();
                } else {
                    break;
                }
            }

            if (stack.isEmpty() || stack.peek() != fret) {
                stack.push(fret);
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
