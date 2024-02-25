package Seminar3.task1;

import java.io.DataInput;
import java.io.InputStream;
import java.io.Serializable;

public class GenericClass <T extends Comparable,V extends InputStream & Serializable,K extends Number> {
    private T t;
    private V v;
    private K k;

    public GenericClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void showClass() {
        System.out.printf("T - type of %s,\n V - type of %s,\n K - type of %s\n",
                t.getClass().getName(), v.getClass().getName(), k.getClass().getName());
    }
}
