package inf.bak;

import java.util.Arrays;

public class bak1920 {

    static int[] A;

    public static void main(String[] args) {
        int N = 5;
        A = new int[]{4, 1, 5, 2, 3};

        int M = 5;
        int[] num = {1, 3, 7, 9, 5};

        Arrays.sort(A);

        for (int i=0; i<M; i++) {
            search(0, M-1, num[i]);
        }
    }

    public static void search(int start, int end, int target) {
        if (start == end) {
            if (A[start] == target) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
            return;
        }

        int mid = (start + end) / 2;
        if (A[mid] < target) {
            search(mid+1, end, target);
        } else {
            search(start, mid, target);
        }
    }

}
