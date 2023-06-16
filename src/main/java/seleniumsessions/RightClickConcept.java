package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
//		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
//		Actions act = new Actions(driver);
//		act.contextClick().build().perform();
//		The above action will do right click on the web application based on driver cursor location
//		act.contextClick(rightClickEle).build().perform();
//		List<WebElement> OptionsList=driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root span"));
//		System.out.println(OptionsList.size());
//		for(WebElement e:OptionsList) {
//			String text=e.getText();
//			System.out.println(text);
//			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}

		//driver.findElement(By.xpath("//span[text()='Copy']")).click();
		By contextMenuLocator=By.xpath("//span[text()='right click me']");
		selectRightClickOptions(contextMenuLocator, "Quit");
		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectRightClickOptions(By contextMenuLocator, String optionValue) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(contextMenuLocator)).build().perform();
		By optionLocator=By.xpath("//*[text()='"+optionValue+"']");
		getElement(optionLocator).click();

	}

}