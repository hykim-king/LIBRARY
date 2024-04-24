package com.pcwk.ehr.cmn;

import java.util.UUID;

public interface StringUtil {

	/**
	 * 32bit UUID 생성
	 * 
	 * @return String
	 */
	public static String getUUID() {

		UUID uuidTemp = UUID.randomUUID();

		return uuidTemp.toString().replaceAll("-", "");

	}
}
