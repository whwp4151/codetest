package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak2910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            map.merge(Integer.parseInt(st.nextToken()), 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((m1, m2) -> m2.getValue() - m1.getValue());

        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                bw.write(entry.getKey() + " ");
            }
        }

        bw.flush();
    }

}
