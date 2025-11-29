package fastcampus.part2.recursion;

import java.io.*;

public class Bak10597 {

    private static int N;
    private static char[] arr;
    private static boolean[] check = new boolean[101];
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        N = arr.length <= 9 ? arr.length : (arr.length - 9) / 2 + 9;
        answer = new int[N];

        for (int n : answer) {
            bw.write(n + " ");
        }
        bw.newLine();
        bw.flush();
    }

}
