package idLList;

/*
 * Name: Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

import java.util.ArrayList;

public class IDLList<E> {

	private static class Node<E> {
		// Data Fields
		private E data;
		private Node<E> next;
		private Node<E> prev;

		// Constructors
		private Node(E elem) {
			data = elem;
			prev = null;
			next = null;
		}

		private Node(E elem, Node<E> prev, Node<E> next) {
			data = elem;
			this.prev = prev;
			this.next = next;
		}
	}

	// Data Fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;

	// Constructor
	public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList(10);
	}
	// Create an exception case for if elem == null, and in IDLListTest
	public boolean add(int index, E elem) {
		if (elem == null) {
			throw new NullPointerException("You cannot add null to a list!");
		} else if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The index "+index+" is outside of the list bounds! Valid indices: "+0+" to "+(this.size)+".");
		} else {
			if (this.head == null) {
				this.head = new Node<E>(elem);
				this.tail = this.head;
				indices.add(0,this.head);
			} else if (index == 0) {
				this.head = new Node<E>(elem,null,this.head);
				this.head.next.prev = this.head;
				indices.add(0,this.head);
			} else if (index == size) {
				this.tail = new Node<E>(elem,this.tail,null);
				this.tail.prev.next = this.tail;
				indices.add(size,this.tail);
			} else {
				Node<E> temp = indices.get(index);
				temp = new Node<E>(elem,temp.prev,temp);
				temp.next.prev = temp;
				temp.prev.next = temp;
				indices.add(index,temp);
			}
			this.size++;
			return true;
		}
	}

	public boolean add(E elem) {
		return this.add(0,elem);
	}

	public boolean append(E elem) {
		return this.add(size,elem);
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index "+index+" is outside of the list bounds! Index: "+index+", Size: "+size);
		} else {
			return indices.get(index).data;
		}
	}

	public int size() {
		return this.size;
	}

	public E getHead() {
		return this.get(0);
	}

	public E getLast() {
		return this.get(this.size-1);
	}

	public E remove() {
		return this.removeAt(0);
	}

	public E removeLast() {
		return this.removeAt((this.size)-1);
	}

	public E removeAt(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index "+index+" is outside of the list bounds! Index: "+index+", Size: "+size);
		} else {
			Node<E> temp = indices.get(index);
			E result = temp.data;
			if (this.size == 1) {
				this.head = null;
				this.tail = null;
			} else if (this.size == 2) {
				if (temp == this.tail) {
					this.head.next = null;
					this.tail = this.head;
				} else {
					this.tail.prev = null;
					this.head = this.tail;
				}
			} else if (index == 0) {
				this.head = new Node<E>(temp.next.data,temp.prev,temp.next.next);
			} else if (temp == this.tail) {
				this.tail = temp.prev;
				this.tail.next = null;
				this.tail.prev.next = this.tail;
			} else {
				temp.prev.next = temp.next;
				temp = temp.prev;
			}
			indices.remove(index);
			this.size--;
			return result;
		}
	}

	public boolean remove(E elem) {
		int index = this.indexOf(elem);
		if (index == -1) {
			return false;
		} else {
			this.removeAt(index);
			return true;
		}
	}

	private Integer indexOf(E elem) {
		for (int i = 0; i<this.size; i++) {
			if (this.get(i) == elem) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder finalString = new StringBuilder("[");
			Node<E> current = this.head;
			while (current.next != null) {
				finalString.append(current.data.toString());
				finalString.append(" <=-=> ");
				current=current.next;
			}
			finalString.append(current.data.toString());
			finalString.append("]");
			return finalString.toString();
		}
	}

	public static void main(String[] args) {
		IDLList<Integer> idllT1 = new IDLList<Integer>();
		idllT1.add(1);
		idllT1.add(2);
		idllT1.add(3);
		idllT1.add(4);
		idllT1.add(5);

		IDLList<Integer> idllT2 = new IDLList<Integer>();
		idllT2.append(1);
		idllT2.append(2);
		idllT2.append(3);
		idllT2.append(4);
		idllT2.append(5);
		
		System.out.println(idllT2);

		IDLList<Integer> test = new IDLList<Integer>();
		test.add(1);
		System.out.println(test);
		test.remove(null);
		System.out.println(test);
	}

}
