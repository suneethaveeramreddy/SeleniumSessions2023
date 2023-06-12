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
		// tagname[attr1='value'][attr2='value']
		
	}

}
