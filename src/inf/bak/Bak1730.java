package inf.bak;

import java.io.*;

public class Bak1730 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] move = br.readLine().toCharArray();
        br.close();

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '.';
            }
        }
        int y = 0;
        int x = 0;
        for (char m : move) {
            if (m == 'U') {
                if (y > 0) {
                    if (map[y][x] == '.' || map[y][x] == '|') {
                        map[y][x] = '|';
                    } else {
                        map[y][x] = '+';
                    }

                    y--;

                    if (map[y][x] == '.' || map[y][x] == '|') {
                        map[y][x] = '|';
                    } else {
                        map[y][x] = '+';
                    }
                }
            } else if (m == 'D') {
                if (y < N - 1) {
                    if (map[y][x] == '.' || map[y][x] == '|') {
                        map[y][x] = '|';
                    } else {
                        map[y][x] = '+';
                    }

                    y++;

                    if (map[y][x] == '.' || map[y][x] == '|') {
                        map[y][x] = '|';
                    } else {
                        map[y][x] = '+';
                    }
                }
            } else if (m == 'L') {
                if (x > 0) {
                    if (map[y][x] == '.' || map[y][x] == '-') {
                        map[y][x] = '-';
                    } else {
                        map[y][x] = '+';
                    }

                    x--;

                    if (map[y][x] == '.' || map[y][x] == '-') {
                        map[y][x] = '-';
                    } else {
                        map[y][x] = '+';
                    }
                }
            } else if (m == 'R') {
                if (x < N - 1) {
                    if (map[y][x] == '.' || map[y][x] == '-') {
                        map[y][x] = '-';
                    } else {
                        map[y][x] = '+';
                    }
                    x++;

                    if (map[y][x] == '.' || map[y][x] == '-') {
                        map[y][x] = '-';
                    } else {
                        map[y][x] = '+';
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
    }

}
