package Seminar2.task2;

public class ConsoleServerListener implements ServerListener {
    @Override
    public void getMessage(String msg) {
        System.out.println(msg);
    }
}
