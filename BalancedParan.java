package CustomDataStruc;
import java.util.Scanner;

import com.Dj.Utlility.MyStack;

public class BalancedParan{

	public static void main(String[] args) {

		// stack object to store parentheses
		MyStack<Character> parenthesesSatck = new MyStack<Character>();
		// scanner to get user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter equation to check: ");

		String equation = scanner.nextLine(); // equation

		scanner.close();

		// equation in character array
		char[] equationCharcaterArray = equation.toCharArray();

		// pushes opening braces in stack and pops them out when closing braces occur
		for (char character : equationCharcaterArray) {
			if (character == '(') {
				parenthesesSatck.push(character);
			} else if (character == ')') {
				//	closing bracket before an opening bracket
				if (parenthesesSatck.isEmpty()) {
					System.out.println("Equation is balanced.");
					return;
				} else {
					parenthesesSatck.pop();
				}
			}
		}

		if (parenthesesSatck.isEmpty()) {	//	balanced equation
			System.out.println("Equation is balanced.");
		} else {
			System.out.println("Enquation is not balanced.");
		}
	}
}
