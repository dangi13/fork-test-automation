package com.fork.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.fork.utils.common.Config;
import com.fork.utils.selenium.DriverPool;
import com.fork.utils.selenium.WebUtils;

public class BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfiguration.class);

	public static WebDriver driver;
	private ITestContext context;
	private static final String APPLICATION_URL = Config.getProperty("appURL");

	@Parameters({ "browser", "nodeURL" })
	@BeforeClass
	public void setup(@Optional("CHROME") String browser, @Optional("") String nodeURL, ITestContext ctx) {
		try {
			nodeURL = System.getenv("BROWSERSTACK_URL") != null ? System.getenv("BROWSERSTACK_URL"): nodeURL;
			driver = DriverPool.getDriver(browser, nodeURL);
			WebUtils.setDriver(driver);
			driver.manage().window().maximize();
			WebUtils.navigateToURL(APPLICATION_URL);
			WebUtils.sleep(30);
		} catch (Exception e) {
			LOGGER.error("Error occured {} ", e.getMessage());

			throw new WebDriverException(e.getMessage());
		}

		this.context = DriverPool.setupContext(driver, ctx, browser, nodeURL);
	}

}
