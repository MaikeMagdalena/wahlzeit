/*
 * adap-hw 06
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

public abstract class AbstractCoordinate implements Coordinate {

	double DELTA = 0.0000000000000002;
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public abstract double getCentralAngle(Coordinate coord);
	
	/**
	 * This method gives back a cartesian distance. This is implemented already as getDistance(CartesianCoordinate)
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) {
		CartesianCoordinate cartCoord = coord.asCartesianCoordinate();
		CartesianCoordinate thisCoord = this.asCartesianCoordinate();
		return thisCoord.getDistance(cartCoord);
	}
	
	/**
	 * Checks if a given coordinate is equal to this coordinate.
	 */
	@Override
	public boolean isEqual(Coordinate coordinate) {
		
		if(coordinate == null){
			throw new IllegalArgumentException("coord can not be null");
		}
		
		CartesianCoordinate thisCoord = this.asCartesianCoordinate();
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		
		double DELTA = 0.00001;
		
		
		if (coord.getX() + DELTA > thisCoord.getX() && coord.getX() - DELTA < thisCoord.getX()
				&& coord.getY() + DELTA > thisCoord.getY() && coord.getY() - DELTA < thisCoord.getY()
				&& coord.getZ() + DELTA > thisCoord.getZ() && coord.getZ() - DELTA < thisCoord.getZ()) {
			return true;
		}
				
		if (coord.getX() == thisCoord.getX() && coord.getY() == thisCoord.getY() && coord.getZ() == thisCoord.getZ()){
			return true;
		} else {
			return false;
		}
	}

}
