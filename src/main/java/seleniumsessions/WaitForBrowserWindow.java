package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForBrowserWindow {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println(flag);

	}
	
	public static Boolean waitForNumberOfBrowserWindows(int timeOut, int numberOfWindowsToBe) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindowsToBe));
	}

}
