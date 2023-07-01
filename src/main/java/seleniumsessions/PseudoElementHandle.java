package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//::before/::after 
		
		//JS::
		//window.getComputedStyle(document.querySelector("label[for='input-firstname']"),'::before').getPropertyValue('content');
		
		//JavascriptExecutor: Interface
		
//		String script="return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')";
//		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		String man_text=js.executeScript(script).toString();
//		System.out.println(man_text);
//		if(man_text.contains("*")) {
//			System.out.println("ele is mandatory");
//		}	
		checkElementIsMandatory("input-telephone");
		checkElementIsMandatory("input-email");
	}
	
	public static void checkElementIsMandatory(String text) {
		String script="return window.getComputedStyle(document."
				+ "querySelector(\"label[for='"+text+"']\"),'::before').getPropertyValue('content')";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String man_text=js.executeScript(script).toString();
		System.out.println(man_text);
		if(man_text.contains("*")) {
			System.out.println("ele is mandatory");
		}	
	}

}
