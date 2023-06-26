package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleWithList {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();

		// fetching the window IDs:
		Set<String> handles = driver.getWindowHandles();
		// convert set to List
		List<String> handlesList = new ArrayList<String>(handles);
		String parentWindowID = handlesList.get(0);
		System.out.println(parentWindowID);
		String childWindowID = handlesList.get(1);
		System.out.println(childWindowID);
		
		// switch work:
		driver.switchTo().window(childWindowID);
		System.out.println("child window url: " + driver.getCurrentUrl());

		// close the child window:
		driver.close();
		Thread.sleep(3000);

		// come back to parent window
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url: " + driver.getCurrentUrl());
		driver.quit();
	}

}
