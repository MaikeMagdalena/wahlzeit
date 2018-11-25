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

public class CartesianCoordinate extends AbstractCoordinate{
	private double x;
	private double y;
	private double z;
	
	/**
	 * This is the constructor. Coordinate consists of x, y and z.
	 * @param x
	 * @param y
	 * @param z
	 */
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		//Preconditions
		assertValidDouble(x);
		assertValidDouble(y);
		assertValidDouble(z);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * This method is an assertClassInvatiants-method ONLY for the Cartesian Coordinate
	 * They should have valid arguments
	 */
	protected void assertValidCartesianCoord() throws IllegalStateException {
		try {
			assertValidDouble(this.getX());
			assertValidDouble(this.getY());
			assertValidDouble(this.getZ());
		} catch (IllegalArgumentException argExc) {
			IllegalStateException stateExc = new IllegalStateException(argExc.getMessage());
			stateExc.setStackTrace(argExc.getStackTrace());
			throw stateExc;
		}
	}
	

	
	/**
	 * This method gives the distance between a given coordinate and the current object.
	 * @param coord is a given coordinate to calculate the distance to.
	 * @return distance
	 */
	public double getDistance(CartesianCoordinate coord)throws NullPointerException, IllegalStateException, IllegalArgumentException {
		
		//Precondition: Input coordinate should not be null
		assertNotNull(coord);
		
		//Precondition: Cartesian coordinates should have valid arguments
		coord.assertValidCartesianCoord();
		this.assertValidCartesianCoord();
		
		double distance;
		
		double dx = coord.x - this.x;
		double dy = coord.y - this.y;
		double dz = coord.z - this.z;
		
		distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
		
		//Postcondition: calculated distance should be a finite number
		assertValidDouble(distance);
		
		return distance;
	}
	
	/**
	 * This method gives back a cartesian coordinate. It is already a cartesian coord, so it gives back itself.
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		
		//Precondition: Cartesian coordinate should have valid arguments
		assertValidCartesianCoord();
		
		return this;
	}

	/**
	 * This method calculates spheric Coordinates out of the Cartesian ones.
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {

		//Precondition: Cartesian coordinate should have valid arguments
		assertValidCartesianCoord();		
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		double phi = Math.atan2(y, x);
		double theta = Math.acos(z/radius);
		SphericCoordinate spherCoord = new SphericCoordinate(radius, theta, phi);
		
		//Postcondition: Spheric coordinate should have valid arguments
		spherCoord.assertValidSphericCoord();
		
		return spherCoord;
	}

	/**
	 * This method gives the Central Angle.
	 */
	@Override
	public double getCentralAngle(Coordinate coord) throws NullPointerException, IllegalStateException, IllegalArgumentException {
		
		//Precondition: Input coordinate should not be null
		assertNotNull(coord);
		
		CartesianCoordinate cartCoord = coord.asCartesianCoordinate();
		
		//Precondition: Cartesian coordinates should have valid arguments
		cartCoord.assertValidCartesianCoord();
		this.assertValidCartesianCoord();
		
		double x1 = this.x;
		double y1 = this.y;
		double z1 = this.z;
		double x2 = cartCoord.getX();
		double y2 = cartCoord.getY();
		double z2 = cartCoord.getZ();
		
		//double DELTA = 0.0000000000000002;
		
		//calculate with Scalar-Product
		double centralAngle = 
			(x1 * x2 + y1 * y2 + z1 * z2)
			/(
				Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1)
				* Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2)
			);
		
		//correct minimal Math-Errors (cos can be only between 1 and -1):
		if(centralAngle > 1){
			centralAngle = centralAngle - DELTA;
		}
		if(centralAngle < -1){
			centralAngle = centralAngle + DELTA;
		}

		centralAngle = Math.acos(centralAngle);
		
		//Postcondition: Calculated Angel should be a finite number
		assertValidDouble(centralAngle);
		
		return centralAngle;
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
