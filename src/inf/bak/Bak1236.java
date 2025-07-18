package inf.bak;

import java.util.Scanner;

public class Bak1236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] castle = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            castle[i] = line.toCharArray();
        }

        boolean[] visitedN = new boolean[N];
        boolean[] visitedM = new boolean[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    visitedN[i] = true;
                    visitedM[j] = true;
                }
            }
        }

        int countN = 0;
        for (int i = 0; i < N; i++) {
            if (!visitedN[i]) {
                countN++;
            }
        }

        int countM = 0;
        for (int i = 0; i < M; i++) {
            if (!visitedM[i]) {
                countM++;
            }
        }

        System.out.println(Math.max(countN, countM));
    }

}
