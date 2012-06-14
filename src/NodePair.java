/** NodePair.java
 * This represents an object and a specified node coordinate to which another object will be connected to
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class NodePair {
	//These are unchangable but can be read
	private final PhysObject p;
	private final double[] d;
	
	/**
	 * This constructs a node pair given a PhysObject and the node coordinates
	 * 
	 * @param p - The PhysObject
	 * @param d - The coordinates of the node for connection
	 */
	public NodePair(PhysObject p, double[] d){
		this.p=p;
		this.d=d;
	}
	
	/**
	 * This gets the current PhysObject
	 * 
	 * @return - The current PhysObject
	 */
	public PhysObject getObj(){
		return p;
	}
	
	/**
	 * This gets the current node
	 * 
	 * @return - The current node coordinates
	 */
	public double[] getNode(){
		return d;
	}
	
	/**
	 * This is the string representation of the NodePair
	 * 
	 * @return - The string representation
	 */
	public String toString(){
		//Use this to format the double array:
		String dformat=d.toString();
		
		return p.toString() + dformat;
	}
}
