package stacks;

import java.util.Arrays;

public class ArrayStack<E> implements StackInt<E> {
	private E[] data;
	int topOfStack = -1;
	private static final int INITIAL_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		data = (E[])new Object[INITIAL_CAPACITY];
	}
	
	public E push(E item) {
		if (topOfStack == data.length-1) {
			reallocate();
		}
		topOfStack++;
		data[topOfStack] = item;
		return item;
	}
	
	public E pop() {
		E temp = data[topOfStack];
		topOfStack--;
		return temp;
	}
	
	public E peek() {
		return data[topOfStack];
	}
	
	public boolean empty() {
		return topOfStack == -1;
	}

	private void reallocate() {
		data = Arrays.copyOf(data, data.length * 2);
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> intStack = new ArrayStack<Integer>();
		intStack.push(5);
		intStack.push(6);
		intStack.push(7);
		intStack.push(8);
		System.out.println(intStack.pop());
		System.out.println(intStack.peek());
		intStack.push(12);
		intStack.pop();
		intStack.pop();
		intStack.pop();
		intStack.pop();
		System.out.println(intStack.empty());
	}
}
