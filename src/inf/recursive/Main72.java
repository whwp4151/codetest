package inf.recursive;

public class Main72 {

    public static void main(String[] args) {
        DFS(49);
    }

    public static void DFS(int n) {
        if (n == 0) {
            return;
        }
        DFS(n/2);
        System.out.print(n%2);
    }

}
