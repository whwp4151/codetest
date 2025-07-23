package inf.bak;

import java.io.*;
import java.util.StringTokenizer;

public class Bak11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(Integer.toString(N, B));

        StringBuilder answer = new StringBuilder();
        while (N > 0) {
            int i = N % B;
            if (i >= 10) {
                answer.append((char) (i - 10 + 'A'));
            } else {
                answer.append(i);
            }
            N /= B;
        }

        bw.write(answer.reverse() + "\n");
        bw.flush();
    }

}
