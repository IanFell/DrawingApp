package model;

import java.awt.Color;
import java.awt.Container;
import java.util.Vector;
import shapes.Arc;
import shapes.Oval;
import shapes.Rectangle;
import shapes.RoundRec;
import shapes.Shape;
import interfaces.Resettable;
import enums.Actions;
import enums.ShapeEnum;

/**
 * 
 * @author Ian Fell
 *
 */
public class Model implements Resettable {

	private Container container;

	public Color fillColor;
	public Color lineColor;

	public Vector<Shape> shapeVector = new Vector<Shape>(10);

	private Actions actions = Actions.DRAW;
	private ShapeEnum currentShapeEnum = ShapeEnum.RECTANGLE;

	// "Last line color" - used to keep track of the line color of selected shape.
	public Color llc;

	// "Last fill color" - used to keep track of the fill color of selected shape.
	public Color lfc;

	private boolean fill = false;

	public Shape currentShape;

	/**
	 * 
	 * @return Shape
	 */
	public Shape createShape() {
		int startValue  = 0;
		Color lineColor = getLineColor();
		Color fillColor = getFillColor();
		if(currentShapeEnum == ShapeEnum.RECTANGLE){
			currentShape =  new Rectangle(startValue, startValue, startValue, startValue, lineColor, fillColor, fill);
		}
		else if(currentShapeEnum == ShapeEnum.OVAL){
			currentShape =  new Oval(startValue, startValue, startValue, startValue, lineColor, fillColor, fill);
		}
		else if(currentShapeEnum == ShapeEnum.ARC){
			currentShape =  new Arc(startValue, startValue, startValue, startValue, lineColor, fillColor, fill, startValue, 180);
		}
		else if(currentShapeEnum == ShapeEnum.ROUNDREC){
			currentShape =  new RoundRec(startValue, startValue, startValue, startValue, lineColor, fillColor, fill, 70, 180);
		}
		shapeVector.add(currentShape);
		return currentShape;
	}

	public void resetComponents() {
		actions      = Actions.DRAW;
		currentShape = null;       
		shapeVector.removeAllElements();        
		if (container instanceof Resettable) {
			((Resettable) container).resetComponents();
		}
	}

	/**
	 * This method is used when a shape is clicked on...it returns the shape that was clicked on.
	 * If no shape was clicked it returns null.  The shape returned is the shape the mouse handler
	 * calls when shape is moved or resized.
	 * 
	 * @param int xClick
	 * @param int yClick
	 * @return Shape|null
	 */
	public Shape getSelectedShape(int xClick, int yClick){
		for(Shape selectedShape : shapeVector) {
			if(selectedShape.containsLocation(xClick, yClick)) {
				llc = selectedShape.lineColor;
				if(((Rectangle) selectedShape).isFill())
					lfc=selectedShape.fillColor;
				return selectedShape;
			}
		}
		return null;
	}

	public Actions getAction() {
		return actions;
	}

	public void setAction(Actions actions) {
		this.actions = actions;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public void setLine(boolean line) {
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public Model(Container container) {
		this.container = container;
	}

	public void repaint() {
		container.repaint();
	}

	public String toString() {
		return "Model:\n\tAction: " + actions + "\n\tFill: " + fill;
	}

	public Color getFillColor() {    	
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getLineColor() {		
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Vector<Shape> getShapeVector() {
		return shapeVector;
	}

	public void setShapeVector(Vector<Shape> shapeVector) {
		this.shapeVector = shapeVector;
	}

	public ShapeEnum getCurrentShapeEnum() {
		return currentShapeEnum;
	}

	public void setCurrentShapeEnum(ShapeEnum shapeEnum) {
		this.currentShapeEnum = shapeEnum;
	}
}