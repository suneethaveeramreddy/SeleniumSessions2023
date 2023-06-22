package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("suneethav");
		driver.findElement(By.name("password")).sendKeys("Secure#12");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
	}

}
