package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//0.valid but recommended only for the specific browser
		ChromeDriver driver=new ChromeDriver();
		
		//1.valid but not recommended 
		//SearchContext sc=new ChromeDriver();
		
		//2. valid and recommended  ---local execution
		//WebDriver driver =new ChromeDriver();
		
		//3. valid and recommended ---local execution
		//RemoteWebDriver driver=new ChromeDriver();
		
		//4. Valid only for chrome/edge 
		//ChromiumDriver driver=new ChromeDriver();
		//driver=new EdgeDriver();
		//driver=new FirefoxDriver();
		
		//5. valid and recommended -- used for remote execution/selenium grid/cloud/docker -aws/browser stack/LambdaTest
		//WebDriver driver=new RemoteWebDriver(remoteAddress, capabilities);
		
		//6.Valid but not recommended 
		//SearchContext sc=new RemoteWebDriver(remoteAddress, capabilities);
		
		
	}

}
