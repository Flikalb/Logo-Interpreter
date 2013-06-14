package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Turtle {

    private int _X = 0;
    private int _Y = 0;
    private int heading = 0;
    private boolean show;
    private boolean pendown;
    private boolean erase;

    public Turtle(int x, int y) {
        _X = x;
        _Y = y;
        show = true;
        pendown = true;
        setErase(false);
    }

    public void setPosX(int x) {
        _X = x;
    }

    public void setPosY(int y) {
        _Y = y;
    }

    public void setPos(int x, int y) {
        _X = x;
        _Y = y;
    }

    public Dimension getPos() {
        return new Dimension(_X, _Y);
    }

    public int getPosX() {
        return _X;
    }

    public int getPosY() {
        return _Y;
    }
    
    public boolean getPen() {
        return pendown;
    }

    public void paintTurtle(Graphics g) {
        if (show) {
            g.setColor(Color.GREEN);
            g.fillOval(_X - 5, _Y - 5, 10, 10);
        }

    }

    public void setHeading(int head) {
        heading = head;
    }

    public int getHeading() {
        return heading;
    }
    
    public void setShow(boolean _show) {
        this.show = _show;
    }
    
    public void setPen(boolean _pen) {
        this.pendown = _pen;
    }

    public boolean getErase() {
        return erase;
    }

    public void setErase(boolean erase) {
        this.erase = erase;
    }

}
