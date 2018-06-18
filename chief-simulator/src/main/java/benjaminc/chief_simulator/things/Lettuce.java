package benjaminc.chief_simulator.things;

import java.awt.Color;
import java.awt.Graphics;

public class Lettuce extends FoodThing{
	public Lettuce() {
		super();
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.setColor(new Color(0, 255, 0));
		g.fillRect(x+1,  y+1,  w-2,  h-2);
	}
	
	@Override
	public Thing getChoppedThing() {
		return new ChoppedLettuce();
	}
}
