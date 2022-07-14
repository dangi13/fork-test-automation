package com.fork.page.validators.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fork.utils.common.CustomAssertion;

/** This class contains all validations related to Personal Info Page.
 * 
 * @author Jaikant
 *
 */
public class PersonalInfoValidator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalInfoValidator.class);

	
	/** It will validate the personal information.
	 * @param actual
	 * @param expected
	 */
	public void validatePersonalInformation(Map<String, String> actual, Map<String, String> expected) {
		CustomAssertion.assertEquals(actual, expected);
	}


}
