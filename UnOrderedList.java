package CustomDataStruc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.Dj.Utlility.*;

public class UnOrderedList {

	public static void main(String[] args) {

		//	linked list to store strings in the file
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		String[] strings;	//	strings array 
		BufferedReader bufferedReader = null;	//	buffered reader to read from file
		try {
			FileReader fileReader = new FileReader("/home/user/Desktop/Dj.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while((line = bufferedReader.readLine()) != null) {
				line = line.replaceAll("\\.", "");	//	removes all the dots from the file
				strings = line.split(" ");	//	converts line to string array
				for(String s: strings) {	//	adds array elements to the list
					myLinkedList.add(s);
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
		
		myLinkedList.list();	//	prints list elements
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter a word to search: ");
		String search = scanner.next();	//	word to be searched
		scanner.close();
		int pos;	//	position of the word in the file
		
		if((pos = myLinkedList.index(search)) == -1) {	//	not in the file
			System.out.println("This word is not in the file. Adding it to the file.");
			myLinkedList.add(search);
		}
		else {	//	word found
			System.out.println("Word is at " + pos + ". Removing it from file10.");
			myLinkedList.remove(search);
		}
		try {	//	writes list to the file
			int size = myLinkedList.size();
			PrintWriter printWriter = new PrintWriter("/home/user/Desktop/Dj.txt");
			for(int i = 0; i < size; i++) {
				String st = myLinkedList.pop(0);
				printWriter.write(st + " ");
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
