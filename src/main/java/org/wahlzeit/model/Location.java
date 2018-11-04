/*
 * adap-hw 02
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

public class Location {
	public Coordinate coordinate;
	
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
	public boolean equals(Object arg0) {
		
		if(this.coordinate == null){
			throw new IllegalStateException("There is no coordinate");
		}
		if(arg0 == null){
			throw new IllegalArgumentException("Argument can not be null");
		}
		if(!(arg0 instanceof Location)){
			throw new IllegalArgumentException("Argument should be a location");
		}
		
				
		Location location = (Location) arg0;
		
		return location.coordinate.isEqual(this.coordinate);
	}
}
