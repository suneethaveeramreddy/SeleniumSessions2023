package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import customException.FrameworkException;

/**
 * 
 * @author sunee
 *
 */

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialise the driver on the basis of given browser
	 * name.
	 * valid browsers = chrome/firefox/edge/safari
	 * @param browserName
	 */

	public void launchBrowser(String browserName) {
		System.out.println("browser name is: " + browserName);

		if (browserName == null) {
			System.out.println("browser cannot be null");
			throw new FrameworkException("BROWSERCANNOTBENULL");
		}

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("plz pass the right browser name..." + browserName);
			throw new FrameworkException("NOTVALIDBROWSER");
		}
	}
	/**
	 * 
	 * @param url
	 */

	public void enterUrl(String url) {
		if (url.contains("http")) {
			driver.get(url);
		} else {
			throw new FrameworkException("URL SHOULD HAVE http(s)");
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}
}
