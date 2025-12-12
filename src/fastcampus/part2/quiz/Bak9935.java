package fastcampus.part2.quiz;

import java.io.*;
import java.util.Stack;

public class Bak9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        String bomb = br.readLine();
        br.close();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);

            if (stack.size() < bomb.length()) {
                continue;
            }

            boolean isSame = true;
            for (int j = 0; j < bomb.length(); j++) {
                int n = stack.size();
                if (stack.get(n - bomb.length() + j) != bomb.charAt(j)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            for (char c : stack) {
                bw.write(c);
            }
        }

        bw.newLine();
        bw.flush();
    }

}
