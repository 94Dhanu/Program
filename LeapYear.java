import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {

		LeapYear leapYear = new LeapYear();	//	class object
		leapYear.test();
	}

	void test(){
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.println("Enter year to check: ");
		int year = scanner.nextInt();	//	year to be checked
		
		if((year / 1000) == 0){	//	year is not four digit
			System.out.println("Year should be in 4 digits!!!");
			test();
		}
		else{
			if((year % 4) == 0){	//	leap year
				System.out.println("Leap year");
			}
			else{	//	not a leap year
				System.out.println("Not a leap year");	
			}
		}
		
		scanner.close();

	}
}
