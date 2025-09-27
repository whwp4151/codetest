package fastcampus.part2.queue;

import java.io.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bak15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedBlockingQueue<>(N);

        while (true) {
            int input = Integer.parseInt(br.readLine());

            if (input > 0) {
//                queue.add(input); // add면 예외 발생
                queue.offer(input);
            } else if (input == 0) {
                queue.poll();
            } else {
                break;
            }
        }

        if (queue.isEmpty()) {
            bw.write("empty");
        } else {
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + " ");
            }
        }
        bw.newLine();
        bw.flush();
    }

}
