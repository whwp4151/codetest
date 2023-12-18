package inf.bak;

public class bak14503 {

    static int n;
    static int m;
    static int x;
    static int y;
    static int d;   // 0:북쪽 1:동쪽 2:남쪽 3:서쪽
                    // -1,0   0,1   1,0    0,-1
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int count = 1;

    public static void main(String[] args) {
        n = 11;
        m = 10;
        y = 7;
        x = 4;
        d = 0;

        map = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        DFS(y, x, d);
        System.out.println(count);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(int y, int x, int direction) {
        map[y][x] = 2;

        int ny;
        int nx;
        for (int i=0; i<4; i++) {
            direction = (direction + 3) % 4;
            ny = y + dy[direction];
            nx = x + dx[direction];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (map[ny][nx] == 0) {
                    count++;
                    DFS(ny, nx, direction);
                    return;
                }
            }
        }

        int back = (direction + 2) % 4;
        ny = y + dy[back];
        nx = x + dx[back];
        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
            if (map[ny][nx] != 1) {
                DFS(ny, nx, direction);
            }
        }
    }

}
