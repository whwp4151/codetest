package fastcampus.part2.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak1992 {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        System.out.println();
    }

}
