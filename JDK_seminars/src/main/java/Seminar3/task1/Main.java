package Seminar3.task1;

import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        GenericClass gen = new GenericClass("Hello", new InputStream() {
            @Override
            public int read() throws IOException {
                throw new UnsupportedOperationException("Unimplement method 'read'");
            }
        }, 45);
        gen.showClass();
    }



}
