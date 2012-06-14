/** Circle.java
 * This is a circle physics object that takes on a circular shape
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Circle extends PhysObject {
	private double radius;
	
	/**
	 * This constructs a circle object
	 * 
	 * @param radius - The radius of the circle
	 * @param mass - The mass of the circle
	 */
	public Circle(double radius, double mass) {
		super(Shape.Circle, mass);
		this.radius = radius;
		
		//Set the default COM to be the exact center of the object:
		double xc = super.getX() + radius/2;
		double yc = super.getY() + radius/2;
		super.setCOM(xc, yc);
	}
	
	/**
	 * This is the string representation of a circle
	 * 
	 * @return - The string representation
	 */
	public String toString(){
		return super.toString() + "Radius: "+String.valueOf(radius)+"\n";
	}
}