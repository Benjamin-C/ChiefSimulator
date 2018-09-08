package benjaminc.chief_simulator.things.building;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import benjaminc.chief_simulator.graphics.building.GraphicalCuttingBoard;
import benjaminc.chief_simulator.things.DataMapKey;
import benjaminc.chief_simulator.things.Thing;
import benjaminc.chief_simulator.things.types.Choppable;
import benjaminc.chief_simulator.things.types.SolidThing;
import benjaminc.chief_simulator.things.types.ToolThing;

public class CuttingBoard implements ToolThing, SolidThing {

	protected GraphicalCuttingBoard graphics;
	Map<DataMapKey, Object> dataMap;
	
	public CuttingBoard() {
		this(0);
	}
	public CuttingBoard(int var) {
		graphics = new GraphicalCuttingBoard(var);
		dataMap = new HashMap<DataMapKey, Object>();
	}
	
	@Override
	public void draw(Graphics g, int x, int y, int w, int h) {
		graphics.draw(g, x, y, w, h);
	}
	
	@Override
	public List<Thing> useTool(Thing t) {
		List<Thing> temp = new ArrayList<Thing>();
		if(t instanceof Choppable) {
			temp.add(((Choppable) t).getChoppedThing());
		} else {
			temp.add(t);
		}
		return temp;
	}

	@Override
	public Thing duplicate() {
		return new CuttingBoard();
	}
	
	@Override
	public boolean isSame(Thing t) {
		if(t.getClass() == this.getClass()) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Map<DataMapKey, Object> getDataMap() {
		return dataMap;
	}
}
