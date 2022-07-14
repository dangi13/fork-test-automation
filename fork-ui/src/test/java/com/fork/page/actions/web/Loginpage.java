package com.fork.page.actions.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fork.reporter.ExtentReporter;
import com.fork.utils.common.Config;

import static com.fork.utils.selenium.WebUtils.*;

public class Loginpage {

	private static final Logger LOGGER = LoggerFactory.getLogger(Loginpage.class);

	private WebDriver driver;

	@FindBy(how = How.ID, using = "_evidon-accept-button")
	List<WebElement> btn_accept_cookies_id;

	@FindBy(how = How.CSS, using = "button[data-testid='user-space']")
	WebElement btn_login;

	@FindBy(how = How.ID, using = "identification_email")
	WebElement input_email;

	@FindBy(how = How.CSS, using = "button[data-testid='checkout-submit-email']")
	WebElement btn_login_continue_email;

	@FindBy(how = How.ID, using = "password")
	WebElement input_password;

	@FindBy(how = How.CSS, using = "button[data-testid='submit-password']")
	WebElement btn_login_continue_password;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method can be used to login with default credentials.
	 */
	public void login() {
		ExtentReporter.info("Performing login into fork website with default credentials");
		if (btn_accept_cookies_id.size() > 0) // just handling in case in some location it arrives
			click(btn_accept_cookies_id.get(0));
		waitForElementVisibility(btn_login, 5);
		click(btn_login);
		waitForElementVisibility(input_email, 5);
		enterText(input_email, Config.getProperty("email"));
		click(btn_login_continue_email);
		waitForElementVisibility(input_password, 5);
		enterText(input_password, Config.getProperty("password"));
		click(btn_login_continue_password);
	}

	/**
	 * This method can be used to login with custom credentials.
	 * @param email
	 * @param password
	 */
	public void login(String email, String password) {
		ExtentReporter.info("Performing login into fork website");
		if (btn_accept_cookies_id.size() > 0)
			click(btn_accept_cookies_id.get(0));
		waitForElementVisibility(btn_login, 5);
		click(btn_login);
		waitForElementVisibility(input_email, 5);
		enterText(input_email, email);
		click(btn_login_continue_email);
		waitForElementVisibility(input_password, 5);
		enterText(input_password, password);
		click(btn_login_continue_password);
	}

}
