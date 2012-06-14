/** Tester.java
 * This is the tester module which constructs an environment and simulates various physics objects
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Tester {

	/**
	 * This is the main method that tests the physics environment
	 * 
	 * @param args - Various command arguments
	 */
	public static void main(String[] args) {
		//Set up the environment:
		Environment e = new Environment(500,500,9.81);
		
		//Construct a circle:
		PhysObject circle = new Circle(5,5);
		circle.setPos(20,20);
		
		//Construct a rectangle:
		PhysObject rect = new Rect(10,5,5);
		rect.setPos(50,0);
		
		//Construct two circles to be connected:
		PhysObject circle2 = new Circle(5,5);
		circle2.setPos(60, 60);
		PhysObject circle3 = new Circle(5,10);
		circle2.setPos(50, 60);
		
		//This connects the two circles by their center of masses:
		Connector c = new Yarn(5,1);
		c.link(circle2, circle3, circle2.getCOM(), circle3.getCOM());
		
		//Add all of the objects:
		e.add(circle);
		e.add(circle2);
		e.add(circle3);
		e.add(rect);
		//A connector can be safely cast to a PhysObject:
		//If a connector is not added to the environment, it will not be affected by physics
		e.add((PhysObject) c);
		
		//Print the string representation of the environment:
		System.out.println(e);
		
		//Simulate:
		e.simulate();
	}
}
