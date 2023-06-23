package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YatraFramePopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.yatra.com/");//page
		Thread.sleep(3000);
		
		//driver.switchTo().frame("")
		
	

	}

}
