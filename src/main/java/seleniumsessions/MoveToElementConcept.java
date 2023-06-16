package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement parentMenu=driver.findElement(By.cssSelector("a.menulink"));
		Actions act=new Actions(driver);
		//act.moveToElement(parentMenu);//not valid 
		//act.moveToElement(parentMenu).build();//not valid 
		act.moveToElement(parentMenu).perform(); // Valid
		act.moveToElement(parentMenu).build().perform(); // Valid 
		Thread.sleep(1500);
		//WebElement childMenu=driver.findElement(By.linkText("COURSES"));
		//childMenu.click();
		driver.findElement(By.xpath("//ul[@class='submenu']//a[text()='Courses']")).click();
		
	}

}
