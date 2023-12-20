package inf.bak;

import java.util.Arrays;
import java.util.Collections;

public class bak11047 {

    public static void main(String[] args) {
        int N = 10;
        int K = 4790;
        int answer = 0;

        Integer[] coins = {
            1,
            5,
            10,
            50,
            100,
            500,
            1000,
            5000,
            10000,
            50000
        };

        Arrays.sort(coins, Collections.reverseOrder());

        for (int coin : coins) {
            answer += K / coin;
            K = K % coin;
        }

        System.out.println(answer);
    }

}
