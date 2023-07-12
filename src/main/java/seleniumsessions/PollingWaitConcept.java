package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollingWaitConcept {

	public static void main(String[] args) {
		
		//10 secs, polling/interval time = 2 secs
		//0 secs --> e1 - NA 
		//2 secs --> e2 - NA 
		//4 secs --> e3 - NA
		//6 secs --> e4 - NA
		
		//default polling time = 500 ms (0.5 sec)
		WebDriver driver= new ChromeDriver();
		driver.get("");
		
		WebDriverWait wait=new WebDriverWait(driver, 10, 2);
		

	}

}
