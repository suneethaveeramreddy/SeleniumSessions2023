package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		//inject JS script/code 
		
		//RWD --> WD
		//RWD --> JSE -- executeScript()
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert('hi this is naveen')");
		String title=js.executeScript("return document.title").toString();
		System.out.println(title);

	}

}
