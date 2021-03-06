package dev.benjaminc.chef_simulator.things.food;

import java.util.UUID;

import dev.benjaminc.chef_simulator.data.DataMap;
import dev.benjaminc.chef_simulator.data.FoodState;
import dev.benjaminc.chef_simulator.data.InvalidDatatypeException;
import dev.benjaminc.chef_simulator.data.DataMap.DataMapKey;
import dev.benjaminc.chef_simulator.things.BasicThing;
import dev.benjaminc.chef_simulator.things.Thing;
import dev.benjaminc.chef_simulator.things.types.Choppable;
import dev.benjaminc.chef_simulator.things.types.Cookable;
import dev.benjaminc.chef_simulator.things.types.FoodThing;
import dev.benjaminc.chef_simulator.things.types.Fryable;

public class Potato extends BasicThing implements FoodThing, Cookable, Choppable, Fryable {

	protected final static int VARIANT_COUNT = 1;
	public Potato() {
		this(null, null);
	}
	public Potato(DataMap dataMap, UUID uuid) {
		super(dataMap, Potato.class, uuid);
	}
	public Potato(int variant, FoodState state) {
		super(variant, state, VARIANT_COUNT, Potato.class);
	}
	
//	@Override
//	public void draw(Graphics g, int x, int y, int w, int h) {
//		graphics.draw(g, x, y, w, h);
//	}
	
	@Override
	public Thing getChoppedThing() {
		try { dataMap.put(DataMapKey.FOOD_STATE, FoodState.CHOPPED);
		} catch (InvalidDatatypeException e) { e.printStackTrace(); }
		return this;
	}

	public void setState(FoodState state) {
		try { dataMap.put(DataMapKey.FOOD_STATE, state);
		} catch (InvalidDatatypeException e) { e.printStackTrace(); };
	}
	public FoodState getState() {
		try { return (FoodState) dataMap.get(DataMapKey.FOOD_STATE);
		} catch (InvalidDatatypeException e) { e.printStackTrace(); return null; }
	}
	
	@Override
	public boolean isSame(Thing t) {
		if(t != null) {
			if(t.getClass() == this.getClass()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Thing getCookedThing() {
		try {
			switch((FoodState) dataMap.get(DataMapKey.FOOD_STATE)) {
			case CHOPPED:
				dataMap.put(DataMapKey.FOOD_STATE, FoodState.CHOPPED_COOKED);
				break;
			case CHOPPED_COOKED:
				break;
			case COOKED:
				break;
			case RAW: 
				dataMap.put(DataMapKey.FOOD_STATE, FoodState.COOKED);
				break;
			default: break;
			}
		} catch (InvalidDatatypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public Thing getFriedThing() {
		try {
			switch((FoodState) dataMap.get(DataMapKey.FOOD_STATE)) {
			case CHOPPED: dataMap.put(DataMapKey.FOOD_STATE, FoodState.CHOPPED_COOKED);
				break;
			case CHOPPED_COOKED:
				break;
			case COOKED:
				break;
			case RAW:
				break;
			default: break;
			}
		} catch (InvalidDatatypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public DataMap getDataMap() {
		return dataMap;
	}
}
