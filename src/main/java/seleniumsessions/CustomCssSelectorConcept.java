package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCssSelectorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://app.hubspot.com/login/beta");
		Thread.sleep(4000);
		
	//id --> #id
		//#input-email
		//tag#id
		//input#input-email

		
	//class --> .class
		//tagname.class
		//input.form-control
		By.cssSelector("input.form-control");
		
	//c1 c2 c3 ...........cn
		//.c1.c2.c3....cn
		// .form-control.private-form__control.login-email
		//tag.c1.c2.c3.....cn
		// input.form-control.private-form__control.login-email
		// input.form-control.login-email
		// input.login-email.form-control.private-form__control
		// input.login-email
		
	// id and class
		// #id.class
		// .class#id
		// tag#id.class
		// tag.class#id
		// #username.login-email
		// .login-email#username
		// input.form-control.private-form__control.login-email#username
		// #username.form-control.private-form__control.login-email
		// input#username.form-control.private-form__control.login-email
		// input.form-control#username.private-form__control.login-email
		
	//Other attributes
		// tagname[attr='value']
		// input[placeholder='E-Mail Address'] --- CSS selector
		//input[@placeholder='E-Mail Address'] -- Xpath 
		
	//More than one attribute
		// tagname[attr1='value'][attr2='value'][attr3='value']
		// input[type='text'][name='email'][placeholder='E-Mail Address']
		// input[type][name][placeholder]
		// [id] -- CSS selector
		// //*[@id]
		// input[id]
		
	//text in css: NA
		
		//CSS3 
		
	//Contains in css:
		// tag[attr*='value']
		//input[placeholder*='Address'] -- css
		//input[contains(@class,'Address')] -- xpath
		//input[placeholder*='Address'][id='input-email']
		//input[placeholder*='Address'][id^='input']
		//input[placeholder*='Address'][id^='input'][class$='control']
		//input[placeholder*='Address'][class$='control']#input-email
		
	//startswith in css:
		//tag[attr^='value']
		//input[placeholder^='E-Mail'] -- css
		//input[starts-with(@placeholder,'E-Mail')]  -- xpath
		
	//endswith in css:
		//tag[attr$='value']
		//input[placeholder$='Address'] --- css
		//input[ends-with(@placeholder,'Address')]
		
	//parent-child:
		//select#Form_getForm_Country > option ---> direct child elements
		//select#Form_getForm_Country option  ----> direct + indirect child elements
		// form > div ---> 2 child divs which are directly associated 
		// form div ---> (direct+indirect child)
		// table#resultTable td
		
	//child to parent: backward traversing -- NA
	//child to ancestor : NA 
	//preceding-sibling : NA 
		
	//following-sibling : yes 
		//label[for='input-email'] + input (immediate following sibling)
		//label[for='input-email'] ~ input (All the following siblings)
		
	//indexing in css
		//select#Form_getForm_Country option:first-child
		//select#Form_getForm_Country option:last-child
		//select#Form_getForm_Country option:nth-child(5)
		//select#Form_getForm_Country option:nth-last-child(2)
		//select#Form_getForm_Country option:nth-child(odd)
		//select#Form_getForm_Country option:nth-child(even)
		//select#Form_getForm_Country option:nth-child(4n)
		
	//Not in CSS
		//form-control input-lg
		//form-control
		//input.form-control:not(.input-lg)
		//input.form-control:not(.input-lg):not(#input-password)
		
	//comma in css
		//input#username, button#loginBtn, span#checkbox-content-3, div.signup-link -- 4 imp elements
		By AllImpEles=By.cssSelector("input#username, button#loginBtn, span#checkbox-content-3, div.signup-link");
		if(driver.findElements(AllImpEles).size()==4) {
			System.out.println("imp eles present on the page....PASS");
			
		}
		else {
			System.out.println("imp not eles present on the page....FAIL");
		}
		
		
		
		
		
	
		
		
	}

}
