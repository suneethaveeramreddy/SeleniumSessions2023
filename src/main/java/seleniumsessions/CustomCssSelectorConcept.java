package seleniumsessions;

import org.openqa.selenium.By;

public class CustomCssSelectorConcept {

	public static void main(String[] args) {
		
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
		
		
		
		
		
	
		
		
	}

}
