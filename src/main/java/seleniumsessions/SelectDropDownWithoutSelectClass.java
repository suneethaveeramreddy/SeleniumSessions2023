package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// drop down : <select> tag
		// Select Class
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//By countryOptions = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		By countryOptionsCss = By.cssSelector("select#Form_getForm_Country option");
		doSelectDropDownValueUsingLocator(countryOptionsCss, "Brazil");
		doSelectDropDownAttributeValueUsingLocator(countryOptionsCss, "Japan");

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSelectDropDownValueUsingLocator(By locator, String dropdownValue) {
		List<WebElement> optionsList=getElements(locator);
		for(WebElement e: optionsList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}
	public static void doSelectDropDownAttributeValueUsingLocator(By locator, String dropdownValue) {
		List<WebElement> optionsList=getElements(locator);
		for(WebElement e: optionsList) {
			String text=e.getAttribute("value");
			System.out.println(text);
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}

}
