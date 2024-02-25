package Seminar3.task2;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> intArr = new MyCollection<>();
        intArr.print();
        intArr.add(10);
        intArr.add(5);
        intArr.add(8);
        intArr.print();
        intArr.remove(5);
        intArr.print();

        MyCollection<String> strArr = new MyCollection<>();
        strArr.print();
        strArr.add("one");
        strArr.add("two");
        strArr.add("three");
        strArr.print();
        strArr.remove("one");
        strArr.print();

        MyIterator<Integer> myit = new MyIterator<>(new Integer[]{1,2,3,4});

        for (Integer item: myit) {
            System.out.println(item);
        }

        for (Integer item: myit) {
            System.out.println(item);
        }
    }
}
