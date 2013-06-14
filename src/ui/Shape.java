package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Shape extends Drawable{

    public Shape(Object o, Color color) {
        super(o, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw((java.awt.Shape) o);
    }

}
