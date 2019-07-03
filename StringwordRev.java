
import java.util.*; 

class StringwordRev { 

static void revwords(String str) 
{ 
	Stack<Character> st=new Stack<Character>(); 

	for (int i = 0; i < str.length(); ++i)
	{ 
		if (str.charAt(i) != ' ') 
			st.push(str.charAt(i)); 
 
		else
		{ 
			while (st.empty() == false) { 
				System.out.print(st.pop()); 
				
			} 
			System.out.print(" "); 
		} 
	}  
	while (st.empty() == false) { 
		System.out.print(st.pop()); 
		
	} 
} 

public static void main(String[] args) 
{ 

System.out.println("Enter string\n");
Scanner sobj=new Scanner(System.in);
String str=sobj.nextLine();
revwords(str); 
} 
} 
