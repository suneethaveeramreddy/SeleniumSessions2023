package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframesHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		//page
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(2000);
		
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("Entered first Crush");
		Thread.sleep(3000);
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("Second Crush");
		
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Destiny Crush");
		
		//pact2
		driver.switchTo().parentFrame();//sel 4.x
		driver.findElement(By.id("jex")).sendKeys(" entered second crush again");
		
		//pact1
		driver.switchTo().parentFrame();//sel 4.x
		driver.findElement(By.id("inp_val")).sendKeys(" entered first Crush again");
		
		//back to page/browser context:
		//driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		String headerText=driver.findElement(By.tagName("h3")).getText();
		System.out.println(headerText);
	}

}
