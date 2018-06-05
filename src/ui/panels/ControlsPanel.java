package ui.panels;

import java.awt.Panel;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;

/**
 * 
 * @author Ian Fell
 *
 */
public class ControlsPanel extends Panel implements Resettable{  
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;
	
    private ButtonPanel btnPanel;
       
    /**
     * 
     * @param Model model
     */
    public ControlsPanel (Model model) {
        btnPanel = new ButtonPanel(model);
        add(btnPanel);       
    }
  
    public void resetComponents() {}
}
