package benjaminc.chef_simulator.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import benjaminc.chef_simulator.things.BasicThing;

public class DataMap {
	
	protected Map<DataMapKey, Object> dataMap;
	
	public DataMap() {
		dataMap = new HashMap<DataMapKey, Object>();
		put(DataMapKey.UUID, UUID.randomUUID());
	}
	
	public Object get(DataMapKey key) {
		return dataMap.get(key);
	}
	public void update() {
		
	}
	public boolean containsKey(DataMapKey test) {
		return dataMap.containsKey(test);
	}
	public void put(DataMapKey key, Object value) {
		if(checkForType(value, key.getType())) {
			dataMap.put(key, value);
		} else {
			throw new InvalidDatatypeException("DataMapValue must be of type " + key.getType() + ", not " + value.getClass().getSimpleName());
		}
	}
	@Override
	public DataMap clone() {
		DataMap newdm = new DataMap();
		for(DataMapKey k : dataMap.keySet()) {
			switch(k) {
			case INVENTORY: newdm.put(k, ((Inventory) dataMap.get(k)).clone());
				break;
			case MAKES: newdm.put(k, ((BasicThing) dataMap.get(k)).clone());
				break;
			case FOOD_STATE: newdm.put(k, ((FoodState) dataMap.get(k)).clone((FoodState) dataMap.get(k)));
			default: newdm.put(k, dataMap.get(k)); break;
			
			}
		}
		System.out.println("Cloned data map " + this + " to " + newdm);
		
		return newdm;
	}
	public boolean equals(DataMap dm) {
		if(dataMap.keySet().size() != dm.dataMap.keySet().size()) {
			return false;
		}
		for(DataMapKey k : dataMap.keySet()) {
			if(!dm.containsKey(k)) {
				return false;
			}
			if(k == DataMapKey.UUID || !dataMap.get(k).equals(dm.get(k))) {
				return false;
			}
		}
		return true;
	}
	private boolean checkForType(Object candidate, Class<?> type){
	    return type.isInstance(candidate);
	}

}
