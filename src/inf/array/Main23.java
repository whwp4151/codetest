package inf.array;

import java.util.Scanner;

public class Main23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] aList = new int[size];
        int[] bList = new int[size];
        String[] answer = new String[size];
        for (int i=0; i<size; i++) {
            aList[i] = scanner.nextInt();
        }
        for (int i=0; i<size; i++) {
            bList[i] = scanner.nextInt();
        }

        for (int i=0; i<size; i++) {
            if (aList[i] == bList[i]) answer[i] = "D";
            else if ((aList[i] % 3) == (bList[i]-1)) {
                answer[i] = "B";
            } else {
                answer[i] = "A";
            }

        }

        for (String s : answer) {
            System.out.println(s);
        }
    }

}
