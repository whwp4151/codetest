package inf.recursive;

import java.util.LinkedList;
import java.util.Queue;

public class Main77 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);
    }

    public static void BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (queue.peek() != null) {
            Node poll = queue.poll();
            System.out.print(poll.data+" ");
            queue.offer(poll.lt);
            queue.offer(poll.rt);
        }
    }

}
