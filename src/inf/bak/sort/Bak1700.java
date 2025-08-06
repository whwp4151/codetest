package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] devices = new int[K];

        st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < K; i++) {
            devices[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        set.add(devices[0]);
        for (int i = 1; i < K; i++) {
            if (set.contains(devices[i])) {
                // 멀티탭에 이미 꽂혀있는 기기는 그냥 사용한다.
                continue;
            }

            if (set.size() < N) {
                // 빈 구멍이 있다면 바로 꽂는다.
                set.add(devices[i]);
                continue;
            }

            // 가장 나중에 사용되거나, 더 이상 안 쓰이는 기기를 찾자
            int idxToRemove = -1;
            int farthestUse = -1;

            for (int plugged : set) {
                int nextUse = Integer.MAX_VALUE;

                for (int j = i + 1; j < K; j++) {
                    if (devices[j] == plugged) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse == Integer.MAX_VALUE) {
                    idxToRemove = plugged; // 다시 안 쓰일 예정
                    break;
                }

                if (nextUse > farthestUse) {
                    farthestUse = nextUse;
                    idxToRemove = plugged; // 가장 나중에 쓰일 기기
                }
            }

            set.remove(idxToRemove);
            set.add(devices[i]);
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
