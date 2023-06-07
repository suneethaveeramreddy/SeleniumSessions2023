package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterColumnCheck {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		Thread.sleep(6000);

		System.out.println(getFooterHeaderText("Blog"));
		System.out.println(getFooterHeaderText("Amazon Science"));
		System.out.println(getFooterHeaderText("Your Account"));
		System.out.println(getFooterHeaderText("Shop with Points"));

		// a[text()='Blog']/ancestor::ul/parent::div/div
		// a[text()='Blog']/parent::li/parent::ul//parent::div/div
		// a[text()='Blog']/parent::li/ancestor::ul/preceding-sibling::div
		// a[text()='Blog']/ancestor::div[@class='navFooterLinkCol
		// navAccessibility']/div

		driver.quit();

	}

	public static String getFooterHeaderText(String footerText) {
		String footerHeaderText = driver.findElement(By.xpath(
				"//a[text()='" + footerText + "']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div"))
				.getText();

		return footerHeaderText;

	}

	// a[text()='Joe.Root']/parent::td/preceding-sibling::td/input
	//a[text()='Joe.Root']/ancestor::tr//input[@type='checkbox']
	//a[text()='Joe.Root']/parent::td//following-sibling::td

}
