/** Yarn.java
 * This represents a yarn object (because string is already taken) that can connect two objects together with various properties
 * A yarn has a set length and elasticity which determines the deviation from the equilibrium length
 * A yarn also has an infinite set of freenode members which can interact with any object (and conform to the object's perimeter)
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Yarn extends PhysObject implements Connector {
	private NodePair p1;
	private NodePair p2;
	private double length;
	private double elasticity;
	
	/**
	 * This constructs a yarn connector with two given connector nodes, length, and elasticity
	 * 
	 * @param length - A set equilibrium length
	 * @param elasticity - A value for the yarn's elasticity (0=Rigid, 1=Completely Elastic)
	 */
	public Yarn(double length, double elasticity) {
		//The yarn defaults its mass to 0
		super(Shape.Freenode, 0.0);
		this.length=length;
		setElastic(elasticity);
	}

	/* (non-Javadoc)
	 * @see Connector#link(PhysObject, PhysObject, double[], double[])
	 */
	@Override
	public boolean link(PhysObject p1, PhysObject p2, double[] c1, double[] c2) {
		//This can only link two objects if there are not already two objects linked
		if (p1.equals(null) && p2.equals(null)){
			NodePair pair1 = new NodePair(p1,c1);
			NodePair pair2 = new NodePair(p2,c2);
			this.p1=pair1;
			this.p2=pair2;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see Connector#unlink(PhysObject, PhysObject)
	 */
	@Override
	public boolean unlink(PhysObject p1, PhysObject p2) {
		//This can only unlink if both objects are the ones specified
		if (this.p1.getObj().equals(p1) && this.p2.getObj().equals(p2)){
			this.p1=null;
			this.p2=null;
			return true;
		}
		return false;
	}
	
	/**
	 * This unlinks the current two objects and returns whether or not it was successful
	 * 
	 * @return - Whether or not the operation was successful
	 */
	public boolean unlink(){
		if (!this.p1.equals(null) && !this.p2.equals(null)){
			this.p1=null;
			this.p2=null;
			return true;
		}
		return false;
	}
	
	/**
	 * This sets the equilibrium length of the yarn
	 * 
	 * @param length - The length of the yarn
	 */
	public void setLength(double length){
		this.length=length;
	}
	
	/**
	 * This gets the current equilibrium length of the yarn
	 * 
	 * @return - The length of the yarn
	 */
	public double getLength(){
		return this.length;
	}
	
	/**
	 * This sets the elasticity of the yarn based on an arbitrary scale (0=Rigid, 1=Completely Elastic)
	 * 
	 * @param elasticity - The elasticity of the yarn
	 */
	public void setElastic(double elasticity){
		if (elasticity>1){
			this.elasticity=1;
		}
		else if (elasticity<0){
			this.elasticity=0;
		}
		else {
			this.elasticity=elasticity;
		}
	}
	
	/**
	 * This gets the elasticity value of the yarn (0=Rigid, 1=Completely Elastic)
	 * 
	 * @return - The elasticity of the yarn
	 */
	public double getElastic(){
		return this.elasticity;
	}
}
