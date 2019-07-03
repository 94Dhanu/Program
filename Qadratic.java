

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.*; 
class Qadratic
{ 


	void findRoots(int a, int b, int c) 
	{ 

	if (a == 0) 
	{ 
		System.out.println("Invalid"); 
		return; 
	} 

	int d = b*b - 4*a*c; 
	double sqrt_val = sqrt(abs(d)); 

	if (d > 0) 
	{ 
		System.out.println("Roots are real and different \n"); 

		System.out.println((double)(-b + sqrt_val) / (2 * a) + "\n"
							+ (double)(-b - sqrt_val) / (2 * a)); 
	} 
	else 
	{ 
		System.out.println("Roots are complex \n"); 

		System.out.println( -(double)b / ( 2 * a ) + " + i"
						+ sqrt_val + "\n" + -(double)b / ( 2 * a ) 
						+ " - i" + sqrt_val); 
	} 
	} 


public static void main(String args[]) 
	{ 
	Qadratic qobj = new Qadratic(); 
	System.out.println("Enter values");
	Scanner sobj=new Scanner(System.in);
	int a=sobj.nextInt();
	int b=sobj.nextInt();
	int c=sobj.nextInt();
	qobj.findRoots(a, b, c); 
	} 
} 
 
