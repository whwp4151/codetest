package fastcampus.part2.queue;

import java.io.*;
import java.util.*;

public class Bak5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Deque<Integer> deque = new LinkedList<>();

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;
            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);
                if (command == 'R') {
                    isReverse = !isReverse;
                } else if (command == 'D') {
                    if (deque.isEmpty()) {
                        bw.write("error\n");
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (!isError) {
                bw.write("[");
                while (!deque.isEmpty()) {
                    bw.write(String.valueOf(isReverse ? deque.pollLast() : deque.pollFirst()));
                    if (!deque.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
    }

}
