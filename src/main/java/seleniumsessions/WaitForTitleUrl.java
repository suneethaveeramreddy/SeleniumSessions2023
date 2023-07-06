package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");

		// wait for the right title:

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		if (wait.until(ExpectedConditions.titleContains("Free CRM"))) {
//			System.out.println(driver.getTitle());
//		}
		
		waitForTitleContains("Free CRM", 5);
	}
	

	public static Boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}

}
