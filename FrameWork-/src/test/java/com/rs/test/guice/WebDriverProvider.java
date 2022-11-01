package com.rs.test.guice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rs.test.config.Configuration;
import com.rs.test.config.Constants;

public class WebDriverProvider implements Provider<WebDriver> {

	private final Configuration configuration;
	private static WebDriver htmlDriver;
	private static WebDriver driver;

	@Inject
	public WebDriverProvider(Configuration configuration) {
		this.configuration = configuration;
	}

	private WebDriver getWebDriver() {
		String browserName = configuration.getStringProperty("browser-name");
		String remoteHubURL = configuration.getStringProperty("remoteHubURL");
		
		switch (browserName) {

		case "chrome":
			
			DesiredCapabilities chro = DesiredCapabilities.chrome();
			chro.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT);
			chro.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			chro.setCapability(CapabilityType.HAS_NATIVE_EVENTS,true);
			chro.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS,true);
			chro.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
			chro.setCapability(CapabilityType.SUPPORTS_ALERTS,true);
			chro.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
			
			System.out
			.println(Constants.USER_DIR);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			chro.setCapability(ChromeOptions.CAPABILITY, options);
			
            System.setProperty("webdriver.chrome.driver", Constants.USER_DIR + "/bin/chromedriver/chromedriver.exe");
            return new ChromeDriver(chro);

		case "ie":
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
			desiredCapabilities.setCapability("nativeEvents", false);
			System.setProperty("webdriver.ie.driver", Constants.USER_DIR + "/bin/iedriver/x64/IEDriverServer.exe");
			return new InternetExplorerDriver();

		case "firefox":
			/*System.setProperty("webdriver.firefox.marionette",
					Constants.USER_DIR + "/bin/geckodriver/x64/geckodriver.exe");*/
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			File pathToBinary = new File("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver",Constants.USER_DIR + "/bin/geckodriver/x64/geckodriver.exe");       
			return new FirefoxDriver(ffBinary,firefoxProfile);
			
		case "headless":
			
			System.out
			.println("---------------: Inside Headless profile :--------------");
			DesiredCapabilities hl = DesiredCapabilities.htmlUnit();
			hl.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT);
			hl.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			hl.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			hl.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
			hl.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			htmlDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
			
			((HtmlUnitDriver) htmlDriver).setJavascriptEnabled(true);
			System.out
			.println("==========:::: got Headless driver ::::===========");
			return htmlDriver;
			
          case "phantomjs":
			
			System.out
			.println("---------------: Inside Phantom profile :--------------");
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);                
			caps.setCapability("takesScreenshot", true);  
			caps.setCapability(
			                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
			                        Constants.USER_DIR + "/bin/phantomjsdriver/phantomjs.exe"
			                    );
			WebDriver phantomDriver = new  PhantomJSDriver(caps);
			
			/* System.setProperty("phantomjs.binary.path", Constants.USER_DIR + "/bin/phantomjsdriver/phantomjs.exe");
			 WebDriver phantomDriver = new  PhantomJSDriver();*/
			System.out
			.println("==========:::: got Phantom driver ::::===========");
			return phantomDriver;
			
          case "chrome_Remote":
			
			DesiredCapabilities chro_rmt = DesiredCapabilities.chrome();
			chro_rmt.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT);
			chro_rmt.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			chro_rmt.setCapability(CapabilityType.HAS_NATIVE_EVENTS,true);
			chro_rmt.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS,true);
			chro_rmt.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,true);
			chro_rmt.setCapability(CapabilityType.SUPPORTS_ALERTS,true);
			chro_rmt.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
			
			
			ChromeOptions options_rmt = new ChromeOptions();
			options_rmt.addArguments("--test-type");
			chro_rmt.setCapability(ChromeOptions.CAPABILITY, options_rmt);
			
            System.setProperty("webdriver.chrome.driver", Constants.USER_DIR + "/bin/chromedriver/chromedriver.exe");
            
            try {
				driver = new RemoteWebDriver(new URL(remoteHubURL),chro_rmt);
				driver = new Augmenter().augment(driver);
				System.out.println("==========:::: got remote Chrome driver ::::===========");
				return driver;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
          case "sauce":
        	  
        	  driver = new RemoteWebDriver(getRemoteURL(), capabilities());
  			return driver;

		default:
			System.setProperty("webdriver.chrome.driver", Constants.USER_DIR + "/bin/chromedriver/chromedriver.exe");
			return new ChromeDriver();
		}
	}

	public WebDriver get() {
		return getWebDriver();
	} 
	
	private URL getRemoteURL() {
		try {
			return new URL("http://" + configuration.getStringProperty("sauce.username") + ":"
					+ configuration.getStringProperty("sauce.accesskey") + "@ondemand.saucelabs.com:80/wd/hub");
		} catch (MalformedURLException e) {
			throw new WebDriverException(e);
		}

	}
	
	private DesiredCapabilities capabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("platform", configuration.getStringProperty("platform"));
		capabilities.setCapability("version", configuration.getStringProperty("version"));
		capabilities.setCapability("maxInstances", "100");
		capabilities.setCapability("commandTimeout", "600");
		capabilities.setCapability("maxDuration", "1200");
		capabilities.setCapability("screenResolution", "1440x900");
		capabilities.setCapability("idleTimeout", "200");
		return capabilities;
	}

}
