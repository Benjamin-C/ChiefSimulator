package dev.benjaminc.chef_simulator.things.building;

import java.util.UUID;

import dev.benjaminc.chef_simulator.data.DataMap;
import dev.benjaminc.chef_simulator.things.BasicThing;
import dev.benjaminc.chef_simulator.things.Thing;
import dev.benjaminc.chef_simulator.things.types.SolidThing;

public class DishReturn extends BasicThing implements SolidThing {
	
	protected final static int VARIANT_COUNT = 1;
	public DishReturn() {
		this(null, null);
	}
	public DishReturn(DataMap dataMap, UUID uuid) {
		super(dataMap, DishReturn.class, uuid);
	}

//	@Override
//	public void draw(Graphics g, int x, int y, int w, int h) {
//		graphics.draw(g, x, y, w, h);
//	}

	@Override
	public boolean isSame(Thing t) {
		if(t.getClass() == this.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public DataMap getDataMap() {
		return dataMap;
	}
}
