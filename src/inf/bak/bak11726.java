package inf.bak;

public class bak11726 {

    public static void main(String[] args) {
        int N = 9;

        int[] DP = new int[N+1];
        DP[1] = 1;
        DP[2] = 2;

        for (int i=3; i<=N; i++) {
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }

        System.out.println(DP[N]);
    }

}
