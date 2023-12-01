package inf.array;

import java.util.Scanner;

public class Main22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] list = new int[size];
        for (int i=0; i<size; i++) {
            list[i] = scanner.nextInt();
        }

        int cnt = 1;
        int min = list[0];
        for (int i=1; i<size; i++) {
            if (min < list[i]) {
                min = list[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
