package ui.panels;

import java.awt.Choice;

import enums.ShapeEnum;

import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;
import interfaces.Resettable;

/**
 * 
 * @author Ian Fell
 *
 */
public class ChoicePanel extends Panel implements Resettable {
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;

	private Model model;
	private Choice shape;

	public ChoicePanel(Model mdl) {
		model = mdl;
		shape = new Choice();
		for(ShapeEnum shapeEnumChoice : ShapeEnum.values()) {
			shape.add(shapeEnumChoice.toString());
		}

		shape.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {               
				model.setCurrentShapeEnum(ShapeEnum.valueOf(shape.getSelectedItem().toString()));
				model.repaint();
			}
		});
		this.add(shape);//adds shape choices
	}

	public void resetComponents() {
		shape.select(0);
		model.setCurrentShapeEnum(ShapeEnum.RECTANGLE);
	}
}
