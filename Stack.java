package CustomDataStruc;

public class Stack<T> {
	/**
	 * the variable used to init capacity of stack array
	 */
	int capacity = 10;

	/**
	 * Array for storing values in stack with size same as capacity
	 */
	private Object[] stack = new Object[capacity];
	/**
	 * chech for index value of the object
	 */
	private int top = 0;

	/**
	 * function to push the values in stack
	 * 
	 * @param data the item which needs to push in stack
	 */
	public void push(T data) {
		// checks for cpapcity of array
		if (top == capacity) {
			expand();
		}
		// puts data in stack
		stack[top] = data;
		top++;
	}

	/**
	 * deletes and returns the value from stack
	 * 
	 * @return return the first value inserted or null if stack is empty
	 */
	public T pop() {
		if (isEmpty()) {
			System.err.println("cant pop , stack is empty");
			return null;
		} else {
			T data = (T) stack[--top];
			stack[top] = null;
			return data;
		}
	}

	/**
	 * returns the last value pushed in the stack without modifying it
	 * 
	 * @return the last value pushed
	 */
	public T peek() {
		return (T) stack[top];
	}

	/**
	 * Function to check if the stack is empty or not
	 * 
	 * @return true if empty ot false if not empty
	 */
	public boolean isEmpty() {
		return top == 0;
	}

	/**
	 * returns the size of the stack
	 * 
	 * @return
	 */
	public int size() {
		return top;
	}

	/**
	 * Function to expand the stack if capacity is reached
	 */
	private void expand() {
		Object[] newStack = new Object[capacity * 2];
		System.arraycopy(stack, 0, newStack, 0, top);
		capacity *= 2;
		stack = newStack;
	}

	/**
	 * Function to give elements in stack as string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i = 0; i < top; i++) {
			sb.append(stack[i]);
			sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}

}

