package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public static void main(String[] args) {

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

}
