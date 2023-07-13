package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentWaitFeatures {
	static WebDriver driver;
	public static void main(String[] args) {
		//WebDriverWait  --> FluentWait --> Wait (until();) 
							//until(){}
		//own methods 
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailAddress = By.cssSelector("#input-email");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait
			.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class)
					.withMessage("----time out is done....element is not found..." +emailAddress);
	}

}
