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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {
	
	/**
	 * This Test checks if the constructor of the method works
	 */
	@Test
	public void testInitiation(){
		Coordinate c = new Coordinate(1.0, 2.0, 3.0);
		assertTrue(c.getX() == 1.0 && c.getY() == 2.0 && c.getZ() == 3.0);
	}
	
	/**
	 * This Test checks if one (known) distance is equal to a distance calculated by the .getDistance method
	 */
	@Test
	public void testGetDistance(){
		Coordinate c1 = new Coordinate(1.0, 2.0, 3.0);
		Coordinate c2 = new Coordinate (1.0, 2.0, 4.0);
		
//		double dx = c1.getX() - c2.getX();
//		double dy = c1.getY() - c2.getY();
//		double dz = c1.getZ() - c2.getZ();
//		
//		double d1; //distance calculated in this test
//		d1 = Math.sqrt(dx * dx + dy *dy + dz * dz);
		
		double d1 = 1; //known distance
		
		double d2; //distance calculated in the function
		d2 = c1.getDistance(c2);
		
		assertTrue(d1 == d2);
	}
	
	/**
	 * Tests if IsEqual works with two identical coordinates.
	 */
	@Test
	public void testIsEqual(){
		Coordinate c1 = new Coordinate(1.00, 1.11, 1.22);
		Coordinate c2 = new Coordinate(1.00, 1.11, 1.22);
		assertTrue(c1.isEqual(c2));
	}
	
	/**
	 * Tests if IsEqual works with two differing coordinates.
	 */
	@Test
	public void testIsNotEqual(){
		Coordinate c1 = new Coordinate(1.00, 1.11, 1.22);
		Coordinate c2 = new Coordinate(1.00, 1.00, 1.00);
		assertFalse(c1.isEqual(c2));
	}
}
