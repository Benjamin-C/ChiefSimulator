package benjaminc.chief_simulator.things;

import java.awt.Color;
import java.awt.Graphics;

public class Floor extends SolidObject {

	public Floor() {
	}

	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.setColor(new Color(255, 128, 0));
		g.fillRect(x,  y,  w,  h);
		g.setColor(new Color(128, 64, 0));
		g.drawRect(x,  y,  w,  h);
	}
}