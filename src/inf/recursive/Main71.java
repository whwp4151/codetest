package inf.recursive;

import java.util.Scanner;

public class Main71 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        printNumber(size);
    }

    public static void printNumber(int n) {
        if (n == 0) {
            return;
        }
        printNumber(n-1);
        System.out.print(n + " ");
    }

}
