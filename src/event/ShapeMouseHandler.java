package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import enums.Actions;
import model.Model;
import shapes.Rectangle;
import shapes.Shape;

/**
 * 
 * @author Ian Fell
 *
 */
public class ShapeMouseHandler extends MouseAdapter {

	private Model   model;
	private int     startX;
	private int     startY;   
	private Shape   shape;
	private boolean isItFilled;

	/**
	 * Constructor.
	 * 
	 * @param Model model
	 */
	public ShapeMouseHandler(Model model) {
		this.model = model;
	}

	/**
	 * @param MouseEvent e
	 */
	public void mousePressed(MouseEvent e) {
		if (model.getAction() == Actions.DRAW) {
			startX = e.getX();
			startY = e.getY();              
			shape  = model.createShape();

			if (shape != null) {
				shape.setX(e.getX());
				shape.setY(e.getY());

				// Sets a default width and height or ending location in case the user does not drag the mouse.
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(50);
					((Rectangle) shape).setHeight(50);
				}
			}
		}

		// Sets shape to the shape that was created above we need this for the actions below.
		shape = model.getSelectedShape(e.getX(), e.getY());

		if(model.getAction() == Actions.MOVE) {				   
			shapeSelected(shape);				   
		}
		if(model.getAction() == Actions.RESIZE){
			shapeSelected(shape);				   
		}
		if(model.getAction() == Actions.REMOVE){
			if (shape != null) {
				model.getShapeVector().remove(model.getSelectedShape(e.getX(), e.getY()));  	           
			}
		}

		// Changes selected shape to match color and fill parameters of the model.
		if(model.getAction() == Actions.CHANGE){      
			if (shape != null) {
				if(model.isFill()) {
					((Rectangle) shape).setFill(true);
				}
				else if(!model.isFill()) {
					((Rectangle) shape).setFill(false); 
				}
				shape.setFillColor(model.getFillColor()); 
				shape.setLineColor(model.getLineColor()); 
				model.repaint();
			}
		}
		model.repaint();
	}

	/**
	 * If mouse is released, set fill color of shape back to original state.
	 * 
	 * @param MouseEvent e
	 */
	public void mouseReleased(MouseEvent e){
		if(model.getAction() == Actions.MOVE){  
			shape.setLineColor(model.llc); 
			if(isItFilled  == true){ 
				isItFilled =  false; 
				((Rectangle) shape).setFill(true);
				((Rectangle) shape).setFillColor(model.lfc); 
			}
			model.repaint();
		}

		if(model.getAction() == Actions.RESIZE){
			if(shape != null){  
				shape.setLineColor(model.llc); 
				if(isItFilled  == true){
					isItFilled =  false; 
					((Rectangle) shape).setFill(true);
					((Rectangle) shape).setFillColor(model.lfc); 
				}
			}
			model.repaint();
		}
	}

	/**
	 * @param MouseEvent e
	 */
	public void mouseDragged(MouseEvent e) {    	           
		if (shape != null) {
			if (model.getAction() == Actions.DRAW) {
				shape.setX(Math.min(e.getX(), startX));
				shape.setY(Math.min(startY, e.getY()));
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
					((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
				}
			}
			if(model.getAction() == Actions.MOVE) {
				if (shape != null) {        	    	  
					shape.setX(e.getX());
					shape.setY(e.getY());        	                 	        
				}
			}
			if(model.getAction() == Actions.RESIZE){
				if (shape instanceof Rectangle) {   
					((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
					((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
				}   	   
			}    
		}
		model.repaint();
	}

	/**
	 * When a shape is clicked, moved, and resized, this method temporarily 
	 * changes the fill color to light gray.
	 * 
	 * @param Shape selectedShape
	 */
	private void shapeSelected(Shape selectedShape) {
		selectedShape.setLineColor(Color.WHITE); 	   	
		if(((Rectangle) selectedShape).isFill()){
			isItFilled=true;
			selectedShape.setFillColor(Color.LIGHT_GRAY);
		}
	}
}