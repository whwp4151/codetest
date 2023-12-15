package inf.bak;

import java.util.LinkedList;
import java.util.Queue;

public class bak1926 {

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        int[][] num = {
            {1, 1, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1}
        };

        solution(x, y, num);
    }

    public static void solution(int x, int y, int[][] num) {
        int[][] visit = new int[y][x];
        int cnt = 0;
        int max = 0;

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                if (num[i][j] == 1 && visit[i][j] == 0) {
                    // 방문 처리
                    visit[i][j] = 1;

                    // 전체 그림 갯수를 +1
                    cnt++;

                    // BFS > 그림 크기 return
                    int size = 1;
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();

                        int ex = poll.x;
                        int ey = poll.y;
                        for (int n=0; n<4; n++) {
                            int ny = ey + dy[n];
                            int nx = ex + dx[n];

                            if (ny >= 0 && ny < y && nx >= 0 && nx < x) {
                                if (num[ny][nx] == 1 && visit[ny][nx] == 0) {
                                    visit[ny][nx] = 1;
                                    queue.offer(new Node(nx, ny));
                                    size++;
                                }
                            }
                        }
                    }

                    // 최대값 갱신
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
