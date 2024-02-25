package Seminar2.task2;

import java.util.Random;

public class Server implements ServerSocketThreadListener {
    private final Random RANDOM = new Random();
    private boolean status;
    private ServerListener listener;
    Server(ServerListener listener){
        this.status = false;
        this.listener = listener;
    }

    public void start() {
        String msg;
        if (RANDOM.nextBoolean()) {
            if (status) {
                msg = "Server is already working";
            } else {
                status = true;
                msg = "Server started";
            }
        } else {
            msg = "Server is not available";
        }
        listener.getMessage(msg);
    }

    public void stop() {
        String msg;
        if (RANDOM.nextBoolean()) {
            if (status) {
                status = false;
                msg = "Server stopped";
            } else {
                msg = "Server is already stopped";
            }
        } else {
            msg = "Server is not available";
        }
        listener.getMessage(msg);
    }
}
