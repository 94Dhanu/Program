
import java.lang.*; 
import java.util.*; 
class Factor
{ 

	public static void primeFactors(int ino) 
	{ 
		int icnt=0,i,j;
		for(i=2;i<=ino/2;i++)
		{
			if(ino%i==0)
			{
				for(j=2;j<=i/2;j++)
				{	
					if(i%j==0)
					{
						icnt++;
					}
				
				}
				if(icnt==0)
				{
					System.out.println(i);
				}
				icnt=0;
			}
			
		}
		for(i=2;i<=ino/2;i++)
		{
			
		
			if(ino%i==0)
			{
			icnt++;
			
			}	
		}
		if(icnt==0)
		{
			System.out.println(ino);
		}

	} 

	public static void main (String[] args) 
	{ 
		System.out.println("Enter a Number");
		Scanner sobj=new Scanner(System.in);
		int input=sobj.nextInt(); 
		primeFactors(input); 
	} 
} 
