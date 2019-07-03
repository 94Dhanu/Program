

import java.util.Scanner;

public class FlipCoin {

	int heads = 0; // heads count

	public static void main(String[] args) {

		FlipCoin flipCoin = new FlipCoin(); // class object
		flipCoin.start();
	}

	void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of flips:");
		int numberOfFlips = scanner.nextInt();	//	stores number of flips
		scanner.close();

		if (numberOfFlips < 1) {	//	negative number or 0
			System.out.println("Number must be greater than 0");
			start();
		}

		for (int i = 0; i < numberOfFlips; i++) {
			double randomValue = Math.random();
			if (randomValue < 0.5) {	//	tails
				System.out.print("Tails\t");
			} else {	//	it's heads, increases heads count
				System.out.print("Heads\t");
				heads++;
			}
		}

		//	prints heads and tails percentages
		System.out.println();
		System.out.println("Heads Percentage: " + (double) heads / numberOfFlips);
		System.out.println("Tails Percentage: " + ((double) numberOfFlips - heads) / numberOfFlips);

	}
}