package Seminar2.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JPanel grid = new JPanel();
    Server server;

    ChatWindow(Server server) {
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
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });
    }
}
