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

import static org.junit.Assert.*;

import org.junit.Test;

public class CartesianCoordinateTest {
	
	// cartCoord1 = spherCoord1, cartCoord2 = spherCoord2;
	private CartesianCoordinate cartCoord1 = new CartesianCoordinate(1,1,1);
	private CartesianCoordinate cartCoord2 = new CartesianCoordinate(1,2,3);
	private SphericCoordinate spherCoord1 = new SphericCoordinate(1.7320508075688772, 0.9553166181245092, 0.7853981633974483);
	private SphericCoordinate spherCoord2 = new SphericCoordinate(3.7416573867739413, 0.6405223126794245, 1.1071487177940904);
		
	private CartesianCoordinate invalidCoord = new CartesianCoordinate(0.0, 0.0, Double.NaN);
	
	/**
	 * This Test checks if the constructor of the method works
	 */
	@Test
	public void testInitiation(){
		CartesianCoordinate c = new CartesianCoordinate(1.0, 2.0, 3.0);
		assertTrue(c.getX() == 1.0 && c.getY() == 2.0 && c.getZ() == 3.0);
	}
	
	/**
	 * This Test checks if the assertValidSphericCoordinate works
	 */
	@Test(expected = NullPointerException.class)
	public void testAssertNotNull(){
		CartesianCoordinate.assertNotNull(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAssertValidCartesianCoordinate(){
		invalidCoord.assertValidCartesianCoord();
	}
	
	/**
	 * getDistance()
	 * This Test checks if one (known) distance is equal to a distance calculated by the .getDistance method
	 */
	@Test
	public void testGetDistance(){
		CartesianCoordinate c1 = new CartesianCoordinate(1.0, 2.0, 3.0);
		CartesianCoordinate c2 = new CartesianCoordinate (1.0, 2.0, 4.0);
				
		double d1 = 1; //known distance
		
		double d2; //distance calculated in the function
		d2 = c1.getDistance(c2);
		
		assertTrue(d1 == d2);
	}
	
	/**
	 * getDistance()
	 * This test checks if the nullPointerException works for a given null argument
	 */
	@Test(expected = NullPointerException.class)
	public void testGetDistanceNullPointerException(){
		cartCoord1.getDistance(null);
	}
	
	/**
	 * getDistance()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceException(){
		cartCoord1.getDistance(invalidCoord);
	}
	
	/**
	 * asCartesianCoordinate()
	 * This test checks if a cartesian coordinate is equal with itself as cartesian coordinate
	 */
	@Test
	public void testAsCartesianCoordinate(){
		assertTrue(cartCoord1.asCartesianCoordinate().isEqual(cartCoord1));
	}
	
	/**
	 * asCartesianCoordinate()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsCartesianCoordinateException(){
		invalidCoord.asCartesianCoordinate();
	}
	
	/**
	 * asSphericCoordinate()
	 * This test checks if a sphericCoordinate is equal with itself as sphericCoordinate
	 */
	@Test
	public void testAsSphericCoordinate(){
		assertTrue(cartCoord1.asSphericCoordinate().isEqual(spherCoord1));
	}
	
	/**
	 * asSphericCoordinate()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsSphericCoordinateCartesianException(){
		invalidCoord.asSphericCoordinate();
	}
	
	/**
	 * getCentralAngle()
	 * This test checks if the getCentralAngle works with an expected Angle
	 */
	@Test
	public void testGetCentralAngle(){
		double expectedAngle = 0.3875966866551805;
		
		//two cartesian coordinates
		assertEquals(cartCoord1.getCentralAngle(cartCoord2), expectedAngle, 0.00001);
		
		//compare spheric and cartesian coordinates
		assertEquals(cartCoord1.getCentralAngle(spherCoord2), expectedAngle, 0.00001);
		
		//compare one coord with itself
		assertEquals(cartCoord1.getCentralAngle(cartCoord1), 0, 0.00001);
	}
	
	

	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if a calculated cartesian distance equals the known distance
	 */
	@Test
	public void testGetCartesianDistance(){
		double knownDist = 2.23606797749979;
		double noDist = 0;
		double DELTA = 0.00001;
		
		//compare cartesian and cartesian
		assertTrue(cartCoord1.getCartesianDistance(cartCoord2) + DELTA > knownDist
				&& cartCoord1.getCartesianDistance(cartCoord2) - DELTA < knownDist);
		
		//compare cartesian coordinate and spheric coordinate
		assertTrue(cartCoord1.getCartesianDistance(spherCoord2) + DELTA > knownDist
				&& cartCoord1.getCartesianDistance(spherCoord2) - DELTA < knownDist);
		
		//compare identical distances
		assertTrue(cartCoord1.getCartesianDistance(cartCoord1) + DELTA > noDist
		&& cartCoord1.getCartesianDistance(cartCoord1) - DELTA < noDist);
	}
	
	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the nullPointerException works for a given null argument
	 */
	@Test(expected = NullPointerException.class)
	public void testGetCartesianDistanceNullPointerException(){
		cartCoord1.getCartesianDistance(null);		
	}

	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCartesianDistanceArgumentException(){
		cartCoord1.getCartesianDistance(invalidCoord);
	}
		
	/**
	 * AbstractCoordinate: isEqual()
	 * Tests if IsEqual works with two identical coordinates.
	 */
	@Test
	public void testIsEqual(){
		CartesianCoordinate c1 = new CartesianCoordinate(1.00, 1.11, 1.22);
		CartesianCoordinate c2 = new CartesianCoordinate(1.00, 1.11, 1.22);
		assertTrue(c1.isEqual(c2));
	}
	
	/**
	 * Tests if IsEqual works with two differing coordinates.
	 */
	@Test
	public void testIsNotEqual(){
		CartesianCoordinate c1 = new CartesianCoordinate(1.00, 1.11, 1.22);
		CartesianCoordinate c2 = new CartesianCoordinate(1.00, 1.00, 1.00);
		assertFalse(c1.isEqual(c2));
	}
	
	/**
	 * AbstractCoordinate: isEqual()
	 * This test checks if the nullPointerException works for a given null argument
	 */
	@Test(expected = NullPointerException.class)
	public void testisEqualNullPointerException(){
		cartCoord1.isEqual(null);		
	}

	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsEqualArgumentException(){
		cartCoord1.isEqual(invalidCoord);
	}
}
