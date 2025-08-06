package inf.bak.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak1931 {

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
        br.close();

        Arrays.sort(meetings, (m1, m2) -> {
            if (m1.end == m2.end) {
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        });

        int answer = 0;
        int currentEnd = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= currentEnd) {
                answer++;
                currentEnd = meeting.end;
            }
        }

        bw.write(answer + "");
        bw.flush();
    }

}
