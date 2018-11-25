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
	
	/**
	 * This method is an assertClassInvatiants-method for all Coordinates
	 * They should not be null
	 */
	protected static void assertNotNull(Coordinate coord) throws NullPointerException {
		if (coord == null){
			throw new NullPointerException("input coordinate can not be null");
		}
	}
	
	/**
	 * This method checks if doubles are value.
	 * They should be a number and not infinite
	 */
	protected void assertValidDouble(double d) throws IllegalArgumentException {
		if(Double.isNaN(d)){
			throw new IllegalArgumentException("double in NaN");
		}
		if(Double.isInfinite(d)){
			throw new IllegalArgumentException("double is infinite");
		}
	}
	
	/**
	 * two doubles are compared and if they are (nearly) equal this method becomes true.
	 * @param oneDouble
	 * @param secondDouble
	 * @return
	 */
	public boolean doublesAreEqual(double oneDouble, double secondDouble) throws IllegalArgumentException {
		assertValidDouble(oneDouble);
		assertValidDouble(secondDouble);
		
		if(oneDouble + DELTA >= secondDouble && 
				oneDouble - DELTA <= secondDouble){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public abstract SphericCoordinate asSphericCoordinate();
	
	/**
	 * This method gives back a cartesian distance. This is implemented already as getDistance(CartesianCoordinate)
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) throws NullPointerException, IllegalStateException, IllegalArgumentException {
		
		//Precondition: Input coordinate should not be null
		assertNotNull(coord);
		
		CartesianCoordinate cartCoord = coord.asCartesianCoordinate();
		CartesianCoordinate thisCoord = this.asCartesianCoordinate();
		
		//Precondition: Cartesian coordinate should have valid arguments
		cartCoord.assertValidCartesianCoord();
		thisCoord.assertValidCartesianCoord();
		
		return thisCoord.getDistance(cartCoord);
	}
	
	/**
	 * Checks if a given coordinate is equal to this coordinate.
	 */
	@Override
	public boolean isEqual(Coordinate coordinate) throws NullPointerException, IllegalStateException, IllegalArgumentException {
		
		//Precondition: Input coordinate should not be null
		assertNotNull(coordinate);
				
		CartesianCoordinate thisCoord = this.asCartesianCoordinate();
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		
		//Precondition: Cartesian coordinate should have valid arguments
		thisCoord.assertValidCartesianCoord();
		coord.assertValidCartesianCoord();
		
		if (doublesAreEqual(coord.getX(), thisCoord.getX()) &&
				doublesAreEqual(coord.getY(), thisCoord.getY()) &&
				doublesAreEqual(coord.getZ(), thisCoord.getZ())) 
		{
			return true;
		} 
		else 
		{ 
			return false;
		}
	}
	
	/**
	 * This method gives back the CentralAngle
	 */
	@Override
	public double getCentralAngle(Coordinate coordinate) throws NullPointerException, IllegalStateException, IllegalArgumentException {
		
		//Precondition: Input coordinate should not be null
		assertNotNull(coordinate);
		
		SphericCoordinate thisCoord = this.asSphericCoordinate();
		SphericCoordinate coord = coordinate.asSphericCoordinate();
		
		//Precondition: Spheric coordinates should have valid arguments
		thisCoord.assertValidSphericCoord();
		coord.assertValidSphericCoord();
		
		double psi1 = 90 - thisCoord.getPhi();
		double lambda1 = thisCoord.getTheta();
		double psi2 = 90 - coord.asSphericCoordinate().getPhi();
		double lambda2 = coord.asSphericCoordinate().getTheta();
		
		double deltaLambda = Math.abs(lambda1 - lambda2);
		double sinPsi12 = Math.sin(psi1) * Math.sin(psi2);
		double cosPsi12DeltaLambda = Math.cos(psi1) * Math.cos(psi2) * Math.cos(deltaLambda);
		double centralAngle = Math.acos(sinPsi12 + cosPsi12DeltaLambda);
		
		return centralAngle;
	}
	

}
