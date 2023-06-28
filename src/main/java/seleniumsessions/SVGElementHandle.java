package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElementHandle {

	// SVG - normal xpath wont work
	// parent svg: local-name()
	// child svg: name()
	// css selector : no support 
	// can we use other attributes: yes we can use it with "AND" and "OR" operator

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		List<WebElement> statesList = driver.findElements(By
				.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']"));
		System.out.println(statesList.size());
		// Actions act=new Actions(driver);
		for (WebElement e : statesList) {
			// act.moveToElement(e).build().perform();
			// Thread.sleep(5000);
			String statename = e.getAttribute("name");
			System.out.println(statename);
			if (statename.contains("Maryland")) {
				e.click();
				break;
			}
		}
	}
}
