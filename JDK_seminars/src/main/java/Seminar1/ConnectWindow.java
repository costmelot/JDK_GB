package Seminar1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 100;
    private static final String WINDOW_NAME = "ConnectWindow";

    JTextField loginField = new JTextField("Введите Ваш логин: ");
    JTextField passwordField = new JTextField("Введите Ваш пароль: ");
    JTextField serverField = new JTextField("Введите адресс сервера и порт для подключения: ");

    JButton buttonConnect = new JButton("Подключиться к серверу");

    JPanel grid = new JPanel(new GridLayout(4, 1));

    ConnectWindow() {
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        grid.add(loginField);
        grid.add(passwordField);
        grid.add(serverField);
        grid.add(buttonConnect);

        add(grid);

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText().replace("Введите Ваш логин: ", "");
                new ChatWindow(login);
            }
        });

        setVisible(true);
    }
}
