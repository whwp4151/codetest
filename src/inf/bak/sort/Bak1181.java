package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        br.close();

        List<String> distinct = new ArrayList<>(words);
        distinct.sort((s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() > s2.length()) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });

        for (String word : distinct) {
            bw.write(word);
            bw.newLine();
        }

        bw.flush();
    }

}
