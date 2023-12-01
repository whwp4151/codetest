package inf.array;

import java.util.Arrays;
import java.util.Scanner;

public class Main25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] arr = new int[size+1];

        long startTime1 = System.currentTimeMillis();
        int result1 = result1(arr, size);
        long endTime1 = System.currentTimeMillis();
        System.out.println(result1);
        System.out.println((endTime1 - startTime1) + "ms");

        long startTime2 = System.currentTimeMillis();
        int result2 = result2(arr, size);
        long endTime2 = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println((endTime2 - startTime2) + "ms");

    }

    public static int result1(int[] arr, int size) {
        int answer = 0;
        for (int i=2; i<=size; i++) {
            arr[i] = i;
        }

        for (int i=2; i<=Math.sqrt(size)+1; i++) {
            if (arr[i] != 0) {
                int j=2;
                while (i*j <= size) {
                    arr[i*j] = 0;
                    j += 1;
                }
            }
        }

        for (int i=2; i<=size; i++) {
            if (arr[i] != 0) answer++;
        }

        return answer;
    }

    // correct
    public static int result2(int[] arr, int size) {
        int answer = 0;

        for (int i=2; i<=size; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j=i; j<=size; j+=i) {
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

}
