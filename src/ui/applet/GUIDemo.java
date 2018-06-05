package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import shapes.Shape;
import ui.panels.MainPanel;
import model.Model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import event.ShapeMouseHandler;

/**
 * 
 * @author Ian Fell
 *
 */
public class GUIDemo extends Applet implements Resettable{
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;
	
	private MainPanel mainPanel;
	private Model model;
	
	public static final int APPLET_WIDTH  = 800;
	public static final int APPLET_HEIGHT = 500;
	
	public Shape shape;

	public void init() {
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		setBackground(Color.gray);
		model     = new Model(this);
		mainPanel = new MainPanel(model);
		add(mainPanel);	      
		add(mainPanel.colorPanel);
		ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
	}

	/**
	 * @param Graphics g
	 */
	public void paint(Graphics g){      
		for(int i = 0; i < model.shapeVector.size(); i++){
			shape = (Shape)model.shapeVector.elementAt(i);
			if(model.shapeVector.elementAt(0) != null ){
				for(int a=0; a<model.shapeVector.size(); a++){
					shape.draw(g);
				}
			}
		}
		System.out.println(model);
		System.out.println(shape);

		g.drawString("     FILL COLOR  |  LINE COLOR", 520, 90);

		////////JAVA DRAW LOGO
		g.setColor(Color.red);
		g.fillOval(APPLET_WIDTH-225, APPLET_HEIGHT-72, 223, 65);
		g.setColor(Color.orange);
		g.fillOval(APPLET_WIDTH-215, APPLET_HEIGHT-65, 205, 50);
		Font logo = new Font("Veranda", Font.BOLD, 30);
		g.setFont(logo);
		g.setColor(Color.GREEN);
		g.drawString("JAVA DRAW", APPLET_WIDTH-200, APPLET_HEIGHT-30);
		g.setColor(Color.BLUE);
		g.drawString("JAVA DRAW", APPLET_WIDTH-202, APPLET_HEIGHT-30);			
		////////JAVA DRAW LOGO

		System.out.println("VECTOR ELEMENTS = " + model.shapeVector.size());
		for(int i=0; i<model.shapeVector.size(); i++){
			System.out.println("ELEMENT " + i + ":" + model.shapeVector.elementAt(i));  
		}
	}

	public void resetComponents() {
		mainPanel.resetComponents();
	}
}
