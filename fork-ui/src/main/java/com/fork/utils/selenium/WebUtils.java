package com.fork.utils.selenium;



import static com.fork.utils.common.Constants.LOG_DESIGN;
import static java.util.Objects.nonNull;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for performing all required user actions to
 * automate a web application. It is generally made for web applications that
 * run on desktop(e.g Windows/Mac etc.) browsers.
 *
 */
public class WebUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);
	public static WebDriver driver = null;

	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		WebUtils.driver = driver;
	}
	
	/**
	 *  It will refresh the current browser tab.
	 */
	public static void refreshBrowser() {
		LOGGER.info(LOG_DESIGN +"Refreshing the browser...");
		driver.navigate().refresh();
	}
	
	/** It will check that an element is present on the DOM of a page and visible. 
	 * @param locator
	 * @param seconds
	 */
	public static void waitForElementVisibility(WebElement element, long seconds) {
		LOGGER.info(LOG_DESIGN + "waiting for visibility of element [{}] for {} seconds", element, seconds);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	/** It will hard wait for the given seconds.
	 * @param seconds
	 */
	public static void sleep(int seconds) {
		LOGGER.info(LOG_DESIGN + "Waiting for {} seconds", seconds);
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			LOGGER.info(LOG_DESIGN + "Exception occurred while waiting for {} seconds ", seconds);
		}	
	}
	
	/**
	 * It will click on a given locator.
	 * 
	 * @param locator
	 */
	public static void click(WebElement element) {
		try {
			LOGGER.info(LOG_DESIGN + "Clicking on : [{}]", element);
			highlightWebElement(element);
			element.click();
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "Exception occurred while clicking : [{}]", e.getMessage());
		}
	}

	/** It will navigate to the specified URL.
	 * @param URL
	 */
	public static void navigateToURL(String URL) {
		LOGGER.info(LOG_DESIGN + "Navigating to URL : [{}]", URL);
		driver.navigate().to(URL);
		
	}

	
	public static String getAttribute(WebElement element, String attribute) {
		LOGGER.info(LOG_DESIGN + "Getting [{}] attribute using javascript for element [{}] :" , attribute, element);
		highlightWebElement(element);
		return element.getAttribute(attribute);
	}
	
	
	/** It enters the value in text box.
	 * @param locator
	 * @param text
	 */
	public static void enterText(WebElement element, String text) {
		highlightWebElement(element);
		element.clear(); // clearing if any text is present in text box.
		LOGGER.info(LOG_DESIGN + "Entering text for element: [{}] Text is :[{}]", element, text);
		element.sendKeys(text);
		
	}
	
	
	/** It enters the value in text box.
	 * @param locator
	 * @param text
	 */
	public static void enterTextUsingActions(WebElement element, String text) {
		highlightWebElement(element);
		LOGGER.info(LOG_DESIGN  + "Entering text for : [{}] ::   Text is : [{}]", element, text);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(text);
		actions.build().perform();
	}
    
    /**
     * It clicks on given web element using javascript.
     * 
     * @param element
     */
    public static void jsClick(WebElement element) {
    	LOGGER.info(LOG_DESIGN + "Clicking on element : {} using javascript", element);
    	highlightWebElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
 
    
    /** It will highlight the web element
     * @param element
     */
    public static void highlightWebElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background:#ffffb3; border:3px solid green;');", element);
    }
	
	/** It will first close the opened browser and then kill the chromedriver process.
	 * 
	 */
	public static void terminateBrowser() {
		if (nonNull(driver)) {
			driver.close();
			driver.quit();
		}
	}
	
	/** It will get selected value from dropdown
	 * @param element
	 */
	public static String getSelectedValueInDropDown(WebElement element) {
		Select select = new Select(element);
		String selectedValueFromDropdown = select.getFirstSelectedOption().getText();
		LOGGER.info(LOG_DESIGN + "Selected value from dropdown [{}] , is [{}]", element, selectedValueFromDropdown);
		return selectedValueFromDropdown;
	}
	
	
	/** It will capture the screenshot in the browser.
	 * @param webdriver
	 * @param screenshotPath
	 */
	public static void captureScreenshot(WebDriver webdriver, String screenshotPath) {
		LOGGER.info(LOG_DESIGN + "Capturing Screenshot..");
		try {
			
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);
			LOGGER.info(LOG_DESIGN + "Screenshot Captured. : {}", screenshotPath);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "!!!!!! Exception while Copying Screen Shot to Results folder and exception details are: {}", e.getMessage());

		}

	}
	
}
