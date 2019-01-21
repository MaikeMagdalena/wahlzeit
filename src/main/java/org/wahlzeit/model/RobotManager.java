/*
 * adap-hw12
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

import java.util.HashMap;

public class RobotManager {

	//Collection of all Robot-IDs and Robots
	private HashMap<Integer, Robot> robots = new HashMap<Integer, Robot>();
	
	//Collection of all RobotType-Names and RobotTypes
	private HashMap<String, RobotType> robotTypes = new HashMap<String, RobotType>();
	
	//Current robot ID = last robot Id + 1
	private int currentRobotID = 0;
	
	/**
	 * creates a Robot with a typeName, a robotType, an ID and the resulting Robot
	 * @param typeName
	 * @return resultingRobot
	 */
	public Robot createRobot(String typeName) throws NullPointerException {
	//	assertIsValidRobotTypeName(typeName);
		RobotType robottype = getRobotType(typeName);
		Robot resultingRobot = robottype.createInstance();
		robots.put(getNextRobotId(), resultingRobot);
		return resultingRobot;
	}

	protected int getNextRobotId() {
		currentRobotID +=1;
		return currentRobotID;
	}

	protected RobotType getRobotType(String typeName) throws NullPointerException {
		RobotType robotType;
		if(robotTypes.containsKey(typeName)){
			robotType = robotTypes.get(typeName);
		} else {
			robotType = new RobotType();
			robotTypes.put(typeName, robotType);
		}
		return robotType;
	}
	
	protected int getRobotId(){
		return currentRobotID;
	}

	protected boolean robotIDHashMapContains(int robotID){
		if(robots.containsKey(robotID)){
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean robotHashMapContains(Robot robot){
		if(robots.containsValue(robot)){
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean robotTypeNameHashMapContains(String robotTypeName){
		if(robotTypes.containsKey(robotTypeName)){
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean robotTypeHashMapContains(RobotType robotType){
		if(robotTypes.containsValue(robotType)){
			return true;
		} else {
			return false;
		}
	}
	
	protected void assertIsValidRobotTypeName(String typeName) throws NullPointerException {
		if (typeName == null){
			throw new NullPointerException("RobotTypeName must not be null");
		}
	}
	
	protected void assertIsValidRobotType(RobotType robotType) throws NullPointerException {
		if (robotType == null){
			throw new NullPointerException("RobotType must not be null");
		}
	}
	
}
