package benjaminc.chief_simulator.things;

import java.awt.Color;
import java.awt.Graphics;

public class Apple extends FoodThing {

	public Apple() {
		super();
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.setColor(new Color(255, 0, 0));
		g.fillOval(x+(int)(w*0.05),  y+(int)(h*0.05), (int)(w*0.9),  (int)(h*0.9));
	}
	
	@Override
	public Thing getChoppedThing() {
		return new ChoppedApple();
	}
}
