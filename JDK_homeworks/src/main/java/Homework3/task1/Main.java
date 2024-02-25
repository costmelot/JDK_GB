package Homework3.task1;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> intArr = new MyCollection<>();

        intArr.add(10);
        intArr.add(5);
        intArr.add(8);
        intArr.print();
        intArr.remove(5);
        intArr.add(4);
        intArr.remove(5);

        System.out.println(intArr.next());
        System.out.println(intArr.hasNext());
        System.out.println(intArr.next());
        System.out.println(intArr.next());
        System.out.println(intArr.hasNext());
        System.out.println(intArr.next());

        intArr.print();


        MyCollection<String> strArr = new MyCollection<>();
        strArr.add("one");
        strArr.add("two");
        strArr.add("three");
        strArr.print();
        strArr.remove("one");
        strArr.print();
        System.out.println(strArr.next());
        System.out.println(strArr.hasNext());
    }
}
