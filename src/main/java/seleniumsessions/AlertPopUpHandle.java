package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		//Alert - JS PopUp
		//1. alert 2. prompt 3. confirm
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//1. Alert:
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		Alert alert=driver.switchTo().alert();
//		String text=alert.getText();
//		System.out.println(text);
//		alert.accept(); //accept the alert 
//		alert.dismiss();
		
		//2. confirm:
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Alert alert=driver.switchTo().alert();
//		String text=alert.getText();
//		System.out.println(text);
//		//alert.accept();
//		alert.dismiss();
		
		//3.prompt 
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.sendKeys("username is swecha");
		Thread.sleep(3000);
		alert.accept();
		//alert.dismiss();
		String resultText=driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(resultText);
		String actualText=resultText.split(":")[1].trim();
		System.out.println(actualText);
		
		
		

	}

}
