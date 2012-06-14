/** Group.java
 * This represents a generic group of objects linked together through connection nodes
 * All of the nodes are connected based on their current positions
 */

import java.util.*;

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Group extends PhysObject implements Connector {
	private ArrayList<PhysObject> group = new ArrayList<PhysObject>();
	private HashMap<NodePair,NodePair> nodeMap = new HashMap<NodePair,NodePair>();
	
	/**
	 * This is the constructor for a group of PhysObjects
	 * 
	 * @param group
	 */
	public Group(ArrayList<PhysObject> group) {
		super(Shape.Group, 0.00);
		double mass=0.00;
		for (int i=0; i<group.size();i++){
			mass+=group.get(i).getMass();
		}
		super.setMass(mass);
		this.group=group;
	}

	/* (non-Javadoc)
	 * @see Connector#link(PhysObject, PhysObject, double[], double[])
	 */
	@Override
	public boolean link(PhysObject p1, PhysObject p2, double[] c1, double[] c2) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Connector#unlink(PhysObject, PhysObject)
	 */
	@Override
	public boolean unlink(PhysObject p1, PhysObject p2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * This unlinks one PhysObject from the group
	 * 
	 * @param p - The PhysObject to be unlinked
	 * @return - Whether or not the object was unlinked successfully
	 */
	public boolean unlink(PhysObject p){
		return this.group.remove(p);
	}

}
