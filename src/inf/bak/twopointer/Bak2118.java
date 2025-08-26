package inf.bak.twopointer;

import java.io.*;

public class Bak2118 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int distance = Integer.parseInt(br.readLine());
            arr[i] = distance;
            sum += distance;
        }
        br.close();

        int answer = 0;
        int distance = 0;
        int distance2 = sum;
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (distance < distance2) {
                distance += arr[j];
                distance2 -= arr[j];
                j = (j + 1) % N;
            }

            answer = Math.max(answer, distance2);
            distance -= arr[i];
            distance2 += arr[i];
        }

        bw.write(answer + "\n");
        bw.flush();
    }

}
