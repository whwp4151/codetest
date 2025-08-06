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
            if (m1.end == m2.end) {
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 1;
        pq.add(meetings[0].end);
        for (int i = 1; i < N; i++) {
            boolean flag = false;
            while (pq.) {
                Integer meetingEnd = pq.poll();
                System.out.println(meetingEnd);
                if (meetings[i].start >= meetingEnd) {
                    pq.add(meetings[i].end);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer++;
                pq.add(meetings[i].end);
            }
        }

        bw.write(answer + "");
        bw.flush();
    }

}
