package benjaminc.chief_simulator.things.building;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import benjaminc.chief_simulator.graphics.building.GraphicalSpawner;
import benjaminc.chief_simulator.graphics.food.GraphicalApple;
import benjaminc.chief_simulator.things.Thing;
import benjaminc.chief_simulator.things.food.Bun;
import benjaminc.chief_simulator.things.types.SolidThing;
import benjaminc.chief_simulator.things.types.ToolThing;

public class Spawner implements ToolThing, SolidThing {

	protected Thing toMake;
	protected GraphicalSpawner graphics;
	
	public Spawner(Thing t) {
		this(t, 0);
	}
	public Spawner(Thing t, int var) {
		toMake = t;
		graphics = new GraphicalSpawner(var);
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		int indmkw = w / 4;
		int indmkh = h / 4;
		graphics.draw(g, x, y, w, h);
		toMake.draw(g, x+indmkw,  y+indmkh,  w-(2*indmkw),  h-(2*indmkh));
	}

	@Override
	public List<Thing> useTool(Thing t) {
		List<Thing> temp = new ArrayList<Thing>();
		if(t == null) {
			temp.add(toMake.duplicate());
		}
		temp.add(t);
		return temp;
	}

	@Override
	public Thing duplicate() {
		return new Spawner(toMake.duplicate());
	}

	@Override
	public boolean isSame(Thing t) {
		if(t.getClass() == this.getClass()) {
			return true;
		} else {
			return false;
		}
	}
}
