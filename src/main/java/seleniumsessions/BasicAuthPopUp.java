package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String username="admin";
		String Password="admin";
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://"+username+":"+Password+"@the-internet.herokuapp.com/basic_auth");
		
		

	}

}
