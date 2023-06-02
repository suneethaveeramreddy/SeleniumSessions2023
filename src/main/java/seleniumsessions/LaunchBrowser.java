package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) {

		// open the browser - chrome
		//ChromeDriver driver = new ChromeDriver();

		// FirefoxDriver driver=new FirefoxDriver();

		// EdgeDriver driver=new EdgeDriver();
		
		WebDriver driver = new ChromeDriver();

		// enter the url:
		driver.get("https://www.google.com/");

		// get the Title:
		String title = driver.getTitle();
		System.out.println("Actual title: " + title);

		// verify the title: act vs exp result: checkpoint/verification point
		if (title.equalsIgnoreCase("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("In-correct title");
		}

		driver.quit();

	}

}
