package Seminar2.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements SocketThreadListener {
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JPanel grid = new JPanel();
    Server server;
    ServerListener listener;

    ChatWindow(ServerListener listener, Server server) {
        this.listener = listener;
        this.server = server;

        setBounds(300,600,200,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        grid = new JPanel(new GridLayout(1,2));
        grid.add(btnStart);
        grid.add(btnStop);

        add(grid);
        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
                buttonPressed("Нажата кнопка старт");
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
                buttonPressed("Нажата кнопка стоп");
            }
        });
    }

    @Override
    public void buttonPressed(String msg) {
        listener.getMessage(msg);
    }
}
