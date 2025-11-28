package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak17136 {

    private static int[] color = {0, 5, 5, 5, 5, 5};
    private static int[][] arr = new int[10][10];
    private static int curX;
    private static int curY;
    private static int count = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, 0);

        if (count == 26) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void recursive(int x, int y, int cnt) {
        if (count <= cnt) {
            return;
        }

        find(y);
        if (curX == -1 || curY == -1) {
            count = cnt;
            return;
        }

        int r = curY;
        int c = curX;
        for (int size = 1; size <= 5; size++) {
            if (color[size] == 0) {
                continue;
            }
            if (isValid(size, c, r)) {
                color[size]--;
                fill(size, c, r, 0);

                recursive(c, r, cnt + 1);

                color[size]++;
                fill(size, c, r, 1);
            }
        }
    }

    private static boolean isValid(int size, int x, int y) {
        if (x + size > 10 || y + size > 10) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i + y][j + x] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void fill(int size, int x, int y, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i + y][j + x] = color;
            }
        }
    }

    private static void find(int y) {
        for (int i = y; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1) {
                    curX = j;
                    curY = i;
                    return;
                }
            }
        }

        curX = -1;
        curY = -1;
    }

}
