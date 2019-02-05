package benjaminc.chief_simulator.things.food;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import benjaminc.chief_simulator.graphics.food.GraphicalCheese;
import benjaminc.chief_simulator.things.Thing;
import benjaminc.chief_simulator.things.data.DataMapKey;
import benjaminc.chief_simulator.things.types.Choppable;
import benjaminc.chief_simulator.things.types.FoodThing;

public class Cheese implements FoodThing, Choppable {

	protected GraphicalCheese graphics;
	protected int variant;
	protected FoodState state;
	Map<DataMapKey, Object> dataMap;
	
	public Cheese() {
		this(-1, FoodState.RAW);
	}
	public Cheese(int variant, FoodState state) {
		super();
		dataMap = new HashMap<DataMapKey, Object>();
		if(variant == -1) {
			Random r = new Random();
			variant = r.nextInt(GraphicalCheese.VARIANT_COUNT);
		}
		this.state = state;
		graphics = new GraphicalCheese(variant, state);
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		graphics.draw(g, x, y, w, h);
	}
	public Thing getChoppedThing() {
		state = FoodState.CHOPPED;
		graphics.setState(state);
		return this;
	}

	public void setVariant(int var) {
		variant = var;
	}
	@Override
	public void setState(FoodState state) {
		this.state = state;
	}
	public int getVariant() {
		return variant;
	}
	@Override
	public FoodState getState() {
		return state;
	}
	@Override
	public Thing duplicate() {
		return new Cheese(variant, state);
	}
	
	@Override
	public boolean isSame(Thing t) {
		if(t.getClass() == this.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Map<DataMapKey, Object> getDataMap() {
		return dataMap;
	}
}
