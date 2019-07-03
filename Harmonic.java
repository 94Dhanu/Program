
import java.io.*;
import java.util.Scanner; 

class Harmonic
{ 
	
 
static double nthHarmonic(int N) 
{ 
	
	float harmonic = 1; 

	
	for (int i = 2; i <= N; i++) { 
		harmonic = harmonic+(float)1 / i; 
	} 

	return harmonic; 
} 



	public static void main (String[] args) { 
			System.out.println("Enter Harmonic Number"); 
	Scanner sobj=new Scanner(System.in);
	int N=sobj.nextInt();
	System.out.print(nthHarmonic(N)); 
	
	} 
} 
