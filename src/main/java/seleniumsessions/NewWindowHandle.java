package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentWindowID=driver.getWindowHandle();
		//driver.switchTo().newWindow(WindowType.TAB);
		//sel 4.x
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());
		driver.quit();
		
		

	}

}
