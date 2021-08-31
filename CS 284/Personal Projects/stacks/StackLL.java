package stacks;

import java.util.EmptyStackException;

public class StackLL<E> implements StackInt<E> {
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		private Node(E data) {
			this.data = data;
			this.next = null;
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
		this.topmost = new Node<E>(item,topmost);
		this.size++;
		return item;
	}
	
	public E pop() {
		if (this.empty()) {
			throw new EmptyStackException();
		} else {
			E result = this.topmost.data;
			this.topmost = this.topmost.next;
			this.size--;
			return result;
		}
	}
	
	public E peek() {
		if (this.empty()) {
			throw new EmptyStackException();
		} else {
			return topmost.data;
		}
	}
	
	public boolean empty() {
		return topmost == null;
	}
}
