package ui;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Drawable {
    protected Color color;
    protected Object o;
    
    public Drawable(Object o, Color color) {
        this.o = o;
        this.color = color;
    }
    
    public abstract void draw(Graphics g);
}
