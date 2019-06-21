// Java program for implementation of Insertion Sort 
import java.util.*;
class InsertionSort { 
	/*Function to sort array using insertion sort*/
	void sort(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			int temp= arr[i]; 
			int j = i - 1; 

			/* Move elements of arr[0..i-1], that are 
			greater than key, to one position ahead 
			of their current position */
			while (j >= 0 && arr[j] > temp) { 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = temp; 
		} 
	} 

	/* A utility function to print array of size n*/
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 

		System.out.println(); 
	} 

	// main method 
	public static void main(String args[]) 
	{ 
		InsertionSort ob=new InsertionSort();
		int n;
		System.out.println("How many element in the Array");
		Scanner sobj=new Scanner(System.in);
		n=sobj.nextInt();
		int arr[]=new int[n];

		System.out.println("Enter element in the Array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sobj.nextInt();
		}

		ob.sort(arr); 
		System.out.println("Sorted array"); 
		ob.printArray(arr); 
	} 
}

