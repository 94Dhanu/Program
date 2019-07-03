import java.util.Scanner;

public class SimulateStopwatch {

	public static void main(String[] args) {

		//	class object
		SimulateStopwatch stopwatch = new SimulateStopwatch();
		stopwatch.calculateTime();
			
	}

	void calculateTime(){
		Scanner scanner = new Scanner(System.in);	
		long time1 = 0, time2 = 0;	//variables to store times of clicks
		
		System.out.println("Press the \"Enter\" the key twice two measure the time difference between them");
		
		String input = scanner.nextLine();	//stores user input
		
		if(input.isEmpty()) {	//	enter key pressed
			time1	= System.currentTimeMillis();
		}
		
		input = scanner.nextLine();
		if(input.isEmpty()) {	//	enter key pressed
			time2	= System.currentTimeMillis();
		}
		
		scanner.close();
		System.out.println("Diffrence between two clicks is: " + ((int)(time2 - time1) / 1000) + " seconds.");
	}
}
