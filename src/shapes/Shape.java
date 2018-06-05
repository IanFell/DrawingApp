package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Ian Fell
 *
 */
public abstract class Shape {

	private int x;
	private int y;

	public Color lineColor;
	public Color fillColor;

	/**
	 * Constructor.
	 * 
	 * @param int   x
	 * @param int   y
	 * @param Color lineColor
	 * @param Color fillColor
	 */
	public Shape(int x, int y, Color lineColor, Color fillColor) {
		this.x         = x;
		this.y         = y;
		this.lineColor = lineColor;
		this.fillColor = fillColor;
	}

	/**
	 * 
	 * @param Graphics g
	 */
	public abstract void draw(Graphics g);

	/**
	 * 
	 * @param int x
	 * @param int y
	 * @return boolean
	 */
	public abstract boolean containsLocation(int x, int y);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color lineColor) {
		this.fillColor = lineColor;
	}
}