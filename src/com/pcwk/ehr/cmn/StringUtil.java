package com.pcwk.ehr.cmn;

import java.util.UUID;

public class StringUtil {
	
	public static String getUUID() {
		UUID uuidTemp = UUID.randomUUID();
		
		return uuidTemp.toString().replaceAll("-", "");
	}

}
