package CustomDataStruc;
import java.util.Scanner;
import com.Dj.Utlility.*;
public class PalindromeChecker{

	public static void main(String[] args) {

		// scanner to get user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string to check for palindrome: ");
		// string to be checked for palindrome
		String stringToCheck = scanner.next();
		scanner.close();

		// class object
		PalindromeChecker checker = new PalindromeChecker();

		if (checker.checkPalindrome(stringToCheck)) { // palindrome
			System.out.println("Given string is a palindrome...");
		} else { // not a palindrome
			System.out.println("Given string is not a palindrome...");
		}
	}

	/** checks if the string is palindrome **/
	boolean checkPalindrome(String stringToCheck) {
		// dequeue to store characters in the string
		MyDeque<Character> myDeque = new MyDeque<Character>();
		// character array to store characters
		char[] stringCharacterArray = stringToCheck.toCharArray();

		//	adds characters to the front of the deque
		for (char character : stringCharacterArray) {
			myDeque.addFront(character);
		}

		//	returns false if a character does not match
		for (char character : stringCharacterArray) {
			if (character != myDeque.removeFront()) {
				return false;
			}
		}
		return true;
	}
}
