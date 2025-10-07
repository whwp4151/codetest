package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            bw.write(solution(s) + "\n");
        }

        bw.flush();
    }

    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "no";
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return "no";
                }
            }
        }

        return stack.isEmpty() ? "yes" : "no";
    }

}
