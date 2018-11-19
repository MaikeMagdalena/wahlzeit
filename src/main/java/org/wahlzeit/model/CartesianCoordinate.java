/*
 * adap-hw 02
 * adap-hw 05 (Changed for Coordinate Interface)
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

public class CartesianCoordinate implements Coordinate{
	private double x;
	private double y;
	private double z;
	
	/**
	 * This is the constructor. Coordinate consists of x, y and z.
	 * @param x
	 * @param y
	 * @param z
	 */
	public CartesianCoordinate(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * This method gives the distance between a given coordinate and the current object.
	 * @param coord is a given coordinate to calculate the distance to.
	 * @return distance
	 */
	public double getDistance(CartesianCoordinate coord){
		if(coord == null){
			throw new IllegalArgumentException("coord can not be null");
		}
		
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
	public boolean isEqual(CartesianCoordinate coord){

		double DELTA = 0.00001;
		
		if(coord == null){
			throw new IllegalArgumentException("coord can not be null");
		}
		
		if (coord.x + DELTA < this.x && coord.x - DELTA > this.x
				&& coord.y + DELTA < this.y && coord.y - DELTA > this.y
				&& coord.z + DELTA < this.z && coord.z - DELTA > this.z) {
			return true;
		}
				
		if (coord.x == this.x && coord.y == this.y && coord.z == this.z){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method gives back a cartesian coordinate. It is already a cartesian coord, so it gives back itself.
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * This method gives back a cartesian distance. This is implemented already as getDistance(CartesianCoordinate)
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) {
		CartesianCoordinate cartCoord = coord.asCartesianCoordinate();
		return this.getDistance(cartCoord);
	}

	/**
	 * This method calculates spheric Coordinates out of the Cartesian ones.
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x*x + y*y + z*z);
		double phi = Math.atan2(y, x);
		double theta = Math.acos(z/radius);
		SphericCoordinate spherCoord = new SphericCoordinate(radius, theta, phi);
		return spherCoord;
	}

	/**
	 * This method gives the Central Angle.
	 */
	@Override
	public double getCentralAngle(Coordinate coord) {
		double x1 = this.x;
		double y1 = this.y;
		double z1 = this.z;
		double x2 = coord.asCartesianCoordinate().getX();
		double y2 = coord.asCartesianCoordinate().getY();
		double z2 = coord.asCartesianCoordinate().getZ();
		
		double DELTA = 0.0000000000000002;
		
		//calculate with Scalar-Product
		double centralAngle = 
			(x1 * x2 + y1 * y2 + z1 * z2)
			/(
				Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1)
				* Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2)
			);
		
		//correct minimal Math-Errors (cos can be only beteween 1 and -1):
		if(centralAngle > 1){
			centralAngle = centralAngle - DELTA;
		}
		if(centralAngle < -1){
			centralAngle = centralAngle + DELTA;
		}

		centralAngle = Math.acos(centralAngle);
		return centralAngle;
	}

	/**
	 * This method checks if a Coordinate is equal with this one. It is already implemented as "equals"
	 */
	@Override
	public boolean isEqual(Coordinate coord) {
		return this.equals(coord);
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
