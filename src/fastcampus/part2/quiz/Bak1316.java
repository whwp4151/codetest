package fastcampus.part2.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            boolean[] checked = new boolean[26];
            String s = br.readLine();

            boolean isGroup = true;
            for (int i = 0; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c == s.charAt(i + 1)) {
                    continue;
                }

                int code = c - 'a';
                if (checked[code]) {
                    isGroup = false;
                    break;
                }

                checked[code] = true;
            }

            int code = s.charAt(s.length() - 1) - 'a';
            if (checked[code]) {
                isGroup = false;
            }

            if (isGroup) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
