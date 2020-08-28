package queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueCL<E> {
	 // data fields
	private E[] data;
	private int front, rear;
	private int size;
	private int capacity;
	private static final int INITIAL_CAPACITY=10;

	// Constructor
	QueueCL(){
		data = (E[]) new Object[INITIAL_CAPACITY];
		capacity = INITIAL_CAPACITY;
		front=0;
		rear = capacity-1;
		size=0;
	}

	public E element() {
		if (size == 0) {
			throw new NoSuchElementException("The array is empty.");
		} else {
			return data[front];
		}
	}

	public E remove() {
		if (size==0) {
			throw new NoSuchElementException("The array is empty.");
		} else {
			E removedEntry = data[front];
			front = (front + 1)%capacity;
			size--;
			return removedEntry;
		}
	}

	private void reallocate() {
		QueueCL<E> result = new QueueCL<E>();
		result.capacity = this.capacity * 2;
		result.data[0] = this.data[this.front];
		result.front = 0;
		this.front = (this.front + 1) % this.capacity;
		for (int i = 1; i < this.size; i++) {
			result.data[i] = this.data[(i + this.front) % this.capacity];
		}
		result.rear = this.size - 1;
		result.size = this.size;
		data = result.data;
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		return Arrays.toString(data);
	}

	public static void main(String[] args) {
		QueueCL<Integer> q = new QueueCL<Integer>();
		for(int i = 0; i<10; i++) {

		}
	}
}
