package inf.recursive;

public class Main75 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        DFS_1(root);
        System.out.println();
        DFS_2(root);
        System.out.println();
        DFS_3(root);
    }

    public static void DFS_1(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        DFS_1(node.lt);
        DFS_1(node.rt);
    }

    public static void DFS_2(Node node) {
        if (node == null) return;
        DFS_2(node.lt);
        System.out.print(node.data + " ");
        DFS_2(node.rt);
    }

    public static void DFS_3(Node node) {
        if (node == null) return;
        DFS_3(node.lt);
        DFS_3(node.rt);
        System.out.print(node.data + " ");
    }

}