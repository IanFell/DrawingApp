package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

//creates and adds clear button
public class ButtonPanel extends Panel {
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param Model model
	 */
	public ButtonPanel(final Model model) {
		Button btnClear;
		btnClear = new Button("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.resetComponents();
				model.repaint();
			}
		});
		add(btnClear);
	}
}
