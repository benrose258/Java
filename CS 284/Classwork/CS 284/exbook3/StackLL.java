package exbook3;

import java.util.EmptyStackException;

public class StackLL<E> implements StackInterface<E> {
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		private Node(E data) {
			this.data = data;
			this.next = next;
		}
		
		private Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> topmost;
	private int size;
	
	public StackLL() {
		this.topmost = null;
		this.size = 0;
	}
	
	public E push(E item) {
		this.topmost = new Node<E>(item, topmost);
		this.size++;
		return item;
	}
	
	public E pop() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			E result = this.topmost.data;
			this.topmost = this.topmost.next;
			this.size--;
			return result;
		}
	}
	
	public E peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return topmost.data;
		}
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public String toString() {
		if (this.size == 0) {
			return "[]";
		} else {
			StringBuilder finalString = new StringBuilder();
			Node<E> current = this.topmost;
			while (current.next != null) {
				finalString.append("["+current.data.toString()+"]");
				finalString.append("\n ^\n");
				current = current.next;
			}
			finalString.append("["+current.data.toString()+"]");
			return finalString.toString();
		}
	}
	
	// Exercise 1
	public boolean isSingleton() {
		return this.size == 1;
	}
	
	// Exercise 2
	public boolean allEven() {
		if (this.isEmpty()) {
			return true;
		} else {
			StackLL<Integer> temp = (StackLL<Integer>) this.copyL();
			while (temp.topmost != null) {
				if (temp.pop() % 2 != 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	// Exercise 3
	public Integer sumL() {
		int result = 0;
		StackLL<Integer> temp = (StackLL<Integer>) this.copyL();
		while (temp.topmost != null) {
			result = result + temp.pop();
		}
		return result;
	}
	
	// Exercise 4
	public boolean nonDuplicates() {
		if (size <= 1) {
			return true;
		} else {
			Node<E> current = this.topmost;
			Node<E> restOf = this.topmost.next;
			while (current.next.next != null) {
				while (restOf.next != null) {
					if (current.data == restOf.data) {
						return false;
					}
					restOf = restOf.next;
				}
				if (current.data == restOf.data) {
					return false;
				}
				current = current.next;
				restOf = current.next;
			}
			return current.data != restOf.data;
		}
	}
	
	// Exercise 5
	public StackLL<E> copyL() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			StackLL<E> backwards = new StackLL<E>();
			Node<E> current = this.topmost;
			while (current != null) {
				backwards.push(current.data);
				current = current.next;
			}
			StackLL<E> forwards = new StackLL<E>();
			while (!backwards.isEmpty()) {
				forwards.push(backwards.pop());
			}
			return forwards;
		}
	}
	
	// Exercise 6
	public StackLL<E> append(StackLL<E> stack2) {
		if (stack2.isEmpty()) {
			return this;
		}
		StackLL<E> copy = stack2.copyL(); // Used to preserve stack2 rather than destroy it
		copy.reverse();
		while (!copy.isEmpty()) {
			this.push(copy.pop());
		}
		return this;
	}
	
	// Exercise 7
	public StackLL<E> reverse() {
		StackLL<E> reversed = new StackLL<E>();
		while (!this.isEmpty()) {
			reversed.push(this.pop());
		}
		this.topmost = reversed.topmost;
		this.size = reversed.size;
		return this;
	}
	
	public static void main(String[] args) {
		StackLL<Integer> intStack = new StackLL<Integer>();
//		System.out.println(intStack.isEmpty());
		intStack.push(1);
//		System.out.println(intStack.isSingleton());
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		
		StackLL<Integer> intStack2 = new StackLL<Integer>();
		intStack2.push(5);
		intStack2.push(6);
		intStack2.push(7);
		intStack2.push(8);
//		System.out.println(intStack);
//		System.out.println(intStack.allEven());
//		System.out.println(intStack.sumL());
//		System.out.println(intStack.nonDuplicates());
//		System.out.println(intStack.copyL());
		intStack.append(intStack2);
//		System.out.println(intStack.reverse());
		System.out.println(intStack);
//		System.out.println(intStack2);
	}
}