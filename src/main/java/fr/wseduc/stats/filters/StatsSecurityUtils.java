/*
 * Copyright © "Open Digital Education" (SAS “WebServices pour l’Education”), 2014
 *
 * This program is published by "Open Digital Education" (SAS “WebServices pour l’Education”).
 * You must indicate the name of the software and the company in any production /contribution
 * using the software and indicate on the home page of the software industry in question,
 * "powered by Open Digital Education" with a reference to the website: https: //opendigitaleducation.com/.
 *
 * This program is free software, licensed under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation, version 3 of the License.
 *
 * You can redistribute this application and/or modify it since you respect the terms of the GNU Affero General Public License.
 * If you modify the source code and then use this modified source code in your creation, you must make available the source code of your modifications.
 *
 * You should have received a copy of the GNU Affero General Public License along with the software.
 * If not, please see : <http://www.gnu.org/licenses/>. Full compliance requires reading the terms of this license and following its directives.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package fr.wseduc.stats.filters;

import org.entcore.common.user.UserInfos;
import org.entcore.common.utils.Config;
import org.vertx.java.core.json.JsonArray;

public class StatsSecurityUtils {

	//True : If the user has a function contained in the allowed array.
	public static boolean isUserAllowed(UserInfos user){
		JsonArray allowedFunctions = Config.getConf().getArray("overviewAllowedFunctions", new JsonArray());

		if(allowedFunctions.size() == 0)
			return true;

		for(Object functionObj : allowedFunctions){
			String function = (String) functionObj;
			if(user.getFunctions().containsKey(function))
					return true;
		}

		return false;
	}

}
