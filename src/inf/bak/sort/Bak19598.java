package inf.bak.sort;

import java.io.*;
import java.util.*;

public class Bak19598 {

    static class Meeting {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings, (m1, m2) -> {
            if (m1.start == m2.start) {
                return m1.end - m2.end;
            }
            return m1.start - m2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (Meeting meeting : meetings) {
            int start = meeting.start;
            int end = meeting.end;

            // 가장 빨리 끝나는 회의보다 늦게 시작하면 해당 회의실 사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();  // 회의실 재사용
            }

            pq.add(end);  // 새 회의실 추가 (or 기존 회의실 재사용)
            answer = Math.max(answer, pq.size());
        }

        bw.write(answer + "");
        bw.flush();
    }

}
