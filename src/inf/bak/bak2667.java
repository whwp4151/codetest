package inf.bak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bak2667 {
    static int n;
    static int[][] num;
    static int[][] visit;
    static int cnt;
    static List<Integer> list;
    static int size;

    //                오 아래 왼 위
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        n = 7;
        num = new int[][]{
            {0, 1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 0, 0}
        };

        solution();
    }

    public static void solution() {
        visit = new int[n][n];
        cnt = 0;
        list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (num[i][j] == 1 && visit[i][j] == 0) {
                    cnt++;
                    size = 1;
                    DFS(i, j);
                    list.add(size);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    public static void DFS(int i, int j) {
        visit[i][j] = 1;

        for (int k=0; k<4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (num[ny][nx] == 1 && visit[ny][nx] == 0) {
                    size++;
                    DFS(ny, nx);
                }
            }
        }
    }

}
