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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.wahlzeit.model.persistence.ImageStorage;
import org.wahlzeit.services.LogBuilder;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

public class RobotPhotoManager extends PhotoManager {

	private static final Logger log = Logger.getLogger(RobotPhotoManager.class.getName());

	
	/**
	 * @methodtype command
	 *
	 * Load all persisted photos. Executed when Wahlzeit is restarted.
	 */
	@Override
	public void loadPhotos() {
		Collection<RobotPhoto> existingPhotos = ObjectifyService.run(new Work<Collection<RobotPhoto>>() {
			@Override
			public Collection<RobotPhoto> run() {
				Collection<RobotPhoto> existingPhotos = new ArrayList<RobotPhoto>();
				readObjects(existingPhotos, RobotPhoto.class);
				return existingPhotos;
			}
		});

		for (RobotPhoto photo : existingPhotos) {
			if (!doHasPhoto(photo.getId())) {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Load Robotphoto with ID", photo.getIdAsString()).toString());
				loadScaledImages(photo);
				doAddPhoto(photo);
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Already loaded Robotphoto", photo.getIdAsString()).toString());
			}
		}

		log.info(LogBuilder.createSystemMessage().addMessage("All photos loaded.").toString());
	}
}
