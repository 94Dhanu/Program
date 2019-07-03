

import java.io.File;
import java.util.Scanner;

public class TestOrderedList {

	static void addRemove(int num, OrderedLIst<Integer> list) {
		if (list.search(num)) {
			list.remove(num);
			System.out.println("Found and Removed");
			System.out.println(list);
		} else {
			list.add(num);
			System.out.println("Number not found hence Added");
			System.out.println(list);
		}
	}

	/**
	 * Main function to test the class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OrderedLIst<Integer> list = new OrderedLIst<>();
		Scanner s = new Scanner(System.in);
		System.out.println("How many no to enter");
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter " + i + " no");
			list.add(s.nextInt());
		}
		System.out.println("Enter no to search");
		int number = s.nextInt();
		addRemove(number, list);

	}
}
 class OrderedLIst<T extends Comparable<T>> {
	Node head;
	Node tail;
	int size = 0;

	/**
	 * function to add a new item in the list and returns nothing
	 * 
	 * @param data the item which to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(T data) {

		Node n = head;
		Node temp = new Node(data);
		size++;
		if (head == null) {
			// System.out.println("1st");
			head = temp;
			head.next = tail;
			tail = head;
		} else if (data.compareTo((T) head.data) < 0) {
			// System.out.println("2nd");
			temp.next = head;
			head = temp;
		} else {
			if (data.compareTo((T) tail.data) > 0) {
				tail.next = temp;
				tail = temp;
				return;
			}
			Node prev = null;
			while (data.compareTo((T) n.data) > 0 && n.next != null) {
				prev = n;
				n = n.next;
			}
			prev.next = temp;
			temp.next = n;
		}
	}
	public boolean search(T item) {
		Node n = head;
		while (n != null) {
			if (n.data.equals(item)) {
				return true;
			}
			n = n.next;
		}
		return false;
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
		} else if (tail.data.equals(item)) {
			while (!n.next.data.equals(tail.data)) {
				n = n.next;
			}
			n.next = null;
			tail = n;
			return;
		} else {
			while (!n.data.equals(item)) {
				prev = n;
				n = n.next;
			}
			n = n.next;
			prev.next = n;
			n = null;
			size -= 1;
		}
	}
}
 class Node {

		public Node(Object data) {
			super();
			this.data = data;
			this.next = null;
		}


		Object data;
		Node next;
	}

