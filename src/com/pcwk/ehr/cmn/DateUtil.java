package com.pcwk.ehr.cmn;

import java.util.Calendar;

public class DateUtil {
	public static String toDateFormatString(Calendar cal) {
		String result = "";
		result = result.format("%d�� %02d�� %02d��%n",cal.get(Calendar.YEAR)
												  ,cal.get(Calendar.MONTH)+1
												  ,cal.get(Calendar.DAY_OF_MONTH));
		return result;
	}
}
