package inf.bak;

public class bak2559 {

    public static void main(String[] args) {
        int N = 10;
        int K = 5;
        int[] num = {3, -2, -4, -9, 0, 3, 7, 13, 8, -3};
        int max;

        int sum = 0;
        for (int i=0; i<K; i++) {
            sum += num[i];
        }

        max = sum;
        for (int i=K; i<N; i++) {
            sum += num[i];
            sum -= num[i-K];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }

}
