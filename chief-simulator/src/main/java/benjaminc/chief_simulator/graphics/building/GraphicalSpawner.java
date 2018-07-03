package benjaminc.chief_simulator.graphics.building;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chief_simulator.graphics.GraphicalThing;
import benjaminc.chief_simulator.things.food.FoodState;

public class GraphicalSpawner implements GraphicalThing {

	public static final int VARIANT_COUNT = 1;
	protected int variant;
	public GraphicalSpawner(int variant) {
		this.variant = variant;
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		int indw = w / 8;
		int indh = h / 8;
		g.setColor(new Color(64, 64, 64));
		g.fillRect(x,  y,  w,  h);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(x,  y,  w,  h);
		g.setColor(new Color(134, 100, 3));
		g.fillRect(x+indw,  y+indh,  w-(int)(2*indw),  h-(int)(2*indh));
		g.setColor(new Color(104, 70, 3));
		g.fillRect(x+(int)(indw*1.5),  y+(int)(indh*1.5),  w-(int)(3*indw),  h-(int)(3*indh));
	}
	
	@Override
	public void setState(FoodState state) {
		
	}

	@Override
	public void setVariant(int var) {
		variant = var;
	}

}