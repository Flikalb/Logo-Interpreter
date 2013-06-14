package ui;

import java.awt.Color;
import java.awt.Graphics;

public class Label extends Drawable {
    private int x, y;

    public Label(Object o, Color color, int x, int y) {
        super(o, color);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawString((String) o, x, y);
    }

}
