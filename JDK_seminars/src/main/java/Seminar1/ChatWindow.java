package Seminar1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 100;
    private static final String WINDOW_NAME = "Chat";

    JTextArea textOutput = new JTextArea();
    JLabel label = new JLabel("Введите собщение: ");
    JTextField textInput = new JTextField();

    JPanel grid = new JPanel(new GridLayout(4, 1));

    JButton buttonSend = new JButton("Отправить сообщение");

    ChatWindow(String login) {
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textOutput.setEditable(false);
        textOutput.setBackground(Color.GRAY);
        grid.add(textOutput);
        grid.add(label);
        grid.add(textInput);
        grid.add(buttonSend);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern
                        ("yy/MM/dd HH:mm:ss")).toString() + " " + login + " : "
                        + textInput.getText() + "\n");
            }
        });

        add(grid);

        setVisible(true);
    }

}
