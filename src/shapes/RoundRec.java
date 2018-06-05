package shapes;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.ComparableShape;

/**
 * 
 * @author Ian Fell
 *
 */
public class RoundRec extends Rectangle implements ComparableShape {

	private int startAngle;
	private int arcAngle;

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
	 * @param int     sa
	 * @param int     aa
	 */
	public RoundRec(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill, int sa, int aa) {
		super(x, y, w, h, lineColor, fillColor, fill);
		this.startAngle=sa;
		this.arcAngle=aa;
	}

	/**
	 * @param Graphics g
	 */
	public void draw(Graphics g) {  
		Color oldColor = g.getColor();
		if (isFill()) {
			g.setColor(getFillColor());
			g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getStartAngle(), getArcAngle());
		}
		g.setColor(getLineColor());
		g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), getStartAngle(), getArcAngle());
		g.setColor(oldColor);
	}

	private int getArcAngle() {
		return arcAngle;
	}

	private int getStartAngle() {
		return startAngle;
	}

	public void setStartAngle(int startAngle) {
		this.startAngle = startAngle;
	}

	public void setArcAngle(int arcAngle) {
		this.arcAngle = arcAngle;
	}

	public String toString() {
		return "Round Rec: \n\tx = " + getX() + "\n\ty = " + getY() + "\n\tw = " + getWidth() + "\n\th = " + getHeight();
	}

	public int calculateArea() {
		int area = (getWidth() * getHeight()) / 2;
		return area;
	}
}
