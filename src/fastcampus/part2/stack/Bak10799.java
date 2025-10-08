package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        br.close();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (i < s.length() - 1 && s.charAt(i+1) == ')') {
                    answer += stack.size();
                    i++;
                } else {
                    stack.push(c);
                    answer++;
                }
            } else {
                stack.pop();
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
