package inf.bak.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class Bak11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] answer = new int[N + M];
        int index = 0;
        int A_Index = 0;
        int B_Index = 0;
        while (A_Index < N && B_Index < M) {
            if (A[A_Index] < B[B_Index]) {
                answer[index++] = A[A_Index++];
            } else if (B[B_Index] < A[A_Index]) {
                answer[index++] = B[B_Index++];
            } else {
                answer[index++] = A[A_Index++];
                answer[index++] = B[B_Index++];
            }
        }

        while (A_Index < N) {
            answer[index++] = A[A_Index++];
        }

        while (B_Index < M) {
            answer[index++] = B[B_Index++];
        }

        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.newLine();
        bw.flush();
    }

}
