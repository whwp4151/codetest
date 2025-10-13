package fastcampus.part2.stack;

import java.io.*;
import java.util.Stack;

public class Bak1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for (int a : arr) {
            while (a >= num) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.isEmpty() || stack.peek() != a) {
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.printf(sb.toString());
    }

}
