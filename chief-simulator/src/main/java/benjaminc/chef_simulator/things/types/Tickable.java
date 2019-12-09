package benjaminc.chef_simulator.things.types;

import benjaminc.chef_simulator.control.Location;
import benjaminc.chef_simulator.rooms.Room;

public interface Tickable {

	public abstract void tick(Room r, Location l, double f);
}
