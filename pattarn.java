import java.util.Scanner;

public class pattarn 
{

	public static void main(String arg[])
	{
		Scanner sobj=new Scanner(System.in);
		System.out.println("Enter pattarn no\n");
		int input=sobj.nextInt();
		pattarn1 patt=new pattarn1();
		patt.patternPrint(input);
		
	}
}
class pattarn1
{
	void patternPrint(int iRow)
	{
		int i,j,k;
		
		 for(i=1;i<=iRow;i++) 
			 
		 {
			 for(j=1;j<=(iRow-1);j++)
		
			 
			 { 
				 System.out.println("");
			 }
			 for(k=1;k<=(i*2)-1;k++)
			 {
				 System.out.println("*"); 
			 }
		 	}
		 }
		 
} 
		 
		