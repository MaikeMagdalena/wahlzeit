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

public class RobotPhoto extends Photo {

	public static final String PRODUCER = "producer";
	public static final String ROBOTCLASS = "robotClass";
	public static final String MOTIONRANGE = "motionRange"; //mobile or stationary
	public static final String COLLABORATIONLEVEL = "collaborationLevel"; //collaborative robot or not
	public static final String APPLICATION = "application";
	
	protected String producer;
	protected String robotClass;
	protected String motionRange;
	protected String collaborationLevel;
	protected String application;
	
	public RobotPhoto(PhotoId id) {
		super(id);
	}

	public RobotPhoto() {
		super();
	}

	
	/**
	 * @methodtype set
	 */
	public void setProducer(String newProducer){
		producer = newProducer;
		incWriteCount();
	}
	
	/**
	 * @methodtype get
	 */
	public String getProducer(){
		return producer;
	}
	
	/**
	 * @methodtype set
	 */
	public void setRobotClass(String newRobotClass){
		robotClass = newRobotClass;
		incWriteCount();
	}
	
	/**
	 * @methodtype get
	 */
	public String getRobotClass(){
		return robotClass;
	}
	
	/**
	 * @methodtype set
	 */
	public void setMotionRace(String newMotionRace){
		motionRange = newMotionRace;
		incWriteCount();
	}
	
	/**
	 * @methodtype get
	 */
	public String getMotionRace(){
		return motionRange;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCollaborationLevel(String newCollaborationLevel){
		collaborationLevel = newCollaborationLevel;
		incWriteCount();
	}
	
	/**
	 * @methodtype get
	 */
	public String getCollaborationLevel(){
		return collaborationLevel;
	}
	
	/**
	 * @methodtype set
	 */
	public void setApplication(String newApplication){
		application = newApplication;
		incWriteCount();
	}
	
	/**
	 * @methodtype get
	 */
	public String getApplication(){
		return application;
	}
	
}
