package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public static void main(String[] args) {

	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void clickOnElement(By locator, String LinkText) {
		List<WebElement> LinksList = driver.findElements(locator);
		System.out.println("Total number of links " + LinksList.size());

		for (WebElement e : LinksList) {
			String Text = e.getText();
			System.out.println(Text);
			if (Text.equals(LinkText)) {
				e.click();
				break;
			}
		}
	}
	public  void doSearch(By searchLocator, By searchSugglocator, String searchKey, String suggName)throws InterruptedException {
		driver.findElement(searchLocator).sendKeys(searchKey);
		Thread.sleep(4000);
		List<WebElement> GoogleSuggList = driver.findElements(searchSugglocator);
		System.out.println(GoogleSuggList.size());

		for (WebElement e : GoogleSuggList) {
			String Text = e.getText();
			System.out.println(Text);
			if (Text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}
	//*****************************Drop Down Utils***********************************************//
	public void doSelectDropDownByIndex(By locator,int index) {
		if(index<0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	public void doSelectDropDownByVisibleText(By locator,String visibleText) {
		if(visibleText==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
		
	}
	public void doSelectDropDownByValue(By locator,String value) {
		if(value==null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(value);
		
	}
	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	public List<String> getDropDownTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>(); 
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	public void doSelectDropDownValue(By locator, String dropdownValue) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionsList=select.getOptions();
		for(WebElement e: optionsList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}
	public void doSelectDropDownValueUsingLocator(By locator, String dropdownValue) {
		List<WebElement> optionsList=getElements(locator);
		for(WebElement e: optionsList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}
	//******************************Actions utils******************************************//
	public void selectRightClickOptions(By contextMenuLocator, String optionValue) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(contextMenuLocator)).build().perform();
		By optionLocator=By.xpath("//*[text()='"+optionValue+"']");
		getElement(optionLocator).click(); // need to replace with doClick method

	}
	public void twoLevelMenuHandling(By level1MenuLocator,By level2MenuLocator) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(getElement(level1MenuLocator)).perform();
		Thread.sleep(3000);
		getElement(level2MenuLocator).click(); // need to replace with doClick method
		
	}
	//*****************************ElementUtil********************************************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public String waitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(urlFraction + " title value is not present....");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(urlFraction + " title value is not present....");
			return null;
		}
	}
	
	public String waitForURLToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
				return driver.getCurrentUrl();
			} else {
				System.out.println(urlValue + " title value is not present....");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(urlValue + " title value is not present....");
			return null;
		}
	}

	public String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			} else {
				System.out.println(titleFraction + " title value is not present....");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(titleFraction + " title value is not present....");
			return null;
		}
	}

	public String waitForTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(titleValue))) {
				return driver.getTitle();
			} else {
				System.out.println(titleValue + " title value is not present....");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(titleValue + " title value is not present....");
			return null;
		}
	}

}
