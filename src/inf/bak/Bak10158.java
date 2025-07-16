package inf.bak;

import java.util.Scanner;

/**
 *
 W=6
 T = 12 제자리
 2W?

 T만큼 지난 후 P 위치
 T % 2W  만큼 이동함
 17 % 12 = 5
 17시간 후 4에서 5만큼 이동 : 3
 
 H=4
 T = 8 제자리
 2H?

 T만큼 지난 후 Q 위치
 T % 2H 만큼 이동함
 10 % 8 = 2
 10시간 후 1에서 2만큼 이동 : 3
 */
public class Bak10158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int timeP = (P+T) % (2*W);
        int timeQ = (Q+T) % (2*H);

        if (timeP > W) timeP = (2*W) - timeP;
        if (timeQ > H) timeQ = (2*H) - timeQ;

        System.out.println(timeP + " " + timeQ);
    }

}
