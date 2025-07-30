package inf.bak;

import java.io.*;
import java.util.*;

public class Bak2817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> answer = new LinkedHashMap<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String staff = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());

            double validVotes = X * 0.05;
            if (votes >= validVotes) {
                map.put(staff, votes);
                answer.put(staff, 0);
            }
        }
        br.close();

        int index = 0;
        int size = 14 * map.size();
        Score[] score = new Score[size];
        for (String staff : map.keySet()) {
            for (int i = 1; i <= 14; i++) {
                score[index++] = new Score(staff, (double) map.get(staff) / i);
            }
        }

        Arrays.sort(score, (o1, o2) -> {
            if (o1.getScore() > o2.getScore()) {
                return -1;
            } else if (o1.getScore() < o2.getScore()) {
                return 1;
            } else {
                return o1.getStaff().compareTo(o2.getStaff());
            }
        });

        for (int i = 0; i < 14; i++) {
            answer.merge(score[i].getStaff(), 1, Integer::sum);
        }

        answer.keySet().stream()
                .sorted()
                .forEach(staff -> {
                    try {
                        bw.write(staff + " " + answer.get(staff));
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        bw.flush();
    }

}

class Score {
    private String staff;
    private double score;

    public Score(String staff, double score) {
        this.staff = staff;
        this.score = score;
    }

    public String getStaff() {
        return staff;
    }

    public double getScore() {
        return score;
    }
}
