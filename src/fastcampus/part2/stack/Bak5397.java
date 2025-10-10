package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else {
                    left.push(c);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                bw.write(right.pop());
            }

            bw.newLine();
        }

        bw.flush();
    }

}
