package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;

	public static void main(String[] args) {

	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public void clickOnElement(By locator, String LinkText) {
		List<WebElement> LinksList = driver.findElements(locator);
		System.out.println("Total number of links " + LinksList.size());

		for (WebElement e : LinksList) {
			String Text = e.getText();
			System.out.println(Text);
			if (Text.equals(LinkText)) {
				e.click();
				break;
			}
		}
	}
	public  void doSearch(By searchLocator, By searchSugglocator, String searchKey, String suggName)throws InterruptedException {
		driver.findElement(searchLocator).sendKeys(searchKey);
		Thread.sleep(4000);
		List<WebElement> GoogleSuggList = driver.findElements(searchSugglocator);
		System.out.println(GoogleSuggList.size());

		for (WebElement e : GoogleSuggList) {
			String Text = e.getText();
			System.out.println(Text);
			if (Text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}
	//*****************************Drop Down Utils***********************************************//
	public void doSelectDropDownByIndex(By locator,int index) {
		if(index<0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	public void doSelectDropDownByVisibleText(By locator,String visibleText) {
		if(visibleText==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
		
	}
	public void doSelectDropDownByValue(By locator,String value) {
		if(value==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	public List<String> getDropDownTextList(By locator) {
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
