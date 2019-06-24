package CustomDataStruc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;



public class FileReadUnordered {
	/*
	 * static void word(String s1 ,UnorderedList<String> list) {
	 * System.out.println(list.size()); if (list.search(s1)) { list.remove(s1);
	 * System.out.println(list); } }
	 */
	public static void main(String[] args) {

		/*
		 * try and catch block for checking for file related exceptions
		 */
		try {
		
			// creating a new file
			File f1 = new File("/home/user/Desktop/Dj.txt");
			UnorderedList<String> list = new UnorderedList<String>();
			Scanner sf = new Scanner(f1);
			Scanner s = new Scanner(System.in);
			// addind values from file to list
			while (sf.hasNext()) {
				list.add(sf.next());
			}
			// printing list
			System.out.println(list);
			/*
			 * writing to file using file writer
			 */
			FileWriter fw = new FileWriter(f1);
			System.out.println("Enter a word ");
			String s1 = s.nextLine();
			System.out.println(list.size());
			// checking if word is found and deleting it and then saving list to file
			if (list.search(s1)) {
				list.remove(s1);
				int n = 0;
				while (n < list.size()) {
					fw.write(list.pop(0) + " ");
					fw.flush();
					n++;
				}
				System.out.println("found and deleted");
				// or adding it to list and saving it to file
			} else {
				list.add(s1);
				int n = 0;
				while (n < list.size()) {
					fw.write(list.pop(0) + " ");
					fw.flush();
					n++;
				}
				System.out.println("added and saved");
				fw.close();
				s.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io excep");
		}
	}
	static class UnorderedList<T> {
		private Node head;
		Node tail;
		private int size = 0;

		@SuppressWarnings("Unchecked")

		/**
		 * function to add a new item in the list and returns nothing
		 * 
		 * @param data the item which to be added
		 */
		public void add(T data) {
			/*
			 * creates an new node with data traverse list till last adds the node as the
			 * last node
			 */
			Node n = new Node(data);
			if (head == null) {
				head = n;
				size++;
			} else {
				Node node = head;
				while (node.next != null) {
					node = node.next;
				}
				// adds the node as last node
				node.next = n;
				size++;
			}
		}

		/**
		 * Function to remove the item from the list
		 * 
		 * @param item
		 */
		public void remove(T item) {
			Node n = head;
			Node prev = null;
			if (head.data.equals(item)) {
				head = head.next;
				size -= 1;
				return;
			}
			while (!n.data.equals(item)) {
				prev = n;
				n = n.next;
			}
			n = n.next;
			prev.next = n;
			n = null;
			size -= 1;
		}

		public void removeAtLast() {
			Node n = head;
			Node prev = null;
			while (n.next != null) {
				prev = n;
				n = n.next;
			}
			System.out.println("Dhananjay");
			// remove the node as last node
			prev.next = null;
			size--;
		}

		/**
		 * function to search the item in the list
		 * 
		 * @param item the item to be searched
		 * @return true if found and false if not found
		 */
		public boolean search(T item) {
			Node n = head;
			while (n.next != null) {
				if (n.data.equals(item)) {
					return true;
				}
				n = n.next;
			}
			return false;
		}
		/**
		 * Funtion to check the size of list and return it
		 * 
		 * @return the size of the list
		 */
		public int size() {
			return size;
		}
		/**
		 * function to remove the item from the last of list and return it
		 * 
		 * @return the last element of list after removing
		 */
		/**
		 * Function to return the element at the given position
		 * 
		 * @param pos the index at which the item to return
		 * @return the element at the given index after removing it
		 */
		public T pop(int pos) {
			int index = 0;
			Node n = head;
			if (pos == 0) {
				head = head.next;
				size--;
				return (T) n.data;
			}
			Node prev = null;
			while (index != pos) {
				prev = n;
				n = n.next;
				index++;
			}
			prev.next = n.next;
			size -= 1;
			return (T) n.data;
		}
		public String toString() {
			StringBuffer s = new StringBuffer();
			s.append("[ ");
			Node node = head;
			while (node != null) {
				s.append(node.data);
				node = node.next;
				s.append(",");
			}
			s.append(" ]");
			return s.toString();
		}

		/**
		 * method to show the items in the list
		 */
		public void show() {
			System.out.println(toString());
		}

	}



		/**
		 * function to check if the list is empty or not
		 * 
		 * @return true if empty and false if not empty
		 */
		

}

