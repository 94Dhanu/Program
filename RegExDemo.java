package src.com.Dj.OOP;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	String firstName;	//	first name of the user
	String fullName;	//	last name
	String contactNumber;	//	contact number
	String date;	//	date
	//	standard message
	String message = "Hello <<name>>, We have your full " + 
			"name as <<full name>> in our system. \nYour "
			+ "contact number is 91-xxxxxxxxxx." + 
			" \nPlease,let us know in case of any" + 
			" clarification. \nThank you BridgeLabz 29/06/2019.";
	
	public static void main(String[] args) {
		
		RegExDemo demo = new RegExDemo();	//	class object
		demo.start();
	}

	/**
	 * calls required methods
	 */
	void start() {
		getUserInfo();	//	get user information
		replace("<<name>>", firstName);	//	replace first name
		replace("<<full name>>", fullName);	//	replace last name
		replace("xxxxxxxxxx", contactNumber);	// replace contact number
		replace("01/01/2016", date);	//	replace date
		System.out.println(message);	//	print updated message
	}
	
	
	/**
	 * asks user to provide information and stores in respective variables
	 */
	void getUserInfo() {
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter your first name: ");
		firstName = scanner.nextLine();
		System.out.print("Enter your full name: ");
		fullName = scanner.nextLine();
		System.out.print("Enter your contact number: ");
		contactNumber = scanner.nextLine();
		System.out.print("Enter date in dd/mm/yyyy format: ");
		date = scanner.nextLine();
		scanner.close();
	}
	
	
	/**
	 * @param stringToBeReplaced
	 * @param replacement
	 * replaces string 'stringToBeReplaced' in message with given 'replacement'
	 */
	void replace(String stringToBeReplaced , String replacement) {
		Pattern patrn = Pattern.compile(stringToBeReplaced);	//	pattern
		Matcher matc= patrn.matcher(message);	//	matcher
		message = matc.replaceFirst(replacement);
	}
}

