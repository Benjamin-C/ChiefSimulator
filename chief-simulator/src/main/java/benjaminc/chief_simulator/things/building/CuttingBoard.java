package benjaminc.chief_simulator.things.building;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chief_simulator.things.Thing;
import benjaminc.chief_simulator.things.types.FoodThing;
import benjaminc.chief_simulator.things.types.SolidThing;
import benjaminc.chief_simulator.things.types.ToolThing;

public class CuttingBoard implements ToolThing, SolidThing {

	public CuttingBoard() {
		super();
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		int indw = w / 8;
		int indh = h / 8;
		g.setColor(new Color(64, 64, 64));
		g.fillRect(x,  y,  w,  h);
		g.setColor(new Color(192, 192, 192));
		g.fillRect(x+indw,  y+indh,  w-(2*indw),  h-(2*indh));
	}
	
	@Override
	public Thing useTool(Thing t) {
		if(t instanceof FoodThing) {
			return ((FoodThing) t).getChoppedThing();
			
		} else {
			System.out.println("not Food");
			return t;
		}
	}
}
