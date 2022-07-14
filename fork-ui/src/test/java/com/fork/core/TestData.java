package com.fork.core;

import java.util.HashMap;
import java.util.Map;

import com.fork.utils.common.Config;

/**
 * This class will generally contain the logic to record data from different data sources (excel, csv, json, ..)
 * so that we only read them once during suite startup and not every time.
 * @author jaikant
 *
 */
public class TestData {

	public static final Map<String, String> PERSONAL_INFO = new HashMap<String, String>() {
		{
			put("email", Config.getProperty("email"));
			put("firstName", Config.getProperty("firstName"));
			put("lastName", Config.getProperty("lastName"));
			put("phoneCode", Config.getProperty("phoneCode"));
			put("phoneNumber", Config.getProperty("phoneNumber"));
		}
	};
}
