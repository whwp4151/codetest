package inf.bak.list;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public void set(int index, E element) {
        checkIndex(index);
        elements[index] = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void add(E e) {
        if (size == elements.length) {
            incrementCapacity();
        }
        elements[size++] = e;
    }

    private void incrementCapacity() {
        int newCapacity = elements.length + (elements.length >> 1);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public void insert(int index, E element) {
        checkIndex(index);
        int copyLength = size - index;
        System.arraycopy(elements, index, elements, index + 1, copyLength);
        elements[index] = element;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        int copyLength = elements.length - index - 1;
        System.arraycopy(elements, index + 1, elements, index, copyLength);
        size--;
    }

}
