/*
 * adap-hw 05
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

public class SphericCoordinate extends AbstractCoordinate{

	private double phi;
	private double theta;
	private double radius;
	
	/**
	 * This is the constructor. Coordinate consists of phi, theta and radius.
	 * @param phi
	 * @param theta
	 * @param radius
	 */
	public SphericCoordinate(double radius, double theta, double phi) throws IllegalArgumentException {
		//Preconditions
		assertValidRadius(radius);
		assertValidTheta(theta);
		assertValidPhi(phi);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	/**
	 * This method is an assertClassInvatiants-method ONLY for the Spheric Coordinate
	 * They should have valid arguments
	 */
	protected void assertValidSphericCoord() throws IllegalStateException {
		try {
			assertValidRadius(this.getRadius());
			assertValidTheta(this.getTheta());
			assertValidPhi(this.getPhi());
		} catch (IllegalArgumentException argExc) {
			IllegalStateException stateExc = new IllegalStateException(argExc.getMessage());
			stateExc.setStackTrace(argExc.getStackTrace());
			throw stateExc;
		}
	}
	
	/**
	 * This method checks if a Radius is valid
	 * it should not be negative or infinite or NaN
	 */
	protected void assertValidRadius(double radius) throws IllegalArgumentException {
		if(radius < 0){
			throw new IllegalArgumentException("radius can not be negative");
		}
		if(Double.isNaN(radius)){
			throw new IllegalArgumentException("radius can not be NaN");
		}
		if(Double.isInfinite(radius)){
			throw new IllegalArgumentException("radius can not be infinite");
		}
	}
	
	/**
	 * This method checks if a Theta is valid
	 * it should not be negative or bigger than PI or infinite or NaN
	 */	
	protected void assertValidTheta(double theta) throws IllegalArgumentException {
		if(theta < 0){
			throw new IllegalArgumentException("theta can not be negative");
		}
		if(theta >= Math.PI){
			throw new IllegalArgumentException("theata can not be bigger than PI");
		}
		if(Double.isNaN(theta)){
			throw new IllegalArgumentException("theta can not be NaN");
		}
		if(Double.isInfinite(theta)){
			throw new IllegalArgumentException("theta can not be infinite");
		}
	}
	
	/**
	 * This method checks if a Phi is valid
	 * it should not be negative or bigger than 2*PI or infinite or NaN
	 */	
	protected void assertValidPhi(double phi) throws IllegalArgumentException {
		if(phi < 0){
			throw new IllegalArgumentException("radius can not be negative");
		}
		if(phi >= Math.PI * 2){
			throw new IllegalArgumentException("phi can not be bigger than 2*PI");
		}
		if(Double.isNaN(phi)){
			throw new IllegalArgumentException("phi can not be NaN");
		}
		if(Double.isInfinite(phi)){
			throw new IllegalArgumentException("phi can not be infinite");
		}
	}
	
		
	/**
	 * This method calculates Cartesian Coordinates out of the already existing Spheric ones.
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		
		//Precondition: Spheric coordinate should have valid arguments
		assertValidSphericCoord();
		
		double x = radius*Math.sin(theta)*Math.cos(phi);
		double y = radius*Math.sin(theta)*Math.sin(phi);
		double z = radius*Math.cos(theta);
		CartesianCoordinate cartCoord = new CartesianCoordinate(x,y,z);
		
		//Postcondition: Cartesian coordinate should have valid arguments
		cartCoord.assertValidCartesianCoord();
		
		return cartCoord;
	}


	/**
	 * This method gives back a Spheric coordinate. It is already a Spheric coord, so it gives back itself.
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		
		//Precondition: Spheric coordinate should have valid arguments
		assertValidSphericCoord();
		
		return this;
	}

	
	public double getPhi(){
		return phi;
	}
	
	public double getTheta(){
		return theta;
	}
	
	public double getRadius(){
		return radius;
	}
}
