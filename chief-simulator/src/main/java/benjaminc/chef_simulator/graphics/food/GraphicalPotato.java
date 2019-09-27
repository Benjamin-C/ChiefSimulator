package benjaminc.chef_simulator.graphics.food;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chef_simulator.data.DataMap;
import benjaminc.chef_simulator.graphics.GraphicalThing;

public class GraphicalPotato extends GraphicalThing {
	
	public GraphicalPotato(DataMap data) {
		super(data);
	}

	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		prep();
		
		int pos1 = (int)(w*.35);
		int pos2 = (int)(w*.45);
		int pos3 = (int)(w*.55);
		switch(state) {
		case CHOPPED: {
			switch(variant) {
			case 0: {
				Color a = new Color(209, 190, 23).brighter();
				Color b = new Color(189, 170, 23);
				g.setColor(a);
				g.fillRect(x+pos1, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
				g.setColor(b);
				g.drawRect(x+pos1, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
				g.setColor(a);
				g.fillRect(x+pos3, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
				g.setColor(b);
				g.drawRect(x+pos3, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
				g.setColor(a);
				g.fillRect(x+pos2, y+(int)(h*0.2), (int)(w*0.1), (int)(h*0.6));
				g.setColor(b);
				g.drawRect(x+pos2, y+(int)(h*0.2), (int)(w*0.1), (int)(h*0.6));
			} break;
			}
		} break; // end chopped case
		case CHOPPED_COOKED: {
			g.setColor(new Color(183, 165, 11));
			g.fillRect(x+pos1, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
			g.fillRect(x+pos3, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
			g.fillRect(x+pos2, y+(int)(h*0.2), (int)(w*0.1), (int)(h*0.6));
			
			// java.awt.Color[r=132,g=118,b=16]
			g.setColor(new Color(189, 170, 23).darker());
			g.drawRect(x+pos1, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
			g.drawRect(x+pos3, y+(int)(h*0.3), (int)(w*0.1), (int)(h*0.6));
			g.drawRect(x+pos2, y+(int)(h*0.2), (int)(w*0.1), (int)(h*0.6));
		} break; // End chopped_cooked case
		case COOKED: {
			g.setColor(new Color(183, 165, 11));
			g.fillOval(x+(int)(w*0.1),  y+(int)(h*0.25), (int)(w*0.8),  (int)(h*0.5));
		} break; // End cooked case
		case RAW: {
			switch(variant) {
			case 0: { 
				g.setColor(new Color(209, 190, 23));
				g.fillOval(x+(int)(w*0.1),  y+(int)(h*0.25), (int)(w*0.8),  (int)(h*0.5));
			} break;
			}
		} break; // End raw case
		default: break;
		}
	}
}
