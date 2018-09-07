package benjaminc.chief_simulator.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import benjaminc.chief_simulator.Objective;
import benjaminc.chief_simulator.Score;
import benjaminc.chief_simulator.control.Cook;
import benjaminc.chief_simulator.things.Thing;

public class Room {
	
	protected GameSpace[][] room;
	
	protected List<Cook> cooks;
	protected int width;
	protected int height;
	protected Object whenDoneSync;
	protected List<Objective> objective;
	protected Score score;
	protected Object syncObj;
	
	public Room(int w, int h, Object whenDone, Score score) {
		this(w, h, whenDone, score, new ArrayList<Cook>());
	}
	
	public Room(int w, int h, Object whenDone, Score score, List<Cook> cooks) {
		width = w;
		height = h;
		room = new GameSpace[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				room[i][j] = new GameSpace();
			}
		}
		this.cooks = cooks;
		whenDoneSync = whenDone;
		objective = new ArrayList<Objective>();
		if(score == null) {
			this.score = new Score();
		} else {
			this.score = score;
		}
		syncObj = new Object();
	}
	
	public Object getSyncObj() {
		return syncObj;
	}
	public List<Objective> getObjectives() {
		return objective;
	}
	public void setObjectives(List<Objective> o) {
		objective = o;
	}
	public void addObjectives(List<Objective> o) {
		objective.addAll(o);
	}
	public void addObjectives(Objective o) {
		objective.add(o);
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public void addThing(Thing t, int x, int y) {
		room[x][y].addThing(t);
	}
	
	public Dimension getSize() {
		return new Dimension(width, height);
	}
	
	public GameSpace getSpace(int x, int y) {
		return room[x][y];
	}
	
	public List<Thing> getThings(int x, int y) {
		return room[x][y].getThings();
	}
	public void addCook(Cook c) {
		cooks.add(c);
	}
	public void draw(Graphics g, int x, int y, int w, int h) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				room[i][j].draw(g, (i * w) + x,  (j * h) + y,  w,  h);
			}
		}
		if(cooks != null) {
			for(Cook c : cooks) {
				c.draw(g, x, y, w,  h);
			}
		}
	}
	public Score getScore() {
		return score;
	}
}
