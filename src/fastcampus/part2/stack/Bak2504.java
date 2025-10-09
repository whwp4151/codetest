package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        br.close();
        bw.write(solution(s) + "\n");

        bw.flush();
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return 0;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return 0;
                }
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        int answer = 0;
        int currentMultiple = 1;
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int value;
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                value = 2;
            } else {
                value = 3;
            }

            if (c == '(' || c == '[') {
                stack2.push(value);
                currentMultiple *= value;
            } else {
                if (s.charAt(i-1) == '(' || s.charAt(i-1) == '[') {
                    answer += currentMultiple;
                }
                currentMultiple /= value;
            }
        }

        return answer;
    }

}
