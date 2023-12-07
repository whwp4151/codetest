package inf.recursive;

public class Main74 {

    static int[] arr;

    public static void main(String[] args) {
        int n = 10;
        arr = new int[n+1];

        DFS(n);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static int DFS(int n) {
        if (arr[n] > 0) return arr[n];
        if (n <= 2) {
            arr[n] = 1;
            return 1;
        }

        int a = DFS(n-1);
        int b = DFS(n-2);
        int c = a+b;
        System.out.println(n+"n :: "+ a + " + " + b + " = " + c);
        arr[n] = c;
        return c;
    }

}
