package benjaminc.chef_simulator.graphics.building;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chef_simulator.data.DataMap;
import benjaminc.chef_simulator.graphics.GraphicalThing;

public class GraphicalWindow extends GraphicalThing {

	public GraphicalWindow(DataMap data) {
		super(data);
	}

	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		prep();
		
		int indw = w / 8;
		int indh = h / 8;
		g.setColor(new Color(100, 100, 100));
		g.fillRect(x,  y,  w,  h);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(x,  y,  w,  h);
		g.setColor(new Color(225, 225, 225));
		g.fillRect(x+(int)(indw*.7),  y,  w-(int)(1.4*indw),  h-(int)(indh*.7));
		g.setColor(new Color(192, 192, 192));
		g.fillRect(x+indw,  y,  w-(2*indw),  h-indh);
	}
}