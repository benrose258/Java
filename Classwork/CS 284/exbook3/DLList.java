package exbook3;

import java.util.NoSuchElementException;

public class DLList<E extends Comparable<E>> {

	private static class Node<E> {
		// Data Fields
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;

		// Constructors
		private Node(E dataItem) {
			data = dataItem;
		}

		private Node(E dataItem, Node<E> p, Node<E> n) {
			data = dataItem;
			prev = p;
			next = n;
		}
	}

	// The first element in the list
	private Node<E> head;

	// The last element in the list
	private Node<E> tail;

	// The size of the list
	private int size;

	DLList() {
		head = null;
		tail = null;
		size = 0;
	}

	DLList(Node<E> node) {
		DLList<E> finalList = new DLList<E>();
		Node<E> current = node;
		while (current.next != null) {
			finalList.add(current.data);
			current = current.next;
		}
		finalList.add(current.data);
		this.head = finalList.head;
		this.tail = finalList.tail;
		this.size = finalList.size;
	}

	private DLList<E> listBuilder(Node<E> node) {
		DLList<E> finalList = new DLList<E>();
		Node<E> current = node;
		while (current.next != null) {
			finalList.add(current.data);
			current = current.next;
		}
		finalList.add(current.data);
		return finalList;
	}

	// Node: item, previous, next
	public void add(E item) {
		if (size == 0) {
			this.tail = new Node<E>(item);
			this.head = this.tail;
		} else if (size == 1) {
			this.tail = new Node<E>(item,this.head,null);
			this.head.next = this.tail;
		} else {
			Node<E> temp = this.tail;
			this.tail = new Node<E>(item,temp,null);
			this.tail.prev.next = this.tail;
		}
		size++;
	}

