package fastcampus.part2.recursion;

import java.io.*;
import java.util.*;

public class Bak14267 {

    private static int[] employee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        employee = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            employee[i] = Integer.parseInt(st.nextToken());
        }


    }

}
