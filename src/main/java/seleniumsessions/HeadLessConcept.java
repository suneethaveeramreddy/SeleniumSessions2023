package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessConcept {

	public static void main(String[] args) {
		 //headless: No browser 
		//invisible browser // without UI
		//testing happening behind the scene
		//faster than the normal mode 
		//when to use? Linux OS, Jenkins, Docker, NON UI
		//might not work for complex html, navigations, responsive testing:
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless=new");
	
		/* co.setHeadless(false) */
		
		FirefoxOptions fo=new FirefoxOptions();
		fo.addArguments("--headless=new");
		
		EdgeOptions eo=new EdgeOptions();
		eo.addArguments("--headless=new");
//		
//		Deprecated.  Use addArguments(String).Recommended to
//		use '--headless=chrome' as argument for browsers v94-108.
//		Recommended to use '--headless=new' as argument 
//		for browsers v109+.Example: `addArguments("--headless=new")`.
		
		//WebDriver driver=new ChromeDriver(co);
		WebDriver driver =new FirefoxDriver(fo);
		//WebDriver driver=new EdgeDriver(eo);
		
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	
	}

}
