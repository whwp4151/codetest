package fastcampus.part2.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Bak10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("push_front")) {
                int X = Integer.parseInt(st.nextToken());
                deque.offerFirst(X);
            } else if (command.equals("push_back")) {
                int X = Integer.parseInt(st.nextToken());
                deque.offerLast(X);
            } else if (command.equals("pop_front")) {
                bw.write(deque.isEmpty() ? "-1\n" : (deque.pollFirst()) + "\n");
            } else if (command.equals("pop_back")) {
                bw.write(deque.isEmpty() ? "-1\n" : (deque.pollLast()) + "\n");
            } else if (command.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write(deque.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("front")) {
                bw.write(deque.isEmpty() ? "-1\n" : (deque.peekFirst()) + "\n");
            } else if (command.equals("back")) {
                bw.write(deque.isEmpty() ? "-1\n" : (deque.peekLast()) + "\n");
            }
        }

        bw.flush();
    }

}
