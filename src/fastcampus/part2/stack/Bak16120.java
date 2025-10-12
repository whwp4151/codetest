package fastcampus.part2.stack;

import java.io.*;

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

        char[] input = s.toCharArray();
        char[] stack = new char[input.length];
        int j = 0;
        for (char c : input) {
            stack[j++] = c;
            if (j >= 4 && stack[j-1] == 'P' && stack[j-2] == 'A' &&
                    stack[j-3] == 'P' && stack[j-4] == 'P') {
                j -= 3;
            }
        }

        return j == 1 && stack[0] == 'P' ? "PPAP" : "NP";
    }

}
