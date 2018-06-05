package shapes;

import interfaces.ComparableShape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Ian Fell
 *
 */
public class Oval extends Rectangle implements ComparableShape {
  
	/**
	 * Constructor.
	 * 
	 * @param int     x
	 * @param int     y
	 * @param int     w
	 * @param int     h
	 * @param Color   lineColor
	 * @param Color   fillColor
	 * @param boolean fill
	 */
    public Oval(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
        super(x, y, w, h, lineColor, fillColor, fill);
    }
  
    /**
	 * @param Graphics g
	 */
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        if (isFill()) {
            g.setColor(getFillColor());
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
        g.setColor(getLineColor());
        g.drawOval(getX(), getY(), getWidth(), getHeight());
        g.setColor(oldColor);
    }
  
    /**
    * Returns a String that represents this object.
    */
    public String toString() {
        return "Oval: \n\tx = " + getX() + "\n\ty = " + getY() + "\n\tw = " + getWidth() + "\n\th = " + getHeight();
    }
    
    public int calculateArea() {
		int area = (getWidth()) * (getHeight());
		return area;
	}
}    
 