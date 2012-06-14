/** PhysObject.java
 * This is an abstract physics object that has various attributes that determine its movement and other various behaviors
 */

/**
 * @author Michael Dushkoff (mad1841@rit.edu)
 */

public abstract class PhysObject {
	//These are all of the attributes that a generic PhysObject must take on:
	//The current shape:
	private Shape s;
	//Position:
	private double x=0.00;
	private double y=0.00;
	//Velocity:
	private double vx=0.00;
	private double vy=0.00;
	//Acceleration:
	private double ax=0.00;
	private double ay=0.00;
	//Mass:
	private double mass=0.00;
	//Friction:
	private double fric=0.00;
	//Normality:
	private double normal=1.00;
	//Rotation:
	private double rot=0.00;
	//Rotational Velocity:
	private double rotV=0.00;
	//Rotational Acceleration:
	private double rotA=0.00;
	//Center of Mass:
	private double[] COM = new double[2];
	//Interactivity:
	private boolean dynamic=true;
	
	/**
	 * This constructs a PhysObject which is of the shape provided
	 * 
	 * @param type - The type of shape
	 * @param mass - The mass of the object
	 */
	public PhysObject(Shape type, double mass){
		this.s=type;
		this.mass=mass;
	}
	
	/**
	 * This is a setter for the position
	 * 
	 * @param x - The x position
	 * @param y - The y position
	 */
	public void setPos(double x, double y){
		this.x=x;
		this.y=y;
		//Change COM to match new position:
		this.COM[0]+=x;
		this.COM[1]+=y;
	}
	
	/**
	 * This gets the current x position
	 * 
	 * @return - The current x position
	 */
	public double getX(){
		return this.x;
	}
	
	/**
	 * This gets the current y position
	 * 
	 * @return - The current y position
	 */
	public double getY(){
		return this.y;
	}
	
	/**
	 * This is a setter for the velocity
	 * 
	 * @param vx - The x velocity
	 * @param vy - The y velocity
	 */
	public void setVel(double vx, double vy){
		this.vx=vx;
		this.vy=vy;
	}
	
	/**
	 * This returns the value of the velocity in the x direction
	 * 
	 * @return - The velocity in the x direction
 	 */
	public double getVelX(){
		return this.vx;
	}
	
	/**
	 * This returns the value of the velocity in the y direction
	 * 
	 * @return - The velocity in the y direction
	 */
	public double getVelY(){
		return this.vy;
	}
	
	/**
	 * This is a setter for the acceleration
	 * 
	 * @param ax - The acceleration in the x direction
	 * @param ay - The acceleration in the y direction
	 */
	public void setAcc(double ax, double ay){
		this.ax=ax;
		this.ay=ay;
	}
	
	/**
	 * This returns the value of the acceleration in the x direction
	 * 
	 * @return - The acceleration in the x direction
	 */
	public double getAccX(){
		return this.ax;
	}
	
	/**
	 * This returns the value of the acceleration in the y direction
	 * 
	 * @return - The acceleration in the y direction
	 */
	public double getAccY(){
		return this.ay;
	}
	
	/**
	 * This is a setter for the mass (if it is increasing/decreasing)
	 * 
	 * @param mass - The mass to set
	 */
	public void setMass(double mass){
		this.mass=mass;
	}
	
	/**
	 * This gets the current mass of the PhysObject
	 * 
	 * @return - The current mass
	 */
	public double getMass(){
		return this.mass;
	}
	
	/**
	 * This sets the frictional constant of the PhysObject
	 * 
	 * @param fric - The amount of friction the object has
	 */
	public void setFric(double fric){
		this.fric=fric;
	}
	
	/**
	 * This gets the frictional constant of the PhysObject
	 * 
	 * @return - The frictional constant
	 */
	public double getFric(){
		return this.fric;
	}
	
