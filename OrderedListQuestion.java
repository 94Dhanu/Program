package CustomDataStruc;
import com.Dj.Utlility.*;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class OrderedListQuestion {

	public static void main(String[] args) {

		//	ordered list to store numbers
		MyOrderedList<Integer> orderedList = new MyOrderedList<Integer>();
		
		String[] strings;	//	string array to store numbers in each line
		//	buffered reader to read from the file
		BufferedReader bufferedReader = null;	
		try {
			FileReader fileReader = new FileReader("/home/user/Desktop/Dj.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line;	//	store line from file
			while((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("\\.", "");	//	removes dots in the file
				strings = line.split(" ");	//	puts words into the string array
				
				//	converts strings to integers and adds to the list 
				for(String integer: strings) {
					orderedList.add(Integer.parseInt(integer));
				}
			}			
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");		
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		orderedList.list();	//	prints the list elements
		
		//	scanner to get the user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int search = scanner.nextInt();	//	number to be searched in the file
		scanner.close();
		
		int pos;	//	index of the number in the list
		
		if((pos = orderedList.index(search)) == -1) {	//	number is not in the file
			System.out.println("This word is not in the file. Adding it to the list.");
			orderedList.add(search);
		}
		else {	//	number is in the file
			System.out.println("Word is at " + pos + ". Removing it from list.");
			orderedList.remove(search);
		}
		try {	//	writes the new list to the file
			int size = orderedList.size();	//	size of the list
			//	print writer to write in the file
			PrintWriter printWriter = new PrintWriter("/home/user/Desktop/Dj.txt");
			for(int i = 0; i < size; i++) {
				int integer = orderedList.pop(0);
				printWriter.write(integer + " ");
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
