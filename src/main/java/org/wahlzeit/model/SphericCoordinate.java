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
