package Lecture2.common;

import java.awt.*;

public interface Intreractable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
