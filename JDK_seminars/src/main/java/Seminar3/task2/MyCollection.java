package Seminar3.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCollection <T>{
    Object[] arr;

    MyCollection() {
        arr = new Object[0];
    }

    public void add(T t) {
        Object[] tempArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[tempArr.length - 1] = t;
        arr = tempArr;
    }

    public void remove (T t) {
        Integer position = find(t);
        if (position != null) {
            Object[] tempArr = new Object[arr.length - 1];
            for (int i = 0; i < position; i++) {
                tempArr[i] = arr[i];
            }
            for (int i = position; i < arr.length - 1; i++) {
                tempArr[i] = arr[i + 1];
            }
            arr = tempArr;
        }
    }

    public Integer find(T t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(t)) return i;
        }
        return null;
    }
    public void print () {
        System.out.println(Arrays.toString(arr));
    }
}
