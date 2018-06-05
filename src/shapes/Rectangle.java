package shapes;

import interfaces.ComparableShape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Ian Fell
 *
 */
public class Rectangle extends Shape implements ComparableShape {
	
    private Color fillColor;
    
    private int width;
	private int height;
	
    private boolean fill;
  
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
    public Rectangle(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
        super(x, y, lineColor, fillColor);
        this.width     = w;
        this.height    = h;
        this.fillColor = fillColor;
        this.fill      = fill;
    }
  
    /**
	 * @param Graphics g
	 */
    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        if (isFill()) {
            g.setColor(getFillColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        g.setColor(getLineColor());
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        g.setColor(oldColor);
    }
  
    /**
     * @param int x
     * @param int y
     * @return boolean
     */
    public boolean containsLocation(int x, int y) {
        if (getX() <= x && getY() <= y && getX() + getWidth() >= x && getY() + getHeight() >= y) {
            return true;
        }
        return false;
    }
    
    public Color getFillColor() {
        return fillColor;
    }
    
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setFill(boolean fill) {
        this.fill = fill;
    }
    
    public boolean isFill() {
        return fill;
    }
    
    /**
    * Returns a String representing this object.
    */
    public String toString() {
        return "Rectangle: \n\tx = " + getX() + "\n\ty = " + getY() + 
               "\n\tw = " + getWidth() + "\n\th = " + getHeight();
    }
    
	public int calculateArea() {
		int area = (this.width)*(this.height);	
		return area;
	}
}
