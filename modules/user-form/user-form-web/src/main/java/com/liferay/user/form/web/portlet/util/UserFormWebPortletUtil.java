package com.liferay.user.form.web.portlet.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Juan Pablo Montero
 */
public class UserFormWebPortletUtil {

	public static boolean  isValidDate (Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -99);
		Date maxDateAllow = cal.getTime();
		cal.add(Calendar.YEAR, 99-18);
		Date minDateAllow = cal.getTime();
		// ages between 18 and 99 allowed
		if (date.compareTo(new Date()) >=0 || date.after(minDateAllow) || date.before(maxDateAllow)) {
			return false;
		}
		return true;
	}

	

}
