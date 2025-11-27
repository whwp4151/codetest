package fastcampus.part2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1987 {

    private static int R;
    private static int C;
    private static int[][] arr;
    private static boolean[] check = new boolean[26];
    private static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];

        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }

        visited[0][0] = 1 << arr[0][0];
        check[arr[0][0]] = true;
        int max = recursive(0, 0);

        System.out.println(max);
    }

    private static int recursive(int y, int x) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }

            int num = arr[ny][nx];
            if (check[num]) {
                continue;
            }

            int route = 1 << num;
            if (visited[ny][nx] == (visited[y][x] | route)) {
                continue;
            }

            visited[ny][nx] = visited[y][x] | route;

            check[num] = true;
            result = Math.max(result, recursive(ny, nx));
            check[num] = false;
        }

        return result + 1;
    }

}
