package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By GoogleFooterLinks = By.xpath("//div[@class='KxwPGc SSwjIe']//a[@class='pHiOh']");
		clickOnElement(GoogleFooterLinks, "Business");
		driver.quit();
	}

	public static void clickOnElement(By locator, String LinkText) {
		List<WebElement> GoogleFooterLinks = driver.findElements(locator);
		System.out.println("Total number of links " + GoogleFooterLinks.size());

		for (WebElement e : GoogleFooterLinks) {
			String AttributeText = e.getAttribute("href");
			System.out.println(AttributeText);
		}
		for (WebElement e : GoogleFooterLinks) {
			String Text = e.getText();
			System.out.println(Text);
			if (Text.equals(LinkText)) {
				e.click();
				break;
			}
		}
	}

}
