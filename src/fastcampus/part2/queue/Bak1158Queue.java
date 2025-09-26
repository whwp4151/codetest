package fastcampus.part2.queue;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Bak1158Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            i++;
            if (i == K) {
                i = 0;
                answer.add(poll);
            } else {
                queue.add(poll);
            }
        }

        String collect = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        bw.write("<" + collect + ">\n");
        bw.flush();
    }

}
