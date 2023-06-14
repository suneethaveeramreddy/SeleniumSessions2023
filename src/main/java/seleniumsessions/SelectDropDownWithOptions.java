package seleniumsessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// drop down : <select> tag
		// Select Class
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		By country = By.cssSelector("#Form_getForm_Country");
		/*
		 * Select select = new Select(driver.findElement(country)); List<WebElement>
		 * countryOptionsList = select.getOptions();
		 * System.out.println(countryOptionsList.size()); int count = 0; for (WebElement
		 * e : countryOptionsList) { String text = e.getText(); System.out.println(count
		 * + ": " + text); count++; }
		 */
		if(getDropDownTextList(country).contains("India")) {
			System.out.println("PASS");
		}
		List<String>expCountryOptionsList=Arrays.asList("Brazil","India","Japan");
		
		if(getDropDownTextList(country).containsAll(expCountryOptionsList)) {
			System.out.println(expCountryOptionsList+" is available");
		}
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	public static List<String> getDropDownTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>(); 
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	}


