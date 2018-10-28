//Maike adap-hw02
package org.wahlzeit.model;

public class Location {
	public Coordinate coordinate = null;
	
	/**
	 * This is the constructor. Location consists of a Coordinate (consisting of x, y, z).
	 * @param coord
	 */
	public Location(Coordinate coord){
		this.coordinate = coord;
	}

	/**
	 * This Method checks if the Location-Object is equal to the current Location. It is Forwarded to Coordinate.isEqual
	 */
	@Override
	// Overrides an inherited Method (coming from java.lang.object)
	// Source -- Override/ImplementMethods
	public boolean equals(Object arg0) {
		Location locat = (Location) arg0;
		
		return locat.coordinate.isEqual(this.coordinate);
	}
}
