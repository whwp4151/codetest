package fastcampus.part3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak1941 {

    private static char[] graph = new char[25];
    private static boolean[] visited = new boolean[25];
    private static int answer = 0;

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


        System.out.println(answer);
    }

}
