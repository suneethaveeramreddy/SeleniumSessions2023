package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablehandle {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		selectEmp("John.Smith");
		selectEmp("Joe.Root");
		System.out.println(getEmpInfo("John.Smith"));
		System.out.println(getEmpInfo("Joe.Root"));

	}

	public static void selectEmp(String empName) {
		driver.findElement(
				By.xpath("//a[text()='" + empName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static List<String> getEmpInfo(String empName) {
		List<WebElement> infoList = driver
				.findElements(By.xpath("//a[text()='" + empName + "']/parent::td/following-sibling::td"));
		System.out.println(infoList.size());
		List<String> infoValList =new ArrayList<String>();
		for(WebElement e:infoList) {
			String text = e.getText();
			infoValList.add(text);
		}
		return infoValList;

	}
}
