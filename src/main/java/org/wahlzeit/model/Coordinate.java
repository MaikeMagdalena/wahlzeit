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
	 * @return distance
	 */
	public double getDistance(Coordinate coord){
		double distance;
		
		double dx = coord.x - this.x;
		double dy = coord.y - this.y;
		double dz = coord.z - this.z;
		
		distance = Math.sqrt(dx * dx + dy * dy + dz * dz);		
		return distance;
	}
	
	/**
	 * This methods checks if a given coordinate is equal with the current object's coordinate.
	 * @param coord is a given coordinate to check if it is equal with current object's coordinate.
	 * @return
	 */
	public boolean  isEqual(Coordinate coord){
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
