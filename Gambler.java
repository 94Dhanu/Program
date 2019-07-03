

import java.util.Scanner;

public class Gambler {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter stake, goal, trials: ");	
		
		int stake = scanner.nextInt();	//	stake
		int goal = scanner.nextInt();	//	goal of the user
		int trials = scanner.nextInt();	//	number of trials
		scanner.close();
		int wins = 0;	//	number of wins

		for(int i = 0; i < trials; i++){
			int tempStake = stake;	//	represents current stake of the gambler
			
			//	while gambler is not broke or has won
			while((tempStake > 0) && (tempStake < goal)){	
				stake--;
				double r = Math.random();
				if(r > 0.5){
					tempStake =tempStake + 2;
				}
			}
			if(tempStake == goal){	//	gambler has won
				wins++;	//	increasing win count
				System.out.println("Won");
			}
			else{	//	gambler lost
				System.out.println("Lost");
			}
		}
		double winningPercentage = (double) wins / trials;	//	winning percentage
		System.out.println("Number of wins: " + wins + 
			"\nWinning percentage: " + winningPercentage + "\nLosing percentage: "
			+ (1 - winningPercentage));
	}
}
