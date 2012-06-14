/** Connector.java
 * This is used to connect objects together in various ways and can override basic physics rules to act as a larger object,
 * or alternatively it can take on all of the basic physics rules and implement other interactions as well
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public interface Connector {
	/**
	 * This links two objects together (based on a specific connector's rules) by their node points
	 * 
	 * @param p1 - The first PhysObject
	 * @param p2 - The second PhysObject
	 * @param c1 - The first connection point's coordinates
	 * @param c2 - The second connection point's coordinates
	 * @return - Whether or not the operation was successful
	 */
	public boolean link(PhysObject p1, PhysObject p2, double[] c1, double[] c2);
	
	/**
	 * This unlinks two objects
	 * 
	 * @param p1 - The first PhysObject
	 * @param p2 - The second PhysObject
	 * @return - Whether or not the operation was successful
	 */
	public boolean unlink(PhysObject p1, PhysObject p2);
}