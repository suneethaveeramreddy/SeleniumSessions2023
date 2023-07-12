package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingWaitConcept {

	public static void main(String[] args) {
		
		//10 secs, polling/interval time = 2 secs
		//0 secs --> e1 - NA 
		//2 secs --> e2 - NA 
		//4 secs --> e3 - NA
		//6 secs --> e4 - NA
		//Total no of attempts -- 5 
		
		//default polling time = 500 ms (0.5 sec)
		WebDriver driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailAddress = By.cssSelector("#input-email11");
		By password	= By.cssSelector("#input-password");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress)).sendKeys("testing");
		

	}

}
