package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bak10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("push")) {
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
            } else if (command.equals("pop")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.pop() + "\n");
            } else if (command.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (command.equals("empty")) {
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            } else if (command.equals("top")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
            }
        }

        bw.flush();
    }

}
