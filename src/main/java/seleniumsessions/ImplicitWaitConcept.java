package seleniumsessions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//sel 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x
		//imp wait: global wait
		//its applicable for all the web elements 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//login page:
		driver.findElement(By.name("username")).sendKeys("admin");
		//e2 --10
		//e3 --10
		//e4 --10
		//e100 --10
		
		//homepage:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//sel 4.x
		//homepage: latest wait is 20 secs now
		//he1 --20
		//he2 --20 
		//logout
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//loginpage: latest wait 10 secs 
		//e2 -- 10
		//e3 -- 10
		//e4 -- 10

		//registration page : 0 secs: nullification of implicitly wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

}
