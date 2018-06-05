package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



import model.Model;

/**
 * 
 * @author Ian Fell
 *
 */
public class MainPanel extends Panel implements Resettable {
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;

	private ActionPanel actionPanel;
	private ControlsPanel controlsPanel;
	public ColorPanel colorPanel;
	private ChoicePanel choicePanel;
	public Model model;

	/**
	 * 
	 * @param Model model
	 */
	public MainPanel(Model model) {
		actionPanel   = new ActionPanel(model);
		controlsPanel = new ControlsPanel(model);
		setColorPanel(new ColorPanel(model));
		choicePanel   = new ChoicePanel(model);
		setLayout(new GridLayout(5,5));
		add(controlsPanel);
		add(actionPanel);
		add(choicePanel);
	}

	public void resetComponents() {
		controlsPanel.resetComponents();
		actionPanel.resetComponents();
		getColorPanel().resetComponents();
		choicePanel.resetComponents();
	}

	/**
	 * This class is for the ColorPanels (drop down menus and options).	
	 * 
	 * @author Ian Fell
	 *
	 */
	public static class ColorPanel extends Panel implements ActionListener {
		/**
		 * Keep compiler happy.
		 */
		private static final long serialVersionUID = 1L;
		
		public String[] color = {
				"Black", 
				"Blue", 
				"Green", 
				"Yellow", 
				"Orange", 
				"Cyan", 
				"Pink", 
				"Red"
				};

		Choice colors;
		Choice lines;

		public static String currentFillColor;
		public static String currentLineColor;
		public static Color fillColor;
		public static Color lineColors;
		private Model model;

		/**
		 * 
		 * @param Model model
		 */
		public ColorPanel(final Model model) {
			this.model = model; 
			colors     = new Choice();
			lines      = new Choice();
			
			for(final String msg : color) {
				colors.add(msg);
				lines.add(msg);
			}
			
			colors.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					getTheColor(colors.getSelectedItem());
					model.setFillColor(fillColor);
					colors.repaint();
				}});    

			
			lines.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					getTheLineColor(lines.getSelectedItem());
					model.setLineColor(lineColors);  
					lines.repaint(); 		    		        			    		         	    		        	    		            
				}});

			this.add(colors);
			this.add(lines);
		}

		public void resetComponents() {
			fillColor  = Color.black;
			lineColors = Color.black;
			model.setFillColor(fillColor);
			model.setLineColor(lineColors);
			colors.select(0);
			lines.select(0);
		}

		/**
		 * 
		 * @param String currentColor
		 * @return Color
		 */
		public static Color getTheColor(String currentColor) {

			if(currentColor == "Black") {
				fillColor = Color.black;
			}	

			else if(currentColor == "Blue") {
				fillColor = Color.blue;
			}	

			else if(currentColor == "Green"){
				fillColor = Color.green;
			}	

			else if(currentColor == "Yellow") {
				fillColor = Color.yellow;
			}	

			else if(currentColor == "Orange") {
				fillColor = Color.orange;
			}	

			else if(currentColor == "Cyan") {
				fillColor = Color.cyan;
			}	

			else if(currentColor == "Pink") {
				fillColor = Color.pink;
			}	

			else if(currentColor == "Red") {
				fillColor = Color.red;
			}	

			return fillColor;
		}

		/**
		 * 	
		 * @param String currentLineColor
		 * @return Color
		 */
		public static Color getTheLineColor(String currentLineColor) {

			if(currentLineColor == "Black") {
				lineColors = Color.black;
			}	

			else if(currentLineColor == "Blue") {
				lineColors = Color.blue;
			}	

			else if(currentLineColor == "Green") {
				lineColors = Color.green;
			}	

			else if(currentLineColor == "Yellow") {
				lineColors = Color.yellow;
			}	

			else if(currentLineColor == "Orange") {
				lineColors = Color.orange;
			}	

			else if(currentLineColor == "Cyan") {
				lineColors = Color.cyan;
			}	

			else if(currentLineColor == "Pink") {
				lineColors = Color.pink;
			}	

			else if(currentLineColor == "Red") {
				lineColors = Color.red;
			}	

			return lineColors;
		}

		@Override
		public void actionPerformed(ActionEvent e) {}

	}

	public ColorPanel getColorPanel() {
		return colorPanel;
	}

	public void setColorPanel(ColorPanel colorPanel) {
		this.colorPanel = colorPanel;
	}
}
