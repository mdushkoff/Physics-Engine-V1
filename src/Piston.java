/** Piston.java
 * This represents a piston object which can change its length variably from a defined min and max length
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Piston extends PhysObject implements Connector {
	//The minimum outstretched length of the piston:
	private double minLength;
	//The maximum outstretched length of the piston:
	private double maxLength;
	//The current length of the piston:
	private double curLength;
	//The dampening factor (0-1):
	private double damp;
	
	/**
	 * This constructs a piston connector object which can connect to objects and change its length variably
	 * 
	 * @param minLength - The minimum outstretched length of the piston
	 * @param maxLength - The maximum outstretched length of the piston
	 * @param damp - The dampening factor (0-1)
	 */
	public Piston(double minLength, double maxLength, double damp) {
		//A piston defaults to 0 mass:
		super(Shape.Freenode, 0.0);
		
		if (minLength>maxLength){
			this.minLength=maxLength;
			this.maxLength=minLength;
		}
		else{
			this.minLength=minLength;
			this.maxLength=maxLength;
		}
		//The current length defaults to 1/2 the difference between the min and max:
		this.curLength=(this.maxLength-this.minLength)/2;
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
	 * This sets the current value of the minimum length
	 * 
	 * @param min - The minimum length of the piston
	 * @return - Whether or not it set was successfully
	 */
	public boolean setMin(double min){
		if (min<=this.maxLength){
			this.minLength=min;
			return true;
		}
		return false;
	}
	
	/**
	 * This gets the value of the current minimum length
	 * 
	 * @return - The current minimum length
	 */
	public double getMin(){
		return this.minLength;
	}
	
	/**
	 * This sets the maximum length of the piston
	 * 
	 * @param max - The maximum length of the piston
	 * @return - Whether or not it was set successfully
	 */
	public boolean setMax(double max){
		if (max>=this.minLength){
			this.maxLength=max;
			return true;
		}
		return false;
	}
	
	/**
	 * This gets the value of the current maximum length
	 * 
	 * @return - The current maximum length
	 */
	public double getMax(){
		return this.maxLength;
	}
	
	/**
	 * This sets the current length of the piston
	 * 
	 * @param cur - The length of the piston
	 * @return - Whether or not the length was set successfully
	 */
	public boolean setCur(double cur){
		if (cur>=this.minLength && cur<=this.maxLength){
			this.curLength=cur;
			return true;
		}
		return false;
	}
	
	/**
	 * This gets the current length of the piston
	 * 
	 * @return - The current length of the piston
	 */
	public double getCur(){
		return this.curLength;
	}
}
