package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            map.put(X, 0);
            arr[i] = X;
        }
        br.close();

        int index = 0;
        for (int key : map.keySet()) {
            map.put(key, index++);
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.flush();
    }
}
