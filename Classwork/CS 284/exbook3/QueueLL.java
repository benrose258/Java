package exbook3;

import java.util.*;

public class QueueLL<E extends Comparable<E>> {

	private class Node<E> {

		private E data;
		private Node<E> next;

		Node(E item) {
			this.data = item;
			this.next = null;
		}

		Node(E item, Node<E> next) {
			this.data = item;
			this.next = next;
		}
	}

	private Node<E> front;
	private Node<E> rear;
	private int size;

	QueueLL() {
		this.front=null;
		this.rear=null;
		this.size=0;
	}

	/**
	 * Returns entry at front of queue without removing it.
	 * If the queue is empty, throws NoSuchElementException.
	 */
	public E element() {
		if (this.size == 0) {
			throw new NoSuchElementException("You broke it.");
		} else {
			return this.front.data;
		}
	}

	/**
	 * Insert an item at the rear of a queue
	 * @param item
	 * @return true if insertion was successful, false otherwise
	 */
	public boolean offer(E item) {
		if (this.front == null) {
			this.front = new Node<E>(item);
			this.rear = this.front;
		} else {
			this.rear.next = new Node<E>(item);
			this.rear = this.rear.next;
		}
		this.size++;
		return true;
	}

	/**
	 * Removes an entry from the front of the
	 * queue if it is not empty. If the
	   queue is empty, throws NoSuchElementException
	 * @return Entry at front of the queue
	 */
	public E remove() {
		if (this.size == 0) {
			throw new NoSuchElementException("You broke it.");
		} else {
			E temp = front.data;
			this.front = this.front.next;
			if (this.front == null) { // queue is empty after removal
				this.rear = null;
			}
			size--;
			return temp;
		}
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Merges two queues and puts them in ascending order.
	 * Ex. Given <1,4,7> and <2,5,8>
	 * returns <1,2,4,5,7,8>.
	 * @return Sorted and merged queue
	 */
	public QueueLL<E> merge(QueueLL<E> q2) {
		QueueLL<E> result = new QueueLL<E>();
		while (!this.isEmpty() && !q2.isEmpty()) {
			if (this.element().compareTo(q2.element())<0) {
				result.offer(this.remove());
			} else {
				result.offer(q2.remove());
			}
		}
		if (!this.isEmpty()) {
			while (!this.isEmpty()) {
				result.offer(this.remove());
			}
		}
		if (!q2.isEmpty()) {
			while (!q2.isEmpty()) {
				result.offer(q2.remove());
			}
		}
		return result;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			//			return this.head.toString();
			StringBuilder finalString = new StringBuilder("<");
			Node<E> current = this.front;
			if (current != null) {
				while (current.next != null) {
					finalString.append(current.data.toString());
					finalString.append(" <== ");
					current=current.next;
				}
				finalString.append(current.data.toString());
			}
			finalString.append("<");
			return finalString.toString();
		}
	}

	// Exercise 5
	public QueueLL<E> copyL() {
		if (this.isEmpty()) {
			throw new NullPointerException("The queue is empty. You can't make a copy of nothing.");
		} else {
			QueueLL<E> copy = new QueueLL<E>();
			E copyVar = null;
			for (int i = 0; i < this.size; i++) {
				copyVar = this.remove();
				this.offer(copyVar);
				copy.offer(copyVar);
			}
			return copy;
		}
	}

	// Exercise 10
	public QueueLL<E> stutterNL(Integer n) {
		if (this.isEmpty()) {
			return null;
		} else {
			int itemsLeft = this.size;
			while (itemsLeft > 0) {
				for (int i = 0; i < n-1; i++) {
					this.offer(this.element());
				}
				this.offer(this.remove());
				itemsLeft--;
			}
			return this;
		}
	}

	public static void main(String[] args) {
		QueueLL<Integer> intQ = new QueueLL<Integer>();
		intQ.offer(1);
		intQ.offer(2);
		intQ.offer(3);
		intQ.offer(4);
		intQ.offer(5);

		System.out.println(intQ);
		System.out.println(intQ.stutterNL(3));
	}

}
