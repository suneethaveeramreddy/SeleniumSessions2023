package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricinfoScoreTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/west-indies-in-united-arab-emirates-2023-1376996/"
				+ "united-arab-emirates-vs-west-indies-3rd-odi-1377007/full-scorecard");

		Thread.sleep(4000);

		System.out.println(getWktakerName("Lovepreet Singh"));
		System.out.println(getWktakerName("Rameez Shahzad"));
		System.out.println(getScoreCardInfo("Muhammad Waseem"));
		System.out.println(getScoreCardInfo("Rameez Shahzad"));
		driver.quit();

	}

	public static String getWktakerName(String batsmenName) {
		System.out.println("batsmen name: " + batsmenName);
		return driver
				.findElement(By.xpath("//span[text()='" + batsmenName + "']/ancestor::td/following-sibling::td//span"))
				.getText();

	}

	public static List<String> getScoreCardInfo(String batsmenName) {
		System.out.println("batsmen name: " + batsmenName);
		List<WebElement> ScoreCardValuesList= driver.findElements(By.xpath("//span[text()='" + batsmenName
				+ "']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
		List<String> infoValList =new ArrayList<String>();
		for(WebElement e:ScoreCardValuesList) {
			String text=e.getText();
			infoValList.add(text);
		}
		return infoValList;
	}

}
