package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		/*
		 * act.sendKeys(Keys.PAGE_DOWN).build().perform(); 
		 * Thread.sleep(1000);
		 * act.sendKeys(Keys.PAGE_DOWN).perform(); 
		 * Thread.sleep(1000);
		 * act.sendKeys(Keys.PAGE_UP).perform();
		 */
		
		//control/CMD + KEY DOWN
		//act.sendKeys(Keys.END).perform();
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).build().perform();
		Thread.sleep(1000);
		//act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		//scrollToElement:
		act.scrollToElement(driver.findElement(By.linkText("Help"))).click();
		
		

	}

}
