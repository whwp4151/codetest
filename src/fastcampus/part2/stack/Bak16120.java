package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak16120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        br.close();

        bw.write(solution(s) + "\n");

        bw.flush();
    }

    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);

            if (stack.size() >= 4) {
                int n = stack.size();
                if (stack.get(n - 1) == 'P' &&
                        stack.get(n - 2) == 'A' &&
                        stack.get(n - 3) == 'P' &&
                        stack.get(n - 4) == 'P') {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return (stack.size() == 1 && stack.peek() == 'P') ? "PPAP" : "NP";

    }

}
