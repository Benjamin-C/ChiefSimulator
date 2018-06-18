package benjaminc.chief_simulator.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import benjaminc.chief_simulator.things.*;
import benjaminc.chief_simulator.things.building.Floor;
import benjaminc.chief_simulator.things.types.SolidThing;

public class GameSpace {

	List<Thing> things;
	public GameSpace() {
		things = new ArrayList<Thing>();
		things.add(new Floor());
	}
	
	public void addThing(Thing t) {
		things.add(t);
	}
	
	public void addThing(int loc, Thing t) {
		things.add(loc, t);
	}
	
	public void removeThing(Thing t) {
		things.remove(t);
	}
	public void removeAll(Thing t) {
		for(int i = 0; i < things.size(); i++) {
			if(things.get(i).getClass().isAssignableFrom( t.getClass() )) {
				things.remove(i--);
			}
		}
	}
	public Thing removeThing(int loc) {
		Thing temp = things.remove(loc);
		if(things.size() < 1) {
			things.add(new Floor());
		}
		return temp;
	}
	
	public Thing getThing(int loc) {
		return things.get(loc);
	}
	
	public Thing getThing() {
		return things.get(things.size() - 1);
	}
	
	public List<Thing> getThings() {
		return things;
	}
	
	public void draw(Graphics g, int x, int y, int w, int h) {
		for(int i = 0; i < things.size(); i++) {
			things.get(i).draw(g, x, y, w, h);
		}
	}
	
	public boolean isSolid() {
		for(Thing th : things) {
			if(th instanceof SolidThing) {
				return true;
			}
		}
		return false;
	}
}
