package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("https://classic.crmpro.com/");
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys("suneethav");
			driver.findElement(By.name("password")).sendKeys("Secure#12");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			By framelocator=By.name("mainpanel");
			
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
			waitForFrameByLocator(framelocator,10);
			driver.findElement(By.linkText("CONTACTS")).click();
	}
		
		public static void  waitForFrameByLocator(By framelocator,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
		}
		
		public static void  waitForFrameByIndex(int frameIndex,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		}
		public static void  waitForFrameByFrameNameOrID(String frameNameOrID,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
		}
		public static void  waitForFrameByFrameElement(WebElement frameElement,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		}
		
}
