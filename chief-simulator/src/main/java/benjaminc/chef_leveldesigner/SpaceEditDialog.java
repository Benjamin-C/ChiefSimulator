package benjaminc.chef_leveldesigner;

import javax.swing.JDialog;
import javax.swing.JPanel;

import benjaminc.chef_simulator.graphics.GameSpace;
import benjaminc.chef_simulator.things.Thing;
import benjaminc.chef_simulator.things.food.Potato;
import benjaminc.chef_leveldesigner.EditableList.EditableListEvents;
import benjaminc.chef_leveldesigner.ThingEditDialog.ThingTypeChangeEvent;

/**
 * @author Benjamin-C
 *
 */
public class SpaceEditDialog {
	
	/** the {@link GameSpace} that is being edited */
	protected GameSpace space;
	
	/** the {@link Runnable} that is run when updates */
	protected Runnable onUpdate;
	
	/**
	 * @param space the {@link GameSpace} to edit
	 * @param onUpdateMe the {@link Runnable} to run on update
	 */
	public SpaceEditDialog(GameSpace space, Runnable onUpdateMe) {
		System.out.println("onUpdate was set to " + onUpdateMe);
		onUpdate = onUpdateMe;
		this.space = space;
		
		JDialog jdl = new JDialog();
		jdl.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jdl.setTitle("Edit " + space.getLoc().getX() + "," + space.getLoc().getY());
		
		JPanel panel = new JPanel();
					
		EditableList<Thing> el = new EditableList<Thing>(space.getThings(), new EditableListEvents<Thing>() {
			@Override public Thing makeNew() { return new Potato(); }
			@Override public void edit(Thing t, EditableListElement<Thing> te, EditableList<Thing> tl, EditableListEvents<Thing> onUpdate) {
				new ThingEditDialog(t, "", new ThingTypeChangeEvent() {
					Thing mt = t;
					@Override public void onChange(Thing newThing) {
						System.out.println(mt + " " + newThing);
						System.out.println(tl); tl.replace(mt, newThing); System.out.println(tl); te.set(newThing);
						mt = newThing; } },
					new Runnable() { @Override public void run() { onUpdate.onUpdate(); }});
			}

			@Override public void onUpdate() { System.out.println(onUpdate); onUpdate.run(); }
		});
		
		panel.add(el);
		
		jdl.add(panel);
		jdl.pack();
		jdl.validate();
		jdl.setVisible(true);
	}

}
