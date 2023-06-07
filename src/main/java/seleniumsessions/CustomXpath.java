package seleniumsessions;

public class CustomXpath {

	public static void main(String[] args) {
	
	//parent to child:
	//parent/child: direct child 
		//select[@id='Form_getForm_Country']/option
	//parent//child: direct + indirect child 
	/*
	 * https://www.orangehrm.com/en/contact-sales/
	 */		
		//select[@id='Form_getForm_Country']
		//select[@id='Form_getForm_Country']//option
		
		//div[@class='footer-main']//a
		
	/*
	* //https://app.hubspot.com/login/beta
	*/		
		
		//form//input[@id='username']
		
	//child to Parent 
	/* backward traversing in xpath -- child/.. */
		
		//input[@id='username']/..  --- immediate parent 
		//input[@id='username']/parent::div
		
		
		//input[@id='username']/../../../../.. ----- keep on adding will reach the top of the HTML DOM 
		
		//GrandParent 
		//input[@id='username']/ancestor::form
		//input[@id='username']/ancestor::form/parent::div/..
		
		//parent 
		//option[contains(text(),'Country')]/parent::select

	}

}
