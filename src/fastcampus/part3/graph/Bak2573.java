package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bak2573 {

    private static int N, M;
    private static int[][] graph;
    private static List<Ice> iceList = new ArrayList<>();
    private static boolean[][] visited;
    private static int year = 1;

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > 0) {
                    iceList.add(new Ice(i, j, graph[i][j]));
                }
            }
        }
        br.close();


        while (true) {
            year++;
            for (Ice ice : iceList) {
                int zero = getZero(ice.row, ice.col);
                ice.addYear(zero);
            }

            for (int i = iceList.size() - 1; i >= 0; i--) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    iceList.remove(i);
                    graph[ice.row][ice.col] = 0;
                } else {
                    visited[ice.row][ice.col] = false;
                }
            }


            if (iceList.isEmpty()) {
                year = 0;
                break;
            }

            Ice first = iceList.get(0);
            if (dfs(first.row, first.col) != iceList.size()) {
                break;
            }
        }

        System.out.println(year);
    }

    private static int dfs(int row, int col) {
        int size = 1;
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int ny = row + dy[k];
            int nx = col + dx[k];

            if (visited[ny][nx]) {
                continue;
            }

            if (graph[ny][nx] != 0) {
                size += dfs(ny, nx);
            }
        }

        return size;
    }

    private static int getZero(int row, int col) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int ny = row + dy[k];
            int nx = col + dx[k];

            if (graph[ny][nx] == 0) {
                count++;
            }
        }
        return count;
    }

    private static class Ice {
        int row;
        int col;
        int height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public void addYear(int count) {
            this.height -= count;
        }
    }

}
