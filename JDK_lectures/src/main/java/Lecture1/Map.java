package Lecture1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_HUMAN_WIN = 1;
    private static final int STATE_AI_WIN = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private static final String MSG_DRAW = "Ничья";

    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY;
    private int fieldSizeX;
    private char[][] field;
    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;

    Map(int fieldSizeX, int fieldSizeY) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        isInitialized = false;
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_HUMAN_WIN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_AI_WIN)) return;
        if (isGameOver || !isInitialized) return;
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48 ));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2); break;
            case STATE_AI_WIN:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2); break;
            case STATE_HUMAN_WIN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2); break;
            default:
                throw new RuntimeException("Unexpected gameOverState" + gameOverType);
        }
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin((char) dot)) {
            this.gameOverType = gameOverType;
            repaint();
            isGameOver = true;
            return true;
        }
        if (checkDraw()) {
            this.gameOverType = STATE_DRAW;
            repaint();
            isGameOver = true;
            return true;
        }
        return false;
    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %b\nSize: x=%d, y=%d\nWin Length: %d", mode, fSzX, fSzY, wLen);
        initMap();
        repaint();
        fieldSizeX = fSzX;
        fieldSizeY = fSzY;
        isGameOver = false;
        isInitialized = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        cellHeight = panelHeight / this.fieldSizeX;
        cellWidth = panelWidth / this.fieldSizeY;
        if (isGameOver) showMessageGameOver(g);
        if (!isInitialized) return;

        g.setColor(Color.BLACK);
        for (int h = 0; h < this.fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < this.fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        repaint();

//        for (int y = 0; y < this.fieldSizeY; y++) {
//            for (int x = 0; x < this.fieldSizeX; x++) {
//                if (field[y][x] == EMPTY_DOT) continue;
//
//                if (field[y][x] == HUMAN_DOT) {
//                    g.setColor(Color.BLUE);
//                    int dw = getWidth() / this.fieldSizeX;
//                    int dh = getHeight() / this.fieldSizeY;
//                    int i = x * dw;
//                    int j = y * dh;
//                    g.drawLine(i, j, i + dw, j + dh);
//                    g.drawLine(i, j + dh, i + dw, j);
//                } else if (field[y][x] == AI_DOT) {
//                    g.setColor(Color.BLUE);
//                    int dw = getWidth() / this.fieldSizeX;
//                    int dh = getHeight() / this.fieldSizeY;
//                    int i = x * dw;
//                    int j = y * dh;
//                    g.drawOval(i + 5 * dw / 100, j, dw * 9 / 10, dh);
//                } else {
//                    throw new RuntimeException("Unexpected value" + field[y][x] +
//                            " in cell: x = " + x + " y = " + y);
//                }
//            }
//        }
    }

    private void initMap() {
        field = new char[this.fieldSizeY][this.fieldSizeX];
        for (int i = 0; i < this.fieldSizeY; i++) {
            for (int j = 0; j < this.fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < this.fieldSizeX && y >= 0 && y < this.fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(this.fieldSizeX);
            y = RANDOM.nextInt(this.fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(char symbol) {
        for (int i = 0; i < this.fieldSizeX; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                return true; // проверка горизонтали
            }
            if (field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) {
                return true; // проверка вертикали
            }
        }
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) return true;
        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) return true;
        return false; // проверка диагоналей
    }

    private boolean checkDraw() {
        for (int x = 0; x < this.fieldSizeX; x++) {
            for (int y = 0; y < this.fieldSizeY; y++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

}
