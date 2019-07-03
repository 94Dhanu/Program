import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
class QuestionNumber
{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int range,count,lower,upper,middle;
	static String input;
	
	public  static void binarySearch(int lower,int upper,int middle,int count,String input,int n)
   	{
		QuestionNumber u=new QuestionNumber();
       	System.out.println("Is your number:"+middle);
		System.out.println();
		System.out.println("Enter your answer in 'yes' or 'high' or 'low'");
		input=u.inputString();
       	do
        {
            if (input.equals("high"))
            {
				lower= middle;
				count++;
            }
			else if (input.equals("yes"))
            {
				System.out.println("The number you thought was: "+middle);
				int no=count+1;
				System.out.println("It takes "+no+" times to find your exact number");
				break;
            }
			else if(input.equals("low"))
            {
				upper=middle;
				count++;
			}
            if(count<n)
            {
				middle=(lower+ upper+1)/2;
				System.out.println("Is your number "+middle+":");
				input=u.inputString();
			}
		}
		while(lower<=upper);
			if (count>n)
			{
				System.out.println("Number not found");
			}
			else
			{
				System.exit(0);
			}
		}

	//take input word
	public String inputString(){
		try{
			return br.readLine();
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return "";
	}

	//Take Integer Input
	public int inputInteger(){
		try{
			try{	
				return Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException nfe){
				System.out.println(nfe.getMessage());	
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
		return 0;
	}

	public static void main(String[] args)
    {
		try
		{
			QuestionNumber u=new QuestionNumber();
			System.out.println("Enter any Number:");
			int n=u.inputInteger();
			range=(int)(Math.pow(2,n-1));                //range calculation for the number
			System.out.println("Take number between '0' to "+range);
			count=0;
			input=null;
			lower=0;
			upper=range;
			middle=(lower+upper/2);
			QuestionNumber.binarySearch(lower,upper,middle,count,input,n);
		}
		catch (ArrayIndexOutOfBoundsException ae)
		{
			ae.printStackTrace();
		}
    }
 }
