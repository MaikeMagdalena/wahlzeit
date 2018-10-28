//Maike adap-hw02
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
	
}