	/**
	 * This sets the normality of the PhysObject (tendency for the object to be solid)
	 * This is an arbitrary scale from 0 (gas) to 1 (solid)
	 * 
	 * @param normal - The normality of the PhysObject
	 */
	public void setNormal(double normal){
		if (normal>1){
			this.normal=1;
		}
		else if (normal<0){
			this.normal=0;
		}
		else {
			this.normal=normal;
		}
	}
	
	/**
	 * This gets the current normality of the PhysObject
	 * 
	 * @return - The normality of the PhysObject
	 */
	public double getNormal(){
		return this.normal;
	}
	
	/**
	 * This sets the current rotation of the object
	 * 
	 * @param rot - The rotation to set (0-360)
	 */
	public void setRot(double rot){
		while (rot>360){
			rot-=360;
		}
		while (rot<0){
			rot+=360;
		}
		this.rot=rot;
	}
	
	/**
	 * This gets the current rotation
	 * 
	 * @return - The object's current rotation
	 */
	public double getRot(){
		return this.rot;
	}
	
	/**
	 * This sets the current rotational velocity of the object
	 * 
	 * @param rotV - The rotational velocity (deg/sec)
	 */
	public void setRotV(double rotV){
		this.rotV=rotV;
	}
	
	/**
	 * This gets the current rotational velocity
	 * 
	 * @return - The object's current rotational velocity (deg/sec)
	 */
	public double getRotV(){
		return this.rotV;
	}
	
	/**
	 * This sets the current rotational acceleration of the object
	 * 
	 * @param rotA - The rotational acceleration (deg/sec/sec)
	 */
	public void setRotA(double rotA){
		this.rotA=rotA;
	}
	
	/**
	 * This gets the current rotational acceleration of the object
	 * 
	 * @return - The object's current rotational acceleration (deg/sec/sec)
	 */
	public double getRotA(){
		return this.rotA;
	}
	
	/**
	 * This sets the object's center of mass
	 * 
	 * @param x - The x coordinate
	 * @param y - The y coordinate
	 */
	public void setCOM(double x, double y){
		this.COM[0]=x;
		this.COM[1]=y;
	}
	
	/**
	 * This gets the object's center of mass
	 * 
	 * @return - The object's center of mass (double[x,y])
	 */
	public double[] getCOM(){
		return this.COM;
	}
	
	/**
	 * This sets the physics attribute which can determine whether or not an object responds to physics interactions
	 * 
	 * @param b - Whether or not it responds to physics interactions (true=Dynamic | false=Static)
	 */
	public void setDyn(boolean b){
		this.dynamic=b;
	}
	
	/**
	 * This gets whether or not the object responds to physics interactions
	 * 
	 * @return - Whether or not it responds to physics interactions (true=Dynamic | false=Static)
	 */
	public boolean getDyn(){
		return this.dynamic;
	}
	
	/**
	 * This is the string representation of a generic PhysObject
	 * 
	 * @return - The string representation
	 */
	public String toString(){
		String dyn="Dynamic";
		if (!this.dynamic){
			dyn="Static";
		}
		String str="["+s.toString()+"]:"+dyn+"\n"+
				   "Coordinates: <"+String.valueOf(x)+", "+String.valueOf(y)+">\n"+
				   "Velocity: <"+String.valueOf(vx)+", "+String.valueOf(vy)+">\n"+
				   "Acceleration: <"+String.valueOf(ax)+", "+String.valueOf(ay)+">\n"+
				   "Mass: "+String.valueOf(mass)+"\n"+
				   "Friction: "+String.valueOf(fric)+"\n"+
				   "Normality: "+String.valueOf(normal)+"\n"+
				   "Rotation: "+String.valueOf(rot)+"deg\n"+
				   "Rotational Velocity: "+String.valueOf(rotV)+"deg/sec\n"+
				   "Rotational Acceleration: "+String.valueOf(rotA)+"deg/sec/sec\n"+
				   "Center of Mass: <"+String.valueOf(COM[0])+", "+String.valueOf(COM[1])+">\n";
		return str;
	}
}
