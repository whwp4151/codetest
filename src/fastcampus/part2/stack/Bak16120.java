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
        if (s.equals("P") || s.equals("PPAP")) {
            return "PPAP";
        }

        char[] ppap = new char[]{'P', 'P', 'A', 'P'};

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }

        int j = 3;
        while (!left.isEmpty()) {
            char c = left.pop();
            if (c == ppap[j]) {
                j--;
            } else {
                j = 3;
            }

            if (j < 0) {
                for (int i = 0; i < 4; i++) {
                    right.pop();
                }
                right.push('P');
            } else {
                right.push(c);
            }
        }

        return "PPAP";
    }

}
