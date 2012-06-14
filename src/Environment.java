/** Environment.java
 * This represents a basic physics environment with various boundaries, rules, and physical constants
 */

import java.util.ArrayList;
import java.awt.Graphics;

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public class Environment implements Runnable{
	//The initial variables to determine object behavior:
	private double width;
	private double height;
	private double gravity;
	//The objects populating the current environment:
	private ArrayList<PhysObject> objects = new ArrayList<PhysObject>();
	
	/**
	 * This is the constructor for an environment which holds various objects
	 * 
	 * @param width - The width of the environment
	 * @param height - The height of the environment
	 * @param gravity - The gravitational constant of the environment
	 */
	public Environment(double width, double height, double gravity){
		this.gravity=gravity;
		this.width=width;
		this.height=height;
		//CONSTRUCT ENVIRONMENT:
		
	}
	
	/**
	 * This adds a PhysObject to the environment
	 * 
	 * @param p - The PhysObject
	 * @return - Whether or not the operation was successful
	 */
	public boolean add(PhysObject p){
		return this.objects.add(p);
	}
	
	/**
	 * This removes a PhysObject from the environment
	 * 
	 * @param p - The PhysObject
	 * @return - Whether or not the operation was successful
	 */
	public boolean remove(PhysObject p){
		return this.objects.remove(p);
	}
	
	/**
	 * This ticks one unit of specified time of action for all of the objects within the environment
	 * 
	 * @param time - The specified amount of time in seconds
	 */
	public void tick(double time){
		
	}
	
	/**
	 * This runs a full simulation (Thread-based) of the objects contained within the environment
	 */
	public void simulate(){
		
	}

	/**
	 * This is an asynchronous method to run all of the contained physics objects on separate threads
	 */
	public void run() {
		//Run each physics object in the ArrayList objects on a separate thread:
		for (int i=0; i<objects.size();i++){
			//Create a thread based on the PhysObject and run it:
			
		}
	}
	
	/**
	 * This is the string representation of an environment object
	 * 
	 * @return - The string representation of the environment
	 */
	public String toString(){
		String str="================ Environment =================\n";
		for (int i=0; i<objects.size();i++){
			str+=objects.get(i).toString();
			if (i+1<objects.size()){
				str+="\n";
			}
		}
		str+="==============================================\n";
		return str;
	}
}
