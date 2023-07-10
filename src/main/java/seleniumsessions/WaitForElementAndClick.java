package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementAndClick {
		
		//clickable elements:
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://classic.crmpro.com/");
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys("suneethav");
			driver.findElement(By.name("password")).sendKeys("Secure#12");
			By loginLoc = By.xpath("//input[@type='submit']");
			
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(loginLoc)).click();
			//1. it will check for visiblity
			//2. enable
			
			clickElementWhenReady(loginLoc, 10);
	}
		public static void clickElementWhenReady(By locator, int timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}

}
