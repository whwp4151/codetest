package inf.bak;

import java.io.*;
import java.util.StringTokenizer;

public class Bak10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int height = (N-1) % H + 1;
            int width = (N-1) / H + 1;

            bw.write(String.format("%d%02d\n", height, width));
        }

        bw.flush();
    }

}
