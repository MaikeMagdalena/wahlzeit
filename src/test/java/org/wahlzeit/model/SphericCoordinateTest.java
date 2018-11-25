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

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {

	// cartCoord1 = spherCoord1, cartCoord2 = spherCoord2;
	private CartesianCoordinate cartCoord1 = new CartesianCoordinate(1,1,1);
	private CartesianCoordinate cartCoord2 = new CartesianCoordinate(1,2,3);
	private SphericCoordinate spherCoord1 = new SphericCoordinate(1.7320508075688772, 0.9553166181245092, 0.7853981633974483);
	private SphericCoordinate spherCoord2 = new SphericCoordinate(3.7416573867739413, 0.6405223126794245, 1.1071487177940904);
	private SphericCoordinate invalidCoord = new SphericCoordinate(-1, 2*Math.PI, 3*Math.PI);
	
	/**
	 * This Test checks if the constructor of the method works
	 */
	@Test
	public void testInitiation(){
		SphericCoordinate c = new SphericCoordinate(3.0, 45, 45);
		assertTrue(c.getPhi() == 45 && c.getTheta() == 45 && c.getRadius() == 3.0);
	}
	
	/**
	 * This Test checks if the assertValidSphericCoordinate works
	 */
	@Test(expected = NullPointerException.class)
	public void testAssertNotNull(){
		SphericCoordinate.assertNotNull(null);
	}
	
	/**
	 * assertValidSphericCoordinate()
	 * This Test checks if a wrong radius is detected
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAssertValidSphericCoordinateRadius(){
		SphericCoordinate invalid = new SphericCoordinate(-1, Math.PI, Math.PI);
		invalid.assertValidSphericCoord();
	}
	
	/**
	 * assertValidSphericCoordinate()
	 * This Test checks if a wrong Theta is detected
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAssertValidSphericCoordinateTheta(){
		SphericCoordinate invalid = new SphericCoordinate(1, 2*Math.PI, Math.PI);
		invalid.assertValidSphericCoord();
	}
	
	/**
	 * assertValidSphericCoordinate()
	 * This Test checks if a wrong Phi is detected
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAssertValidSphericCoordinatePhi(){
		SphericCoordinate invalid = new SphericCoordinate(1, Math.PI, 3*Math.PI);
		invalid.assertValidSphericCoord();
	}
	
	/**
	 * assertValidSphericCoordinate()
	 * This Test checks if a completely wrong coordinate is detected
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAssertValidSphericCoordinate(){
		invalidCoord.assertValidSphericCoord();
	}
	
	/**
	 * asCartesianCoordinate()
	 * This test checks if a cartesian coordinate is equal with itself as cartesian coordinate
	 */
	@Test
	public void testAsCartesianCoordinate(){
		assertTrue(spherCoord1.asCartesianCoordinate().isEqual(cartCoord1));
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
		assertTrue(spherCoord1.asSphericCoordinate().isEqual(spherCoord1));
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
		double expectedAngle = 0.3499248274410749;
		
		//two spheric coordinates
		assertEquals(spherCoord1.getCentralAngle(spherCoord2), expectedAngle, 0.00001);
		
		//compare spheric and cartesian coordinates
		assertEquals(spherCoord1.getCentralAngle(cartCoord2), expectedAngle, 0.00001);
		
		//compare one coord with itself
		assertEquals(spherCoord1.getCentralAngle(spherCoord1), 0, 0.00001);
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
		
		//compare spheric and spheric
		assertTrue(spherCoord1.getCartesianDistance(spherCoord2) + DELTA > knownDist
				&& spherCoord1.getCartesianDistance(spherCoord2) - DELTA < knownDist);
		//assertTrue(spherCoord1.getCartesianDistance(spherCoord2) == knownDist);
				
		
		//compare cartesian coordinate and spheric coordinate
		assertTrue(spherCoord1.getCartesianDistance(cartCoord2) + DELTA > knownDist
				&& spherCoord1.getCartesianDistance(cartCoord2) - DELTA < knownDist);
		
		
		//compare identical distances
		assertTrue(spherCoord1.getCartesianDistance(spherCoord1) + DELTA > noDist
		&& spherCoord1.getCartesianDistance(spherCoord1) - DELTA < noDist);
	}
	
	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the nullPointerException works for a given null argument
	 */
	@Test(expected = NullPointerException.class)
	public void testGetCartesianDistanceNullPointerException(){
		spherCoord1.getCartesianDistance(null);		
	}
	
	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCartesianDistanceArgumentException(){
		spherCoord1.getCartesianDistance(invalidCoord);
	}

	/**
	 * AbstractCoordinate: getCartesianDistance()
	 * This test checks if the IllegalArgumentException works
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIsEqualArgumentException(){
		spherCoord1.isEqual(invalidCoord);
	}
	
	/**
	 * AbstractCoordinate: isEqual()
	 * Tests if IsEqual works with two identical coordinates.
	 */
	@Test
	public void testIsEqual(){
		//compare spheric and spheric (not equal)
		assertTrue(!spherCoord1.isEqual(spherCoord2));
		
		//compare cartesian coordinate and spheric coordinate
		assertTrue(spherCoord1.isEqual(cartCoord1));
		assertTrue(cartCoord1.isEqual(spherCoord1));
		
		assertTrue(!spherCoord1.isEqual(cartCoord2));
		
		//compare identical
		assertTrue(spherCoord1.isEqual(spherCoord1));
	}
	
	/**
	 * AbstractCoordinate: isEqual()
	 * This test checks if the nullPointerException works for a given null argument
	 */
	@Test(expected = NullPointerException.class)
	public void testisEqualNullPointerException(){
		spherCoord1.isEqual(null);		
	}
	
	@Test
	public void testDoublesAreEqual(){
		assertTrue(spherCoord1.doublesAreEqual(1.111, 1.111));
		assertTrue(!spherCoord1.doublesAreEqual(1.112, 1.111));
	}
}
