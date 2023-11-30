package inf.string;

import java.util.Scanner;

public class Main14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        String[] list = new String[size];

        for (int i=0; i<size; i++) {
            list[i] = scanner.next();
        }

        for (String s : list) {
            StringBuilder builder = new StringBuilder(s);
            System.out.println(builder.reverse());
        }
    }

}
