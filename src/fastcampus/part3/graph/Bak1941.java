package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak1941 {

    private static char[][] graph = new char[5][5];
    private static boolean[][] visited = new boolean[5][5];
    private static char[] checked = new char[7];
    private static int answer = 0;

    private static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int row, int col, int index) {
        if (index >= 7) {
            int cnt = 0;
            for (char c : checked) {
                if (c == 'S') {
                    cnt++;
                }
            }

            if (cnt >= 4) {
                answer++;
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = row + dy[k];
            int nx = col + dx[k];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            checked[index] = graph[ny][nx];
            visited[ny][nx] = true;
            dfs(ny, nx, index + 1);
            visited[ny][nx] = false;
        }
    }

}
