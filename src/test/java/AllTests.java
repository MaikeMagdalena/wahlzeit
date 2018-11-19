/*
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

import org.wahlzeit.handlers.*;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;
//import org.wahlzeit.testEnvironmentProvider.*;
import org.wahlzeit.utils.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	// org.wahlzeit.handlers.*;
	TellFriendTest.class,
	
	// org.wahlzeit.model.*;
	AccessRightsTest.class, 
		FlagReasonTest.class, GenderTest.class, GuestTest.class,
		LocationTest.class, PhotoFilterTest.class, TagsTest.class,
		UserStatusTest.class, ValueTest.class, RobotPhotoTest.class,
		UserStatusTest.class, ValueTest.class,
		
		CartesianCoordinateTest.class,
		SphericCoordinateTest.class,

	// org.wahlzeit.model.persistence.*;
	//AbstractAdapterTest.class,
	DatastoreAdapterTest.class,
	
	// org.wahlzeit.services.*;
	//EmailAddressTest.class,-- in MailTestSuite
	LogBuilderTest.class,
	
	// org.wahlzeit.services.mailing.*;
	MailTestSuite.class,
	//EmailServiceTest.class, -- in MailTestSuite
	
	// org.wahlzeit.testEnvironmentProvider.*;
	//LocalDatastoreServiceTestConfigProvider.class,
	//RegisteredOfyEnvironmentProvider.class,
	//SysConfigProvider.class, UserServiceProvider.class,
	//UserSessionProvider.class, WebFormHandlerProvider.class,
	
	// org.wahlzeit.utils.*;
	StringUtilTest.class, VersionTest.class
	
})
	
public class AllTests {

}
