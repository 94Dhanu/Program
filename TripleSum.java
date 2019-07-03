import java.util.Scanner;
class TripleSum
{ 

static void findTriplets(int[] arr) 
{ 
	boolean value = true; 
	for (int i=0; i<arr.length-2; i++) 
	{ 
		for (int j=i+1; j<arr.length-1; j++) 
		{ 
			for (int k=j+1; k<arr.length; k++) 
			{ 
				if (arr[i]+arr[j]+arr[k] == 0) 
				{ 
					System.out.print("The Triple Sum is :-");
					System.out.print("\n");  
					System.out.print(arr[i]); 
					System.out.print(" "); 
					System.out.print(arr[j]); 
					System.out.print(" "); 
					System.out.print(arr[k]); 
					System.out.print("\n"); 
					value= true; 
				} 
			} 
		} 
	} 

 
	if (value== false) 
		System.out.println(" not exist "); 

} 


public static void main(String[] args) 
{
	
	System.out.println("Enter How many Elements in array:-");
	Scanner sobj=new Scanner(System.in);
	int input=sobj.nextInt();
	System.out.println("Enter Elements:-");
	
	
	int arr[]=new int[input];
	for(int i=0;i<arr.length;i++)
	{
	 arr[i]=sobj.nextInt();
	}
	findTriplets(arr); 
} 
} 

