package Lecture1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Lecture1.Map.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    public static int sliderSizeValue = 3;
    public static int sliderWinValue = 3;
    public static boolean modeValue = false;

    JLabel labelMode = new JLabel("Выберите режим игры: ");
    JRadioButton humanVsHumanButton = new JRadioButton("Человек против человека",true);
    JRadioButton humanVscomp = new JRadioButton("Человек против компьютера", false);

    JLabel labelSize = new JLabel(String.format("Установите размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);

    JLabel labelWin = new JLabel(String.format("Установите длину для победы: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);

    ButtonGroup topButtonGroup = new ButtonGroup();

    JPanel grid = new JPanel(new GridLayout(4,1));
    JPanel top = new JPanel(new GridLayout(2, 1));
    JPanel topButtons = new JPanel(new GridLayout(1, 2));
    JPanel middle = new JPanel(new GridLayout(2, 1));
    JPanel bottom = new JPanel(new GridLayout(2, 1));

    JButton btnStart = new JButton("Start new game");


    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        topButtonGroup.add(humanVsHumanButton);
        topButtonGroup.add(humanVscomp);
        topButtons.add(humanVsHumanButton);
        topButtons.add(humanVscomp);

        top.add(labelMode);
        top.add(topButtons);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Установите размер поля: %d", sliderSizeValue));
            }
        });
        middle.add(labelSize);
        middle.add(sliderSize);

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelWin.setText(String.format("Установите длину для победы: %d", sliderWinValue));
            }
        });

        bottom.add(labelWin);
        bottom.add(sliderWin);

        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(btnStart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = humanVsHumanButton.isSelected();
                gameWindow.startNewGame(modeValue,sliderSizeValue,sliderSizeValue,sliderWinValue);
                setVisible(false);
            }
        });
        add(grid);
    }
}
