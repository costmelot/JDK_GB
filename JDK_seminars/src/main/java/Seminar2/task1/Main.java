package Seminar2.task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        new ChatWindow(new Server(new ConsoleServerListener()));
        try {
            new ChatWindow(new Server(new LogServerListener("ServerLogFile")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
