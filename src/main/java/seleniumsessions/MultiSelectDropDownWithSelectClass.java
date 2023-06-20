package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDownWithSelectClass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		WebElement dropdownEle=driver.findElement(By.xpath("//select"));
		Select select=new Select(dropdownEle);
		if(select.isMultiple()) {
			System.out.println("multi select is possible");
		}
		

	}

}
