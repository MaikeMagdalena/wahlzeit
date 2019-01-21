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

public class RobotType {
	
	//if RobotType is Subtype of another RobotType, this other RobotType is "Parent"
	public RobotType parent;
	
	public RobotType(){
		//do nothing
	}
	
	/**
	 * constructor
	 * @param parent
	 */
	public RobotType(RobotType parent){
		this.parent = parent;
	}
	
	/**
	 * creates an Instance of a Robot with this robotType
	 * @return new Robot
	 */
	public Robot createInstance(){
		return new Robot(this);
	}

	/**
	 * checks if this RobotType is subtype of a given "parent"
	 * @param parent
	 * @return true / false
	 */
	public boolean isSubtype(RobotType parent){
		if(this.parent == parent){
			return true;
		} else {
			return false;
		}
	}
}
