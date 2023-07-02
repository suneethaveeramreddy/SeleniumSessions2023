package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(3000);
		
		//Browser-Page-shadow DOM - shadow DOM -e1
		String script="return document.querySelector('#userName').shadowRoot.querySelector('#app2').shadowRoot.querySelector('#pizza')";
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//getting html element --> webelement
		WebElement pizza_ele=(WebElement)js.executeScript(script);
		pizza_ele.sendKeys("Veg Pizza");
		
		driver.findElement(By.id("pizza")).sendKeys("veg pizza");
		
		Thread.sleep(5000);
		
		driver.get("chrome://settings/");
		
		WebElement search=(WebElement)js.executeScript("return document.querySelector(\"body > settings-ui\")."
				+ "shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		search.sendKeys("notification");
	}

}
