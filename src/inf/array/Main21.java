package inf.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] list = new int[size];
        for (int i=0; i<size; i++) {
            list[i] = scanner.nextInt();
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(list[0]);
        for (int i=1; i<size; i++) {
            if (list[i] > list[i-1]) answer.add(list[i]);
        }

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

}
