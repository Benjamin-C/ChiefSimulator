package dev.benjaminc.chef_leveldesigner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import dev.benjaminc.chef_leveldesigner.ThingEditDialog.ThingTypeChangeEvent;
import dev.benjaminc.chef_simulator.Objective;
import dev.benjaminc.chef_simulator.things.Thing;
import dev.benjaminc.chef_simulator.things.food.Potato;
import dev.benjaminc.chef_textures.dialog.MessageDialog;

/**
 * @author Benjamin-C
 *
 */
public class ObjectiveEditDialog {
	
	public interface ObjectiveTypeChangeEvent {
		/**
		 * Sets what happens when the {@link Objective} becomes a new {@link Objective};
		 * @param newObjective the new {@link Objective}
		 */
		public abstract void onChange(Objective newObjective);
	}
	
	protected Objective obj;
	protected ObjectiveTypeChangeEvent onThingTypeChange;
	
	protected JDialog jdl;
	
	protected JPanel jp;
	
	/**
	 * Makes a new {@link ObjectiveEditDialog} in a popup
	 * @param th the {@link Thing} to edit
	 * @param extra the {@link String} to add to the title
	 * @param onThingTypeChange the {@link Runnable} to run when the ThingType changes
	 * @param onUpdate the {@link Runnable} to run when anything changes. Runs after others
	 */
	public ObjectiveEditDialog(Objective ob, String extra, ObjectiveTypeChangeEvent onThingTypeChange, Runnable onUpdateRunnable) {
		this(ob, extra, onThingTypeChange, onUpdateRunnable, true);
	}
	/**
	 * Makes a new {@link ObjectiveEditDialog}
	 * @param th the {@link Thing} to edit
	 * @param extra the {@link String} to add to the title
	 * @param onThingTypeChange the {@link ThingTypeChangeEvent} to run when the ThingType changes
	 * @param onUpdate the {@link Runnable} to run when anything changes. Runs after others
	 * @param seperate a {@link Boolean} to select if the dialog should create a popup to exist in
	 */
	public ObjectiveEditDialog(Objective ob, String extra, ObjectiveTypeChangeEvent onThingTypeChange, Runnable onUpdateRunnable, boolean seperate) {
		if(ob == null) {
			obj = new Objective(new Potato(), 5);
			onThingTypeChange.onChange(obj);
			onUpdateRunnable.run();
		} else {
			obj = ob;
		}
		
		this.onThingTypeChange = onThingTypeChange;
		
		System.out.println("This is a ThingEditDialog");
		
		Runnable onUpdate = new Runnable() {
			@Override
			public void run() {
				onUpdateRunnable.run();
				setTitle(obj, extra);
			}
		};
		
		jp  = new JPanel();
		
		JButton thgbtn = new JButton("Thing");
		thgbtn.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {
				new ThingEditDialog(obj.getTarget(), "", new ThingTypeChangeEvent() {
					@Override public void onChange(Thing newThing) { obj.setTarget(newThing); }
				}, new Runnable() {
					@Override public void run() { onUpdate.run();}
				});
			}
		});
		
		jp.add(thgbtn);
		
		JTextArea scorearea = new JTextArea(1, 4);
		scorearea.setText(Integer.toString(obj.getScore()));
		scorearea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "check");
		scorearea.getActionMap().put("check", new AbstractAction() {
			private static final long serialVersionUID = 6672135527803981557L; // Keep Eclipse happy
			@Override public void actionPerformed(ActionEvent arg0) {
				try { obj.setScore(Integer.parseInt(scorearea.getText())); new MessageDialog("Saved", "Saved"); }
				catch(NumberFormatException e) { new MessageDialog("That is not a number", "Please fix it"); }
			}
		});
		jp.add(scorearea);
		
		JLabel instruct = new JLabel("Press ENTER to save");
		jp.add(instruct);

		if(seperate) {
			jdl = new JDialog();
			setTitle(obj, extra);
			
			jdl.add(jp);
			jdl.pack();
			jdl.validate();
			jdl.setVisible(true);
		}
	}
	
	/**
	 * Gets the {@link JPanel} editor
	 * @return the {@link JPanel}
	 */
	public JPanel getPanel() {
		return jp;
	}
	/**
	 * Sets the {@link Runnable} to run when the ThingType changes
	 * @param onThingTypeChange the {@link Runnable} to run
	 */
	public void setOnThingTypeChange(ObjectiveTypeChangeEvent onThingTypeChange) {
		this.onThingTypeChange = onThingTypeChange;
	}
	
	/**
	 * Gets the {@link Thing} this {@link ObjectiveEditDialog} is editing
	 * @return the {@link Thing}
	 */
	public Objective getThing() {
		return obj;
	}

	/**
	 * Sets the window title
	 * @param me the {@link JDialog} to edit
	 * @param t the {@link Thing} we are editing
	 * @param extra the {@link String} extra text to add
	 */
	private void setTitle(Objective t, String extra) {
		if(jdl != null) {
			jdl.setTitle("Edit Objective " + extra);
		}
	}
}
