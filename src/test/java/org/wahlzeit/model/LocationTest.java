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

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	/**
	 * This Test checks if the constructor of the method works
	 */
	@Test
	public void testInitiation(){
		Coordinate c = new Coordinate(1.0, 2.0, 3.0);
		Location l = new Location(c);
		assertTrue(l.coordinate == c);
	}
	
	/**
	 * Tests if IsEqual works with two identical locations.
	 */
	@Test
	public void testIsEqual(){
		Coordinate c1 = new Coordinate(1.00, 1.11, 1.22);
		Coordinate c2 = new Coordinate(1.00, 1.11, 1.22);
		Location l1 = new Location(c1);
		Location l2 = new Location(c2);
		assertTrue(l1.equals(l2));
	}
	
	/**
	 * Tests if IsEqual works with two differing locations.
	 */
	@Test
	public void testIsNotEqual(){
		Coordinate c1 = new Coordinate(1.00, 1.11, 1.22);
		Coordinate c2 = new Coordinate(1.00, 1.00, 1.00);
		Location l1 = new Location(c1);
		Location l2 = new Location(c2);
		assertFalse(l1.equals(l2));
	}
	
	/**
	 * This test checks if the argument exception works for null argument
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEqualsExceptionNullArg(){
		Coordinate coord = new Coordinate(0.0, 0.0, 0.0);
		Location loc = new Location(coord);
		loc.equals(null);
	}
	
	/**
	 * This test checks if the argument exception works for illegal object type
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEqualsExceptionLocation(){
		Coordinate coord = new Coordinate(0.0, 0.0, 0.0);
		Location loc = new Location(coord);
		Object obj = new Object();
		loc.equals(obj);
	}
	
	/**
	 * This test checks if the state exception works
	 */
	@Test(expected = IllegalStateException.class)
	public void testEqualsStateException(){
		Coordinate coord = new Coordinate(0.0, 0.0, 0.0);
		Location loc = new Location(coord);
		loc.coordinate = null;
		
		loc.equals(coord);
	}
}
