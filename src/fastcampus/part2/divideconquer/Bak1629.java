package fastcampus.part2.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(solve(A, B, C));
    }

    private static long solve(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long half = solve(A, B / 2, C);

        if (B % 2 == 0) {
            return (half * half) % C;
        } else {
            return (((half * half) % C) * A) % C;
        }
    }

}
