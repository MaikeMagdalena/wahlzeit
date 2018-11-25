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

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class RobotPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(RobotPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static RobotPhotoFactory instance = null;

	/**
	 * Public singleton access method.
	 */
	//@Override
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic RobotPhotoFactory").toString());
			setInstance(new RobotPhotoFactory());
		}

		return instance;
	}
	

	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new RobotPhoto();
	}
	
	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) throws IllegalArgumentException {
		if(id == null){
			throw new IllegalArgumentException("Photo ID can not be null");
		}
		return new RobotPhoto(id);
	}

	
}