	public void addFirst(E item) {
		if (size == 0) {
			this.head = new Node<E>(item);
			this.tail = this.head;
		} else if (size == 1) {
			this.head = new Node<E>(item,null,this.tail);
			this.tail.prev = this.head;
		} else {
			this.head = new Node<E>(item,null,this.head);
			this.head.prev = this.head;
		}
		this.size++;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder finalString = new StringBuilder("[");
			Node<E> current = this.head;
			if (current != null) {
				while (current.next != null) {
					finalString.append(current.data.toString());
					finalString.append(" <=-=> ");
					current=current.next;
				}
				finalString.append(current.data.toString());
			}
			finalString.append("]");
			return finalString.toString();
		}
	}

	public boolean notEmpty() {
		return this.head != null;
	}

	// Exercise 1
	public boolean isSingleton() {
		if (size == 1) {
			if (this.head != this.tail) {
				throw new IllegalArgumentException(/**Size == 1, but head and tail are not the same.
				When there is only one element, head==tail.*/);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	// Exercise 2
	public boolean allEven() {
		if (this.notEmpty()) {
			Node<Integer> current = (Node<Integer>) this.tail;
			while (current.prev != null) {
				if (current.data % 2 != 0) {
					return false;
				}
				current = current.prev;
			}
			return current.data % 2 == 0;
		}
		return true;
	}

	// Exercise 3
	public Integer sumL() {
		int result = 0;
		if (this.notEmpty()) {
			Node<Integer> current = (Node<Integer>) this.head;
			while (current.next != null) {
				result += current.data;
				current = current.next;
			}
			result += current.data;
		}
		return result;
	}

	// Exercise 4
	public boolean nonDuplicates() {
		if (size <= 1) {
			return true;
		} else {
			Node<E> current = this.head;
			Node<E> restOf = current.next;
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
			return current.data != current.next.data;
		}
	}

	// Exercise 5
	public Node<E> copyL() {
		if (this.notEmpty()) {
			DLList<E> copy = new DLList<E>();
			Node<E> current = this.head;
			while (current.next != null) {
				copy.add(current.data);
				current = current.next;
			}
			copy.add(current.data);
			return copy.head;
		} else {
			return null;
		}
	}

	// Exercise 6
	public Node<E> append(Node<E> n2) {
		if (!this.notEmpty()) {
			return new DLList(n2).head;
		} else if (n2 == null) {
			return this.head;
		} else {
			Node<E> current = n2;
			while (current.next != null) {
				this.add(current.data);
				current = current.next;
			}
			this.add(current.data);
			return this.head;
		}
	}

	// Exercise 7
	public boolean isEmpty() {
		return !this.notEmpty();
	}

	public Node<E> reverse() {
		if (this.isEmpty()) {
			return null;
		} else {
			DLList<E> result = new DLList<E>();
			Node<E> temp = this.tail;
			while (temp.prev != null) {
				result.add(temp.data);
				temp = temp.prev;
			}
			result.add(temp.data);
			return result.head;
		}
	}

	// Exercise 8
	public Node<Integer> doubleL() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The list is empty.");
		} else {
			Node<Integer> result = (Node<Integer>) this.head;
			while (result.next != null) {
				result.data *= 2;
				result = result.next;
			}
			result.data *= 2;
			return (Node<Integer>) this.head;
		}
	}

	// Exercise 9
	public Node<E> repeatLN(Integer n) {
		if (this.isEmpty() || n == 0) {
			return null;
		} else {
			DLList finalList = new DLList();
			for (int i = 0; i < n; i++) {
				Node<E> current = this.head;
				while (current.next != null) {
					finalList.add(current.data);
					current = current.next;
				}
				finalList.add(current.data);
			}
			return finalList.head;
		}
	}

	// Exercise 10
	public Node<E> stutterNL(Integer n) {
		if (this.isEmpty() || n == 0) {
			return null;
		} else {
			DLList finalList = new DLList();
			Node<E> current = this.head;
			while (current != null) {
				for (int i = 0; i < n; i++) {
					finalList.add(current.data);
				}
				if (current != null) {
					current = current.next;
				}
			}
			return finalList.head;
		}
	}

	public Node<E> stutterNL2(Integer n) {
		if (this.isEmpty() || n == 0) {
			return null;
		} else {
			Node<E> current = this.head;
			while (current != null) {
				for (int i = 0; i < n - 1; i++) {
					current.next = new Node<E>(current.data,current,current.next);
					current = current.next;
				}
				if (current != null) {
					current = current.next;
				}
			}
			this.size *= n;
			return this.head;
		}
	}

	// Exercise 11
	public Node<E> removeAdjacentDuplicates() {
		if (this.isEmpty()) {
			return null;
		} else if (this.isSingleton()) {
			return this.head;
		} else {
			Node<E> current = this.head;
			while (current.next.next != null) {
				if (current.data == current.next.data) {
					current.next = current.next.next;
					current.next.prev = current;
				} else {
					current = current.next;
				}
			}
			if (current.data == current.next.data) {
				current.next = null;
			}
			return this.head;
		}
	}

	private DLList<E> removeAll(E item) {
		if (this.isEmpty()) { // list is empty
			return this;
		}
		if (this.head.next == null) { // singleton list
			if (head.data.compareTo(item)==0) {
				this.head=null;
				this.tail=null;
				size=0;
			}
			return this;
		}
		Node<E> tempH = this.head;
		Node<E> tempT = this.tail;
		// list has two or more elements
		Node<E> current = this.head;
		Node<E> oldhead = head;

		// update head if first element was remove (same with tail)
		// Node: compareTo returns 0 if the elements are equal.
		while (current != null) {
			if (current.data.compareTo(item)!=0) { // leave current
				current = current.next;
			} else {  // remove current

				if (current.prev==null && current.next==null) {
					head=null;
					tail=null;
					current=null;
				} else
				if (current.prev==null) {
					head=current.next;
					current=current.next;
				} if (current.next==null) {
					tail=current.prev;
					tail.next=null;
					current=null;
				} else {
					 current.prev.next = current.next;
					 current = current.next;
				}
				this.size--;
			}
		}
		return this;
	}

		public Node<Integer> zipped(Node<Integer> n2) {
			if (this.size != new DLList(n2).size) { // This also checks if the list is empty because the input node's size is always >= 1
				throw new IndexOutOfBoundsException("Provided lists are of unequal length!");
			} else {
				Node<Integer> current = (Node<Integer>) this.head;
				while (current.next != null) {
					current.next = new Node<Integer>(n2.data,current,current.next);
					size++;
					current = current.next.next;
					n2 = n2.next;
				}
				current.next = new Node<Integer>(n2.data,current,null);
				return (Node<Integer>) this.head;
			}
		}

		public static void main(String[] args) {
			DLList<Integer> intList = new DLList<Integer>();
			intList.add(5);
			System.out.println(intList);
			System.out.println(intList.removeAll(5));
			System.out.println(intList);
		}

	}
