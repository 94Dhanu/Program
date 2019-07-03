import java.util.Scanner;

public class StringReplace {

	public static void main(String[] args) {
	

		StringReplace replace = new StringReplace();	//	class object
		replace.message();							
	}


	/**
	 * Asks for user name and prints a message
	 */
	void message(){
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username:");
        
        String username = scanner.next();	//	user name 
        scanner.close();
        
        if(username.length() < 3){	//	short username
        	System.out.println("Username is too short!!!");
			message();
		}
		else{	//	prints message with user name
			System.out.format("Hello %s,How are you?", username);
		}
	}
}
