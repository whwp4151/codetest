package inf.bak.list;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(4);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(5);

        list.set(2, -1);

        list.insert(3, 10);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
