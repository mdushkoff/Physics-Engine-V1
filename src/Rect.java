/** Rect.java
 * This is a rectangular physics object
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Rect extends PhysObject {
	//These are the initial attributes for a rectangular object:
	private double width;
	private double height;
	
	/**
	 * This constructs a rectangular object
	 * 
	 * @param width - The width of the rectangle
	 * @param height - The height of the rectangle
	 * @param mass - The mass of the rectangle
	 */
	public Rect(double width, double height, double mass) {
		super(Shape.Rect, mass);
		this.width = width;
		this.height = height;
		
		//Set the default COM to be the exact center of the object:
		double xc = super.getX() + width/2;
		double yc = super.getY() + height/2;
		super.setCOM(xc, yc);
	}
	
	/**
	 * This draws a rectangle with the current coordinates and dimensions
	 */
	public void draw(){
		
	}
	
	/**
	 * This is the string representation of a rectangle
	 * 
	 * @return - The string representation
	 */
	public String toString(){
		return super.toString() + "Dimensions (W,H): (" + String.valueOf(width)+", "+String.valueOf(height)+")\n";
	}
}
