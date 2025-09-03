package inf.bak.list;

public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int getSize() {
        return size;
    }

    private Node<E> getNode(int index) {
        checkIndex(index);

        Node<E> node = head;
        while (index-- > 0) {
            node = node.next;
        }

        return node;
    }

    public E get(int index) {
        return getNode(index).item;
    }

    public void set(int index, E element) {
        checkIndex(index);

        Node<E> targetNode = getNode(index);
        targetNode.item = element;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, head);
        if (size == 0) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

}
