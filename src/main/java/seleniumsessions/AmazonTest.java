package seleniumsessions;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) {
		
		String browserName="edge";
		
		BrowserUtil brUtil=new BrowserUtil();
		//brUtil.driver=new ChromeDriver();
		//brUtil.driver.get("https://www.amazon.com/");
		brUtil.launchBrowser(browserName);
		brUtil.enterUrl("https://www.amazon.com/");
		String actTitle=brUtil.getPageTitle();
		System.out.println(actTitle);
		if(actTitle.contains("Amazon")) {
			System.out.println("correct title");
		}else {
			System.out.println("incorrect title");
		}
		String actURL=brUtil.getPageURL();
		System.out.println(actURL);
		if(actURL.contains("amazon")) {
			System.out.println("correct url");
		}else {
			System.out.println("incorrect url");
		}
		brUtil.quitBrowser();
	}

}
