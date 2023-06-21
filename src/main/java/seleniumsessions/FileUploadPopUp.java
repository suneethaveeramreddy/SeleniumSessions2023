package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//type = file -- 99.99%
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\sunee\\OneDrive\\Pictures\\Screenshots\\1080pixel.png");

		//what if type=file is not available?
		//1. add your dev team to add this attribute.
		//2. robot class -- not recommended -- it works only and only for windows.wont work for Linux, mac, docker, cloud, jenkins , headless
		//3. AutoIt -- not recommended -- it works only and only for windows.wont work for Linux, mac, docker, cloud, jenkins , headless
		//4. sikuli -- not remommended --coz its based on image
		
		//adv pop ups ---QA/STAGE/DEV/UAT -- no adv pop ups
		//only for PROD
		//no need to switch to alert 
		//random popup ---should we automate this? -- never automate
		
		
		
		
		//browser window popups 
	}

}
