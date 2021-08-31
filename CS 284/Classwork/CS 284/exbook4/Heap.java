package exbook4;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {

	private ArrayList<E> data;

	Heap() {
		this.data = new ArrayList<E>();
	}

	Heap(ArrayList<E> data) {
		this.data = data;
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public int size() {
		return data.size();
	}

	public E get(int index) {
		return this.data.get(index);
	}

	public E getMin() {
		if (isEmpty()) {
			throw new NullPointerException("The heap is empty!");
		} else {
			return get(0);
		}
	}

	public String toString() {
		return data.toString();
	}

}
