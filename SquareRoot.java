import java.util.Scanner;

class SquareRoot {
	
/**
 * Main method to test the class
 * @param args
 * @throws Exception if input is not integer
 */
	public static void main(String[] args) throws Exception {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("enter no to find square root");
			double c = s.nextDouble();
			System.out.println("square root is " + Util.sqrt(c));
			s.close();
		} catch (Exception e) {
			System.out.println("inter integer value "+e.getMessage());
		}

	}
}

