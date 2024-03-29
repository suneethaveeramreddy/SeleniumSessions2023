package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

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

	public void doSearch(By searchLocator, By searchSugglocator, String searchKey, String suggName)
			throws InterruptedException {
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

	// *****************************Drop Down
	// Utils***********************************************//
	public void doSelectDropDownByIndex(By locator, int index) {
		if (index < 0) {
			System.out.println("please pass the right (+ve) index");
			return;
		}
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		if (visibleText == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);

	}

	public void doSelectDropDownByValue(By locator, String value) {
		if (value == null) {
			System.out.println("please pass the right visible text and it can not be null");
			return;
		}
		Select select = new Select(getElement(locator));
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
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}

	public void doSelectDropDownValueUsingLocator(By locator, String dropdownValue) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}

	// ******************************Actions
	// utils******************************************//
	public void selectRightClickOptions(By contextMenuLocator, String optionValue) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(contextMenuLocator)).build().perform();
		By optionLocator = By.xpath("//*[text()='" + optionValue + "']");
		getElement(optionLocator).click(); // need to replace with doClick method

	}

	public void twoLevelMenuHandling(By level1MenuLocator, By level2MenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level1MenuLocator)).perform();
		Thread.sleep(3000);
		getElement(level2MenuLocator).click(); // need to replace with doClick method

	}

	// *****************************ElementUtil********************************************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresence(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * 
	 * @param urlFraction
	 * @param timeOut
	 * @return
	 */
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

	/**
	 * An expectation for the URL of the current page to be a specific url.
	 * 
	 * @param urlValue
	 * @param timeOut
	 * @return
	 */
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

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param titleFraction
	 * @param timeOut
	 * @return
	 */
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

	/**
	 * An expectation for checking the title of a page.
	 * 
	 * @param titleValue
	 * @param timeOut
	 * @return
	 */
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

	/**
	 * An expectation for the alert (JS) to be appeared on the page.
	 * 
	 * @param timeOut
	 * @return
	 */
	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public Alert waitForJSAlert(int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public Boolean waitForNumberOfBrowserWindows(int timeOut, int numberOfWindowsToBe) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindowsToBe));
	}

	public void waitForFrameByLocator(By framelocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}

	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameByFrameNameOrID(String frameNameOrID, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}

	public void waitForFrameByFrameElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	// **************************FluentWait Utils******************************//
	public WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done....element is not found..." + locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done....element is not found..." + locator);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Alert waitForJSAlertWithFluentWait(int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoAlertPresentException.class)
				.withMessage("----time out is done....JS alert is not found...");
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForFrameWithFluentWait(String frameNameOrID, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchFrameException.class)
				.withMessage("----time out is done....Frame is not found...with name or ID: " + frameNameOrID);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}

	public void waitForElementAndEnterValue(By locator, int timeOut, int pollingTime, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done....element is not found..." + locator)
				.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(Value);
	}

	public void waitForElementAndClick(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.withMessage("----time out is done....element is not found..." + locator)
				.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
	}
	//*****************************Custom wait****************************************//
	public  WebElement retryingElement(By locator, int timeOut) {
		WebElement element=null;
		int attempts=0;
		while (attempts<timeOut) {//10
			try {
				element=getElement(locator);
				System.out.println("element is found...." +locator + "in attempt " +attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found....." + locator + "in attempt " + attempts);
				try {
					Thread.sleep(500);//default polling time = 500 ms 
				}catch(InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("element is not found..." +locator + "in total no of attempts " +attempts);
		}
		
		return element;
	}
	public  WebElement retryingElement(By locator, int timeOut, long pollingTime) {
		WebElement element=null;
		int attempts=0;
		while (attempts<timeOut) {//10
			try {
				element=getElement(locator);
				System.out.println("element is found...." +locator + "in attempt " +attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found....." + locator + "in attempt " + attempts);
				try {
					Thread.sleep(pollingTime);//polling time = custom value
				}catch(InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("element is not found..." +locator + "in total no of attempts " +attempts);
		}
		return element;
	}
}
