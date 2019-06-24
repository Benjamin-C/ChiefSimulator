package benjaminc.chief_simulator.graphics.building;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chief_simulator.control.Direction;
import benjaminc.chief_simulator.data.DataMap;
import benjaminc.chief_simulator.data.DataMapKey;
import benjaminc.chief_simulator.graphics.GraphicalThing;
import benjaminc.chief_simulator.things.food.FoodState;

public class GraphicalRemover implements GraphicalThing {

	public static final int VARIANT_COUNT = 1;
	protected DataMap dataMap;
	public GraphicalRemover(DataMap data) {
		dataMap = data;
	}	
	
	@Override
	@SuppressWarnings("unused")
	public void draw(Graphics g, int x, int y, int w, int h) {
		int variant = (Integer) dataMap.get(DataMapKey.VARIANT);
		Direction dir = (Direction) dataMap.get(DataMapKey.DIRECTION);
		FoodState state = (FoodState) dataMap.get(DataMapKey.FOOD_STATE);
		
		int indw = w / 8;
		int indh = h / 8;
		g.setColor(new Color(100, 100, 100));
		g.fillRect(x,  y,  w,  h);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(x,  y,  w,  h);
		g.setColor(new Color(16, 16, 16));
		g.drawRect(x+indw,  y+indh,  w-(2*indw),  h-(2*indh));
		g.setColor(new Color(48, 48, 48));
		g.fillRect(x+indw,  y+indw,  w-(2*indw),  h-(2*indh));
		g.setColor(new Color(32, 32, 32));
		g.fillRect(x+(int)(indw*1.35),  y+(int)(indw*1.35),  w-(int)(2.7*indw),  h-(int)(2.7*indh));
		g.setColor(new Color(16, 16, 16));
		g.fillRect(x+(int)(indw*1.7),  y+(int)(indw*1.7),  w-(int)(3.4*indw),  h-(int)(3.4*indh));
		g.setColor(new Color(64, 0, 0));
		g.fillRect(x+(int)(indw*2.05),  y+(int)(indw*2.05),  w-(int)(4.1*indw),  h-(int)(4.1*indh));
	}
}
