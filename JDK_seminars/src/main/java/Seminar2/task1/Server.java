package Seminar2.task1;

public class Server implements ServerListener{
    private boolean status;
    private ServerListener listener;
    Server(ServerListener listener){
        this.status = false;
        this.listener = listener;
    }

    public void start() {
        String msg;
        if (status) {
            msg = "Server is already working";
        } else {
            status = true;
            msg = "Server started";
        }
        listener.getMessage(msg);
    }

    public void stop() {
        String msg;
        if (status) {
            status = false;
            msg = "Server stopped";
        } else {
            msg = "Server is already stopped";
        }
        listener.getMessage(msg);
    }

    @Override
    public void getMessage(String msg) {

    }
}
