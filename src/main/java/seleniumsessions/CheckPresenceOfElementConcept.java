package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPresenceOfElementConcept {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		By username=By.name("username");
		By password=By.name("password");
		By loginBtn=By.xpath("//button[@type='submit']");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10);

	}

}
