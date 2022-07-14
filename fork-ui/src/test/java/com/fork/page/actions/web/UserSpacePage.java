package com.fork.page.actions.web;

import static com.fork.utils.selenium.WebUtils.getAttribute;
import static com.fork.utils.selenium.WebUtils.getSelectedValueInDropDown;
import static com.fork.utils.selenium.WebUtils.waitForElementVisibility;
import static com.fork.utils.selenium.WebUtils.click;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fork.reporter.ExtentReporter;

public class UserSpacePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserSpacePage.class);

	private WebDriver driver;

	@FindBy(how = How.CSS, using = "button[data-testid='user-space']")
	WebElement btn_user_space;

	@FindBy(how = How.ID, using = "USER_SPACE_FIRST_PANEL")
	WebElement drawer_userspace;

	// we can also validate that heading is displayed or not, for now only validating the information of user
	@FindBy(how = How.CSS, using = "#USER_SPACE_FIRST_PANEL h1") 
	WebElement heading_username;

	@FindBy(how = How.CSS, using = "button[aria-controls='user-space-user-information']")
	WebElement button_personal_information;

	@FindBy(how = How.NAME, using = "firstName")
	WebElement input_personal_space_first_name;

	@FindBy(how = How.NAME, using = "lastName")
	WebElement input_personal_space_last_name;

	@FindBy(how = How.NAME, using = "email")
	WebElement input_personal_space_email;

	@FindBy(how = How.CSS, using = "input[data-testid='phone-input-number']")
	WebElement input_personal_space_phone_number;

	@FindBy(how = How.ID, using = "PHONE_CODE_FIELD")
	WebElement select_personal_space_phone_code;

	public UserSpacePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openUserSpaceDrawer() {
		ExtentReporter.info("Opening user space drawer");
		waitForElementVisibility(btn_user_space, 5);
		click(btn_user_space);
	}
	
	public void openPersonalInformationPage() {
		ExtentReporter.info("Opening personal information page");
		waitForElementVisibility(button_personal_information, 5);
		click(button_personal_information);
	}
	
	/**
	 * This method can be used to get the info present on personal information page.
	 * @return Map<String, String>
	 */
	public Map<String, String> getPersonalInfo() {
		ExtentReporter.info("Extracting personal information");
		waitForElementVisibility(input_personal_space_email, 5);
		
		return new HashMap<String, String>() {
			{
				put("email", getAttribute(input_personal_space_email, "value"));
				put("firstName", getAttribute(input_personal_space_first_name, "value"));
				put("lastName", getAttribute(input_personal_space_last_name, "value"));
				put("phoneCode", getSelectedValueInDropDown(select_personal_space_phone_code));
				put("phoneNumber", getAttribute(input_personal_space_phone_number, "value"));
			}
		};
	}
}
