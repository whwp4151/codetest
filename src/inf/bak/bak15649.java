package inf.bak;


public class bak15649 {

    static int n;
    static int m;
    static int[] visit;
    static int[] result;

    public static void main(String[] args) {
        n = 4;
        m = 4;
        visit = new int[n+1];
        result = new int[m];

        recur(0);
    }

    public static void recur(int num) {
        if (num == m) {
            for (int i=0; i<m; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                result[num] = i;
                recur(num+1);
                visit[i] = 0;
            }
        }
    }

}
