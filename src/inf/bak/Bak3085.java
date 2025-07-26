package inf.bak;

import java.io.*;

public class Bak3085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    swapCandy(map, i, j, i, j+1);
                    max = Math.max(findMaxCandy(map), max);
                    swapCandy(map, i, j, i, j+1);
                }

                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    swapCandy(map, i, j, i+1, j);
                    max = Math.max(findMaxCandy(map), max);
                    swapCandy(map, i, j, i+1, j);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int findMaxCandy(char[][] map) {
        int max = 0;
        for (char[] chars : map) {
            int cnt = 1;
            char c = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == c) {
                    cnt++;
                } else {
                    c = chars[j];
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        for (int j = 0; j < map[0].length; j++) {
            int cnt = 1;
            char c = map[0][j];
            for (int i = 1; i < map.length; i++) {
                if (map[i][j] == c) {
                    cnt++;
                } else {
                    c = map[i][j];
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }

    private static void swapCandy(char[][] map, int i, int j, int i2, int j2) {
        char temp = map[i][j];
        map[i][j] = map[i2][j2];
        map[i2][j2] = temp;
    }

}
