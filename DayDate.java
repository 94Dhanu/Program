import java.util.Scanner;

 class DayDate {
	
	
 /**
  *    main function to test the class
  */
	public static void main(String[] args) {
		int d, m, y;
		Scanner s = new Scanner(System.in);
		System.out.println("enter date in day month year");
		d = s.nextInt();
		m = s.nextInt();
		y = s.nextInt();
		System.out.println("day is "+Util.dayOfWeek(d, m, y));
		s.close();
		
	}
}

