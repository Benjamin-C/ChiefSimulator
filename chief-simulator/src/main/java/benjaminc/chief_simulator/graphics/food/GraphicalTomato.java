package benjaminc.chief_simulator.graphics.food;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chief_simulator.control.Direction;
import benjaminc.chief_simulator.data.DataMap;
import benjaminc.chief_simulator.data.DataMapKey;
import benjaminc.chief_simulator.graphics.GraphicalThing;
import benjaminc.chief_simulator.things.food.FoodState;

public class GraphicalTomato implements GraphicalThing {

	public static final int VARIANT_COUNT = 1;
	protected DataMap dataMap;
	public GraphicalTomato(DataMap data) {
		dataMap = data;
	}	
	
	@Override
	@SuppressWarnings("unused")
	public void draw(Graphics g, int x, int y, int w, int h) {
		int variant = (Integer) dataMap.get(DataMapKey.VARIANT);
		Direction dir = (Direction) dataMap.get(DataMapKey.DIRECTION);
		FoodState state = (FoodState) dataMap.get(DataMapKey.FOOD_STATE);
		
		switch(state) {
		case CHOPPED: {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(x+(int)(w*.05), y+(int)(h*.05), (int)(w*.9), (int)(h*.9));
			g.setColor(new Color(200, 0, 0));
			g.fillOval(x+(int)(w*.1), y+(int)(h*.1), (int)(w*0.8), (int)(h*0.8));
			g.setColor(new Color(255, 0, 0));
			g.fillRect(x+(int)(w*0.45), y+(int)(h*.1), (int)(w*0.1), (int)(h*0.8));
			g.fillRect(x+(int)(w*.1), y+(int)(h*0.45), (int)(w*0.8), (int)(h*0.1));
		} break;
		case CHOPPED_COOKED:
			break;
		case COOKED:
			break;
		case RAW: {
			g.setColor(new Color(255, 0, 0));
			g.fillOval(x+(int)(w*.05), y+(int)(h*.12), (int)(w*.9), (int)(h*.76));
		} break;
		}
	}
}
