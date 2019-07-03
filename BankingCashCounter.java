package CustomDataStruc;
import com.Dj.Utlility.*;

import java.util.Scanner;

public class BankingCashCounter {

	static Scanner scanner = new Scanner(System.in);
	int balance = 0;	//balance
	MyQueue<Integer> people = new MyQueue<Integer>();
	
	public static void main(String[] args) {
		int choice = 0;	//choice
		
		BankingCashCounter counter = new BankingCashCounter();
		
		//prints menu
		do {
			System.out.println("1: Deposit");
			System.out.println("2: Withdraw");
			System.out.println("3: People ahead of you");
			System.out.println("4: Quit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			counter.action(choice);
		}while(choice != 4);
		
		if(counter.balance == 0) {
			System.out.println("Expression is balanced");
		}
		else {
			System.out.println("Expression is not balanced");
		}
	}

	void action(int choice) {
		int money;
		switch(choice) {
		case 1:
			//enqueue people and money to balance
			System.out.print("Enter amount to deposit: ");
			money = scanner.nextInt();
			people.enqueue(money);
			balance = balance+money;
			System.out.println();
			break;
		case 2:
			//enqueue people and remove money from balance
			System.out.print("Enter amount to withdraw: ");
			money = scanner.nextInt() * -1;
			people.enqueue(money);
			balance = balance +money;
			System.out.println();
			break;
		case 3:
			//displays number of people ahead of you
			System.out.println("\n" + (people.size() - 1) + " people ahead of you\n");
			break;
		default:			
		}
	}
}

