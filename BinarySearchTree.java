package CustomDataStruc;

import java.util.Scanner;

import com.Dj.Utlility.*;



public class BinarySearchTree {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Number of test cases: ");
		int n = scanner.nextInt();
		scanner.close();
		
		Utility utility = new Utility();
		
		//prints number of binary trees possible
		System.out.println("Number of binary trees possible: "
				+ utility.treeCount(n));
	}	
}

