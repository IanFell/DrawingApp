package ui.panels;

import interfaces.Resettable;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;

import model.Model;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import enums.Actions;

/**
 * 
 * @author Ian Fell
 *
 */
public class ActionPanel extends Panel implements Resettable {
	/**
	 * Keep compiler happy.
	 */
	private static final long serialVersionUID = 1L;

	private CheckboxGroup actionGroup;
	private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill; 

	/**
	 * 
	 * @param Model model
	 */
	public ActionPanel(final Model model){
		actionGroup = new CheckboxGroup();
		chkDraw     = new Checkbox(Actions.DRAW.toString(), actionGroup, true); 
		chkMove     = new Checkbox(Actions.MOVE.toString(), actionGroup, false);
		chkResize   = new Checkbox(Actions.RESIZE.toString(), actionGroup, false);
		chkRemove   = new Checkbox(Actions.REMOVE.toString(), actionGroup, false);
		chkChange   = new Checkbox(Actions.CHANGE.toString(), actionGroup, false);
		chkFill     = new Checkbox(Actions.FILL.toString(), false);

		chkDraw.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setAction(Actions.DRAW);
			}
		});
		chkMove.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setAction(Actions.MOVE);
			}
		});
		chkResize.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setAction(Actions.RESIZE);
			}
		});
		chkRemove.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setAction(Actions.REMOVE);
			}
		});
		chkChange.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setAction(Actions.CHANGE);
			}
		});
		chkFill.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setFill(chkFill.getState());
			}
		});

		setLayout(new GridLayout(1,7));

		add(chkDraw);
		add(chkMove);
		add(chkResize);
		add(chkRemove);
		add(chkChange);
		add(chkFill);
	}

	public void resetComponents() {
		chkDraw.setState(true);
		chkMove.setState(false);
		chkResize.setState(false);
		chkRemove.setState(false);
		chkChange.setState(false);
		chkFill.setState(false);

	}
}