package inf.recursive;

public class Main73 {

    public static void main(String[] args) {
        System.out.println(DFS(5));
    }

    public static int DFS(int n) {
        if (n == 1) return n;
        return DFS(n-1) * n;
    }

}
