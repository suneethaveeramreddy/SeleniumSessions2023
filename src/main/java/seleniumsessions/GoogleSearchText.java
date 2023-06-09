package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchText {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By search = By.xpath("//textarea[@name='q']");
		By suggestionList = By.xpath("//ul[@role='listbox']//div[@role='presentation']/span");

		doSearch(search, suggestionList, "Naveen Automation Labs", "youtube");

		driver.quit();
	}

	public static void doSearch(By searchLocator, By searchSugglocator, String searchKey, String suggName)
			throws InterruptedException {
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
