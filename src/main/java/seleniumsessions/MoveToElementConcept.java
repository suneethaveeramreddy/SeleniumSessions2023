package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		//WebElement parentMenu=driver.findElement(By.cssSelector("a.menulink"));
//		Actions act=new Actions(driver);
//		//act.moveToElement(parentMenu);//not valid 
//		//act.moveToElement(parentMenu).build();//not valid 
//		//act.moveToElement(parentMenu).perform(); // Valid
//		//act.moveToElement(parentMenu).build().perform(); // Valid 
//		Thread.sleep(1500);
//		//WebElement childMenu=driver.findElement(By.linkText("COURSES"));
//		//childMenu.click();
//		driver.findElement(By.xpath("//ul[@class='submenu']//a[text()='Courses']")).click();
		
		By parentMenu=By.cssSelector("a.menulink");
		By childMenu=By.xpath("//ul[@class='submenu']//a[text()='Articles']");
		twoLevelMenuHandling(parentMenu, childMenu);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void twoLevelMenuHandling(By level1MenuLocator,By level2MenuLocator) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(getElement(level1MenuLocator)).perform();
		Thread.sleep(3000);
		getElement(level2MenuLocator).click();
		
	}

}
