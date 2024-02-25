package Seminar2.task1;

public class ConsoleServerListener implements ServerListener{
    @Override
    public void getMessage(String msg) {
        System.out.println(msg);
    }
}
