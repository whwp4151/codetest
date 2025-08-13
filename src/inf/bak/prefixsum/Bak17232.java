package inf.bak.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class Bak17232 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[][] map = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        while (T-- > 0) {
            int[][] acc = getAcc(map);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getNearAlive(acc, i, j, K);
                    if (map[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < A || B < nearAlive) {
                            map[i][j] = '.';
                        }
                    } else if (A < nearAlive && nearAlive <= B) {
                        map[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                bw.write(map[i][j]+"");
            }
            bw.newLine();
        }

        bw.flush();
    }

    private static int getNearAlive(int[][] acc, int r, int c, int k) {
        int r1 = Math.max(r - k, 1);
        int c1 = Math.max(c - k, 1);
        int r2 = Math.min(r + k, acc.length - 1);
        int c2 = Math.min(c + k, acc[0].length - 1);
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }

    private static int[][] getAcc(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + (map[i][j] == '*' ? 1 : 0);
            }
        }

        return acc;
    }

}
