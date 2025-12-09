package fastcampus.part2.divideconquer;

import java.io.*;

public class Bak2751 {

    private static int[] arr;
    private static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        divide(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
           sb.append(temp[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);

        conquer(start, end);
    }

    private static void conquer(int start, int end) {
        int mid = (start + end) / 2;
        int l = start;
        int r = mid + 1;
        int index = start;

        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                temp[index++] = arr[l++];
            } else {
                temp[index++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = arr[l++];
        }

        while (r <= end) {
            temp[index++] = arr[r++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

}
