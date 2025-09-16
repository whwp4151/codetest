package inf.bak.part1;

import java.io.*;
import java.util.StringTokenizer;

public class Bak2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] q_arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q_arr[i][0] = Integer.parseInt(st.nextToken());
            q_arr[i][1] = Integer.parseInt(st.nextToken());
            q_arr[i][2] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == j || k == i) continue;

                    boolean possible = true;
                    for (int n = 0; n < N; n++) {
                        int num = q_arr[n][0];
                        int strike = 0, ball = 0;

                        int nx = num / 100;
                        int ny = (num / 10) % 10;
                        int nz = num % 10;

                        if (nx == i) strike++;
                        else if (nx == j || nx == k) ball++;
                        if (ny == j) strike++;
                        else if (ny == i || ny == k) ball++;
                        if (nz == k) strike++;
                        else if (nz == i || nz == j) ball++;

                        if (q_arr[n][1] != strike || q_arr[n][2] != ball) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        answer++;
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
