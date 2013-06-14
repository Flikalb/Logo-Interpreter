package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

public class DrawingZone extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7844757378852095156L;
    public static Turtle turtle;
    public int centerX;
    public int centerY;
    public Vector<Drawable> toDraw;
    private Color currentColor;

    // public Graphics g;

    public DrawingZone() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(1.0f, 1.0f, 1.0f));

        Dimension dim = this.getPreferredSize();
        turtle = new Turtle((int) dim.width / 2, (int) dim.height / 2);
        centerX = turtle.getPosX();
        centerY = turtle.getPosY();

        toDraw = new Vector<Drawable>();
        currentColor = Color.BLACK;
    }

    public DrawingZone(int x, int y) {
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(new Color(1.0f, 1.0f, 1.0f));

        Dimension dim = this.getPreferredSize();
        turtle = new Turtle((int) dim.width / 2, (int) dim.height / 2);
        centerX = turtle.getPosX();
        centerY = turtle.getPosY();
        this.setOpaque(true);
        toDraw = new Vector<Drawable>();
        currentColor = Color.BLACK;
    }

    public void paintComponent(Graphics g) {
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Drawable d : toDraw) {
            d.draw(g);
        }
        turtle.paintTurtle(g);
    }

    public void setCenter(int _X, int _Y) {
        this.centerX = _X;
        this.centerY = _Y;

    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

}
