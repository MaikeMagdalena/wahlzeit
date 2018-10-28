//Maike adap-hw02
package org.wahlzeit.model;

public class Coordinate {
	private double x;
	private double y;
	private double z;
	
	/**
	 * This is the constructor. Coordinate consists of x, y and z.
	 * @param x
	 * @param y
	 * @param z
	 */
	public Coordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * This method gives the distance between a given coordinate and the current object.
	 * @param coord is a given coordinate to calculate the distance to.
	 * @return
	 */
	public double getDistance(Coordinate coord){
		double d;
		
		double dx = coord.x - this.x;
		double dy = coord.y - this.y;
		double dz = coord.z - this.z;
		
		d = Math.sqrt(dx * dx + dy *dy + dz * dz);		
		return d;
	}
	
	/**
	 * This methods checks if a given coordinate is equal with the current object's coordinate.
	 * @param coord is a given coordinate to check if it is equal with current object's coordinate.
	 * @return
	 */
	public boolean isEqual(Coordinate coord){
		if (coord.x == this.x && coord.y == this.y && coord.z == this.z){
			return true;
		} else {
			return false;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
}
