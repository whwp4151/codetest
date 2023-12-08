package inf.recursive;

public class Main76 {

    static int N = 3;
    static int[] visit = new int[N+1];

    public static void main(String[] args) {
        DFS(1);

        /*
        * 3
        * 1 2 3
        * 1 2
        * 1 3
        * 1
        * 2 3
        * 2
        * 3
        *
        * DFS(4) visit = {1, 0, 0}
        * DFS(3) visit[3] = 0
        * DFS(4) visit = {1, 0, 1}
        * DFS(3) visit[3] = 1
        * DFS(2) visit[2] = 0
        * DFS(4) visit = {1, 1, 0}
        * DFS(3) visit[3] = 0
        * DFS(4) visit = {1, 1, 1}
        * DFS(3) visit[3] = 1
        * DFS(2) visit[2] = 1
        * DFS(1) visit[1] = 1
        * */
    }

    public static void DFS(int n) {
        if (n > N) {
            for (int i=1; i<=N; i++) {
                if (visit[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        visit[n] = 1;
        DFS(n+1);

        visit[n] = 0;
        DFS(n+1);
    }

}
