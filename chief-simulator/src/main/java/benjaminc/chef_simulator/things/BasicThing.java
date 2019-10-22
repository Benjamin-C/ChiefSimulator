package benjaminc.chef_simulator.things;

import java.util.Random;

import benjaminc.chef_simulator.control.Direction;
import benjaminc.chef_simulator.data.DataMap;
import benjaminc.chef_simulator.data.DataMapKey;
import benjaminc.chef_simulator.data.FoodState;
import benjaminc.chef_simulator.graphics.GraphicalLoader;

/**
 * the class to hold all Things for easier usage
 * @author Benjamin-C
 *
 */
public class BasicThing implements Thing, Cloneable {

	//protected GraphicalThing graphics;
	protected DataMap dataMap;
	protected Class<?> subclass;
	
	/**
	 * Creates a new {@link BasicThing}
	 * @param dataMap the {@link DataMap} information for the Thing
	 * @param subclass the {@link Class} of the {@link Thing} this represents
	 */
	@SuppressWarnings("deprecation")
	public BasicThing(DataMap dataMap, Class<?> subclass) {
		this.subclass = subclass;
		this.dataMap = dataMap;
		if(this.dataMap == null) {
			this.dataMap = new DataMap();
		}
		if(!this.dataMap.containsKey(DataMapKey.VARIANT_COUNT)) {
			this.dataMap.put(DataMapKey.VARIANT_COUNT, 1);
		}
		if(!this.dataMap.containsKey(DataMapKey.VARIANT)) {
			Random r = new Random();
			this.dataMap.put(DataMapKey.VARIANT_COUNT, r.nextInt((int) this.dataMap.get(DataMapKey.VARIANT_COUNT)));
		}
		if(!this.dataMap.containsKey(DataMapKey.DIRECTION)) {
			this.dataMap.put(DataMapKey.DIRECTION, Direction.UP);
		}
		if(!this.dataMap.containsKey(DataMapKey.FOOD_STATE)) {
			this.dataMap.put(DataMapKey.FOOD_STATE, FoodState.RAW);
		}
		if(subclass != null) {
			String pkg = this.subclass.getPackage().getName();
			pkg = pkg.substring(pkg.lastIndexOf(".")+1);
			this.dataMap.put(DataMapKey.TEXTURE, GraphicalLoader.load(pkg + "/" + this.subclass.getSimpleName()));
		}
		
	}
	/**
	 * Creates a new {@link BasicThing}
	 * @param dataMap the {@link DataMap} information for the Thing
	 * @param variantCount the int of total possible variants. Currently does nothing
	 * @param subclass the {@link Class} of the {@link Thing} this represents
	 */
	@SuppressWarnings("deprecation")
	public BasicThing(DataMap dataMap, int variantCount, Class<?> subclass) {
		this(dataMap, subclass);
		this.dataMap.put(DataMapKey.VARIANT_COUNT, variantCount);
	}
	/**
	 * Creates a new {@link BasicThing}
	 * @param variant the int variant of the thing. Currently does nothing
	 * @param state the {@link FoodState} of the thing
	 * @param variantCount the int of total possible variants. Currently does nothing
	 * @param subclass the {@link Class} of the {@link Thing} this represents
	 */
	@SuppressWarnings("deprecation")
	public BasicThing(int variant, FoodState state, int variantCount, Class<?> subclass) {
		this(null, variantCount, subclass);
		dataMap.put(DataMapKey.VARIANT, variant);
		if(state != null) {
			dataMap.put(DataMapKey.FOOD_STATE, state);
		} else {
			dataMap.put(DataMapKey.FOOD_STATE, FoodState.RAW);
		}
	}
	
	@Override
	public boolean equals(Thing t) {
		if(t instanceof BasicThing) {
			BasicThing bt = (BasicThing) t;
			if(bt.getSubclass().equals(subclass)) {
				if(dataMap.equals(t.getDataMap())) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Thing clone() {
		try {
			Thing t = (Thing) super.clone();
			t.setDataMap(dataMap.clone());
			return t;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//return new BasicThing(dataMap.clone(), subclass);
	}

	@Override
	public boolean isSame(Thing t) {
		System.out.println("BasicThingSame?");
		if(!t.getClass().equals(getClass())) {
			System.out.println("Class does not match");
			return false;
		} else {
			if(! t.getDataMap().equals(dataMap)) {
				System.out.println("Data map does not match");
				return false;
			}
		}
		System.out.println("BasicThing is same");
		return true;
	}
	@Override
	public DataMap getDataMap() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDataMap(DataMap m) {
		this.dataMap = m;
	}
	@Override
	public String getName() {
		return subclass.getSimpleName();
	}
	@Override
	public Class<?> getSubclass() {
		return subclass;
	}
}
