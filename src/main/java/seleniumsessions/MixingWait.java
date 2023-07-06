package seleniumsessions;

public class MixingWait {

	public static void main(String[] args) {
		//imp wait = 10 secs -- for all the elements
		//webdriverwait = 15 secs -- for username  field 
		
		//username : 
		//implicitly wait: 	10 secs --->  2 secs ---> total time taken to find the element is 2 secs
		//WDwait: 			15 secs --->  5 secs ---> 5 secs 
		//total : 2+5 = 7 secs 
		
		//imp: 		10 secs ---> 9 secs ---> 9 secs 
		//WDwait:	15 secs ---> 14 secs ---> 14 secs
		//total: 9+14 = 23 secs 
		
		//imp: 		10 secs ---> 10 secs ---> 10 secs 
		//WDwait:	15 secs ---> 14 secs ---> 14 secs
		//total: 9+14 = 24 secs
		
		//imp: 		10 secs ---> 10 secs ---> 10 secs 
		//WDwait:	15 secs ---> 15 secs ---> 15 secs
		//total: 10+15 = 25 secs
		

	}
 
}
