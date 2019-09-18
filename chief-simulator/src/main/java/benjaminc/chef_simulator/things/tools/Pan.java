package benjaminc.chef_simulator.things.tools;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import benjaminc.chef_simulator.data.DataMap;
import benjaminc.chef_simulator.data.DataMapKey;
import benjaminc.chef_simulator.data.FoodState;
import benjaminc.chef_simulator.data.Inventory;
import benjaminc.chef_simulator.things.BasicThing;
import benjaminc.chef_simulator.things.Thing;
import benjaminc.chef_simulator.things.types.ContainerThing;
import benjaminc.chef_simulator.things.types.Cookable;
import benjaminc.chef_simulator.things.types.CookwareThing;

public class Pan extends BasicThing implements CookwareThing, ContainerThing{

	protected final static int VARIANT_COUNT = 1;
	protected final static int MAX_INV_SIZE = 1;
	public Pan() {
		this(null);
	}
	public Pan(DataMap dataMap) {
		super(dataMap, VARIANT_COUNT, Pan.class);
		finalPrep();
	}
	public Pan(int variant, Thing item) {
		super(variant, FoodState.RAW, VARIANT_COUNT, Pan.class);
		dataMap.put(DataMapKey.INVENTORY, new Inventory(item));
		finalPrep();
	}
	private void finalPrep() {
		if(!dataMap.containsKey(DataMapKey.INVENTORY) || dataMap.get(DataMapKey.INVENTORY) == null) {
			dataMap.put(DataMapKey.INVENTORY, new Inventory(1));
		}
	}
	
	@Override
	public List<Thing> useTool(Thing t) {
		checkItemKey();
		List<Thing> out = new ArrayList<Thing>();
		if(!dataMap.containsKey(DataMapKey.INVENTORY) || dataMap.get(DataMapKey.INVENTORY) == null) {
			dataMap.put(DataMapKey.INVENTORY, new Inventory(1));
		}
		Inventory i = (Inventory) dataMap.get(DataMapKey.INVENTORY);
		if(i.isEmpty()) {
			i.put(t, 0);
		} else {
			out.add(i.get(0));
			i.remove(0);
		}
		return out;
	}

	@Override
	public Thing getCookedThing() {
		checkItemKey();
		Thing thing = ((Inventory) dataMap.get(DataMapKey.INVENTORY)).get(0);
		System.out.println("Thing is " + thing);
		if(thing instanceof Cookable) {
			((Inventory) dataMap.get(DataMapKey.INVENTORY)).put(((Cookable) thing).getCookedThing(), 0);
			System.out.println("Trying to cook " + thing + " into " + ((Cookable) thing).getCookedThing());
		} else {
			System.out.println("Thing " + thing + " is not cookable");
		}
		return this;
	}
	
	@Override
	public void addItem(Thing t) {
		checkItemKey();
		((Inventory) dataMap.get(DataMapKey.INVENTORY)).put(t, 0);
	}

	@Override
	public void removeItem(Thing t) {
		checkItemKey();
		((Inventory) dataMap.get(DataMapKey.INVENTORY)).remove(t);
	}

	@Override
	public Inventory getItems() {
		checkItemKey();
		return (Inventory) dataMap.get(DataMapKey.INVENTORY);
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		checkItemKey();
		graphics.draw(g, x, y, w, h);
		Thing t = ((Inventory) dataMap.get(DataMapKey.INVENTORY)).get(0);
		if(t != null) {
			t.draw(g, x+(w/4), y+(h/4), w/2, h/2);
		}
	}
	
	@Override
	public boolean isSame(Thing t) {
		checkItemKey();
		if(t != null) {
			if(t instanceof Pan) {
				if(((Pan) t).getItems().get(0).isSame(((Inventory) dataMap.get(DataMapKey.INVENTORY)).get(0))) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public DataMap getDataMap() {
		return dataMap;
	}
	@Override
	public Inventory giveAllItems() {
		checkItemKey();
		Inventory out = (Inventory) dataMap.get(DataMapKey.INVENTORY);
		((Inventory) dataMap.get(DataMapKey.INVENTORY)).put(null, 0);
		return out;
	}
	private void checkItemKey() {
		if(!dataMap.containsKey(DataMapKey.INVENTORY) || dataMap.get(DataMapKey.INVENTORY) == null) {
			dataMap.put(DataMapKey.INVENTORY, new Inventory(MAX_INV_SIZE));
		}
	}
}