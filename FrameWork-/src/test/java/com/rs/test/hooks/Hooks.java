package com.rs.test.hooks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
//import com.azure.storage.blob.BlobClient;
//import com.azure.storage.blob.BlobContainerClient;
//import com.azure.storage.blob.BlobServiceClient;
//import com.azure.storage.blob.BlobServiceClientBuilder;
import com.google.inject.Inject;
import com.rs.test.config.Configuration;
import com.rs.test.tests.AllTest;

import au.com.bytecode.opencsv.CSVWriter;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
    

	    



	private final WebDriver webDriver;

	private final Logger logger = Logger.getLogger(getClass());

	private Configuration configuration;

	@Inject
	public Hooks(WebDriver webDriver) {

		this.webDriver = webDriver;

	}

	// @Before
	public void gotoHomePage() {

		// String userMgmtURL = configuration.getStringProperty("UserMgmt-url");
		// webDriver.get(userMgmtURL);

	}

	@After
	public void tearDown(Scenario scenario) {
		// attaching the screenshot in cucumber report
		System.out.println("Entering teardown method");
		if (scenario.isFailed()) {
			System.out.println("Entering teardown if scenario is failed");
			try {
				final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				if (!(webDriver instanceof TakesScreenshot)) {
					logger.error(
							"Could not capture screenshot - selected web driver does not support taking screenshots");
					return;
				}
				e.printStackTrace();
			}
		}

		else {
			try {
				System.out.println("Entering teardown if scenario is passed");
				final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				if (!(webDriver instanceof TakesScreenshot)) {
					logger.error(
							"Could not capture screenshot - selected web driver does not support taking screenshots");
					return;
				}
			}
		}

		// clearing down webdriver object
		if (webDriver != null) {
			//webDriver.close();
			webDriver.quit();
		}
	}
	
}

	/*
	 * @After public void getAllScreenShot(Scenario scenario) { // attaching the
	 * screenshot in cucumber report
	 * System.out.println("Entering teardown method");
	 * 
	 * 
	 * final byte[] screenshot = ((TakesScreenshot)
	 * webDriver).getScreenshotAs(OutputType.BYTES);
	 * System.out.println("Entering teardown if scenarioisfailed");
	 * 
	 * 
	 * // clearing down webdriver object if (webDriver != null) {
	 * webDriver.close(); // webDriver.quit(); } }
	 */


