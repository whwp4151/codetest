package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bak2573 {

    private static int N, M;
    private static int[][] graph;
    private static List<Ice> iceList = new ArrayList<>();
    private static int year = 0;

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

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
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                int zero = getZero(ice.row, ice.col);
                ice.addYear(zero);
            }

            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    iceList.remove(ice);
                    graph[ice.row][ice.col] = 0;
                    i--;
                }
            }

            year++;
            if (year == 3) {
                break;
            }
        }

        System.out.println(year);
    }

    private static int getZero(int row, int col) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            int ny = row + dy[k];
            int nx = col + dx[k];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }

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
