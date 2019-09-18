package benjaminc.chef_simulator.graphics.food;

import java.awt.Color;
import java.awt.Graphics;

import benjaminc.chef_simulator.data.DataMap;
import benjaminc.chef_simulator.graphics.GraphicalThing;

public class GraphicalApple extends GraphicalThing {
	
	public GraphicalApple(DataMap data) {
		super(data);
	}

	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		prep();
		
		int five_twelths = (int) ((int) w*0.4583333333333333333);
		
		switch(state) {
		case CHOPPED: {
			switch(variant) {
			case 0: { 
				g.setColor(new Color(206, 0, 0));
				g.fillOval(x+(int)(w*0.05),  y+(int)(h*0.05), (int)(w*0.9),  (int)(h*0.9));
				g.setColor(new Color(216, 221, 117));
				g.drawLine(x+(w/2), y+(int)(h*0.05), x+(w/2), y+(int)(h*0.95));
				g.drawOval(x+(w/4), y+(int)(h*0.06), w/2, (int)(h*0.88));
			} break;
			case 1: {
				g.setColor(new Color(57, 219, 46));
				g.fillOval(x+(int)(w*0.05),  y+(int)(h*0.05), (int)(w*0.9),  (int)(h*0.9));
				g.setColor(new Color(249, 252, 189));
				g.drawLine(x+(w/2), y+(int)(h*0.05), x+(w/2), y+(int)(h*0.95));
				g.drawOval(x+(w/4), y+(int)(h*0.06), w/2, (int)(h*0.88));
			} break;
			}
		} break; // end chopped case
		case CHOPPED_COOKED: {
		} break; // End chopped_cooked case
		case COOKED: {
		} break; // End cooked case
		case RAW: {
			switch(variant) {
			case 0: { 
				g.setColor(new Color(206, 0, 0));
				g.fillOval(x+(int)(w*0.05),  y+(int)(h*0.05), (int)(w*0.9),  (int)(h*0.9));
				g.setColor(new Color(0, 128, 0));
				g.fillRect(x+five_twelths, y-(int)(h/16), (int)(w/12), (int)(h/4));
			} break;
			case 1: {
				g.setColor(new Color(57, 219, 46));
				g.fillOval(x+(int)(w*0.05),  y+(int)(h*0.05), (int)(w*0.9),  (int)(h*0.9));
				g.setColor(new Color(0, 128, 0));
				g.fillRect(x+five_twelths, y-(int)(h/16), (int)(w/12), (int)(h/4));
			} break;
			}
		} break; // End raw case
		}
	}
}