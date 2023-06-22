package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframeHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='Vehicle Registration Form']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'frame-one')]")));
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("suneetha");
		driver.findElement(By.id("RESULT_TextField-9")).sendKeys("Veeram Reddy");

	}

}
