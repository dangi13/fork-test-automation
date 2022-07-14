package com.fork.tests.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fork.core.BaseConfiguration;
import com.fork.core.TestData;
import com.fork.page.actions.web.Loginpage;
import com.fork.page.actions.web.UserSpacePage;
import com.fork.page.validators.web.PersonalInfoValidator;

public class PersonalInfoTest extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalInfoTest.class);

	private Loginpage loginPage;
	private UserSpacePage userSpacePage;
	private PersonalInfoValidator personlInfoValidator;

	@BeforeClass
	public void setUp() {
		loginPage = new Loginpage(driver);
		userSpacePage = new UserSpacePage(driver);
		personlInfoValidator = new PersonalInfoValidator();
	}

	@Test(testName = "TC_01", description = "Validate personal information")
	public void test_personal_information() {
		loginPage.login();
		userSpacePage.openUserSpaceDrawer();
		userSpacePage.openPersonalInformationPage();
		Map<String, String> actualPersonalInfo = userSpacePage.getPersonalInfo();
		Map<String, String> expectedPersonalInfo = TestData.PERSONAL_INFO;
		personlInfoValidator.validatePersonalInformation(actualPersonalInfo, expectedPersonalInfo);
	}

}
