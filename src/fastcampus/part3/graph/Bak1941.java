package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bak1941 {

    private static char[] graph = new char[25];
    private static boolean[] visited;
    private static List<Integer> list = new ArrayList<>();

    private static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                graph[index++] = s.charAt(j);
            }
        }

        int answer = recursive(0);

        System.out.println(answer);
    }

    private static int recursive(int index) {
        if (list.size() == 7) {
            int cnt = 0;
            for (int i : list) {
                char c = graph[i];
                if (c == 'S') {
                    cnt++;
                }
            }

            if (cnt < 4) {
                return 0;
            }

            visited = new boolean[7];
            if (dfs(0) == 7) {
                return 1;
            }

            return 0;
        }

        if (index >= 25) {
            return 0;
        }

        int ret = recursive(index + 1);

        list.add(index);
        ret += recursive(index + 1);
        list.remove(list.size() - 1);

        return ret;
    }

    private static int dfs(int index) {
        int count = 1;
        visited[index] = true;
        for (int i = 1; i < 7; i++) {
            int me = list.get(index);
            int you = list.get(i);
            if (!visited[i] && isFriend(me, you)) {
                count += dfs(i);
            }
        }

        return count;
    }

    private static boolean isFriend(int a, int b) {
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);

        if (diff == 1 && max % 5 != 0) {
            return true;
        }
        if (diff == 5) {
            return true;
        }

        return false;
    }

}
