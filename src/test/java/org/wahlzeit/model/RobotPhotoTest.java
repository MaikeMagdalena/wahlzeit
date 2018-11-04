/*
 * adap-hw04
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

public class RobotPhotoTest {

	@Test
	public void testProducer(){
		RobotPhoto robotPhoto = new RobotPhoto();
		robotPhoto.setProducer("kuka");
		assertEquals(robotPhoto.getProducer(), "kuka");
		assertNotEquals(robotPhoto.getProducer(),"");
	}
	
	@Test
	public void testRobotClass(){
		RobotPhoto robotPhoto = new RobotPhoto();
		robotPhoto.setRobotClass("Industrial Robot");
		assertEquals(robotPhoto.getRobotClass(), "Industrial Robot");
		assertNotEquals(robotPhoto.getRobotClass(),"");
	}
	
	@Test
	public void testMotionRace(){
		RobotPhoto robotPhoto = new RobotPhoto();
		robotPhoto.setMotionRace("mobile");
		assertEquals(robotPhoto.getMotionRace(), "mobile");
		assertNotEquals(robotPhoto.getMotionRace(),"");
	}
	
	@Test
	public void testCollaborationLevel(){
		RobotPhoto robotPhoto = new RobotPhoto();
		robotPhoto.setCollaborationLevel("collaborative");
		assertEquals(robotPhoto.getCollaborationLevel(), "collaborative");
		assertNotEquals(robotPhoto.getCollaborationLevel(),"");
	}
	
	@Test
	public void testApplicaton(){
		RobotPhoto robotPhoto = new RobotPhoto();
		robotPhoto.setApplication("Moving around in a factory");
		assertEquals(robotPhoto.getApplication(), "Moving around in a factory");
		assertNotEquals(robotPhoto.getApplication(),"");
	}
		
}
