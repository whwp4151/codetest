package inf.bak.list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bak1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int currentIndex = 0;
        for (int i = 0; i < N; i++) {
            currentIndex = (currentIndex + K - 1) % list.size();
            answer.add(list.remove(currentIndex));
        }

        String collect = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        bw.write("<" + collect + ">\n");
        bw.flush();
    }

}
