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

public class SphericCoordinate implements Coordinate{

	private double phi;
	private double theta;
	private double radius;
	
	/**
	 * This is the constructor. Coordinate consists of phi, theta and radius.
	 * @param phi
	 * @param theta
	 * @param radius
	 */
	public SphericCoordinate(double radius, double theta, double phi){
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	/**
	 * This method calculates Cartesian Coordinates out of the already existing Spheric ones.
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius*Math.sin(theta)*Math.cos(phi);
		double y = radius*Math.sin(theta)*Math.sin(phi);
		double z = radius*Math.cos(theta);
		CartesianCoordinate cartCoord = new CartesianCoordinate(x,y,z);
		return cartCoord;
	}

	/**
	 * This method gives the CartesianDistance between a given coord and this coordinate. 
	 * For that both the given one and this one have to be transferred into CartesianCoordinates.
	 */
	@Override
	public double getCartesianDistance(Coordinate coord) {
		CartesianCoordinate cartCoord = coord.asCartesianCoordinate();
		CartesianCoordinate cartThis = this.asCartesianCoordinate();
		return cartThis.getDistance(cartCoord);
	}

	/**
	phi * This method gives back a Spheric coordinate. It is already a Spheric coord, so it gives back itself.
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/**
	 * This method gives back the CentralAngle
	 */
	@Override
	public double getCentralAngle(Coordinate coord) {
		double psi1 = 90 - this.phi;
		double lambda1 = this.theta;
		double psi2 = 90 - coord.asSphericCoordinate().getPhi();
		double lambda2 = coord.asSphericCoordinate().getTheta();
		
		double deltaLambda = Math.abs(lambda1 - lambda2);
		
		double centralAngle = Math.acos(
				Math.sin(psi1) * Math.sin(psi2)
				+ Math.cos(psi1) * Math.cos(psi2) * Math.cos(deltaLambda));
		
		return centralAngle;
	}

	/**
	 * Checks if a given coordinate is equal to this coordinate.
	 */
	@Override
	public boolean isEqual(Coordinate coord) {
		SphericCoordinate spherCoord = coord.asSphericCoordinate();
		
		double DELTA = 0.00001;
		
		if(spherCoord == null){
			throw new IllegalArgumentException("coord can not be null");
		}
		
		if (spherCoord.phi + DELTA < this.phi && spherCoord.phi - DELTA > this.phi
				&& spherCoord.theta + DELTA < this.theta && spherCoord.theta - DELTA > this.theta
				&& spherCoord.radius + DELTA < this.radius && spherCoord.radius - DELTA > this.radius) {
			return true;
		}
		
		if (spherCoord.phi == this.phi && spherCoord.theta == this.theta && spherCoord.radius == this.radius){
			return true;
			
		} else {
			return false;
		}
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
