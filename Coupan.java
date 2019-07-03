import java.util.Random;
import java.util.*;
import java.lang.*;

public class Coupan 
{
	public static void main(String[] args) 
	{
		int count=0,i;
		int randomCount=0;
		System.out.println("Enter Coupen No");
		Scanner sobj=new Scanner(System.in);
		int no=sobj.nextInt();
		Random rand=new Random();
		int coupen[]=new int[no];
		System.out.println("Random Numers are:");
		for( i=0;i<no;i++)
		{
			int value=rand.nextInt(no);
			System.out.println(value);
			
			randomCount++;
			int k=-1;
			for(int j=0;j<=i;j++) 
			{
				if(coupen[j]==value)
				{
					break;
				}
				k++;
			}
		
			if(i==k)
			{
				
				coupen[count]=value;
				count++;
			}
			i=count;
		}
			System.out.println("Coupen are generated");
			for( i=0;i<count;i++) 
			{
				System.out.println(coupen[i]);
			}
			System.out.println(no);
			count++;
			System.out.println("Number of coupan are:"+count);
			System.out.println("Number of times random function call:"+randomCount);
}
	}
