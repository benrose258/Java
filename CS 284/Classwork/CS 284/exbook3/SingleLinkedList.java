package exbook3;

import java.util.NoSuchElementException;

public class SingleLinkedList<E> {

	private static class Node<E> {

	// Data Fields

		private E data;
		private Node<E> next;

	// Constructors

		Node(E data) {
			this.data=data;
			this.next=null;
		}

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

	// String converter for Node type

//		@Override
		/*
		 * Notes on StringBuilder:
		 * StringBuilder objects are like String objects,
		 * except they can be modified
		 *
		 * This toString method has additional steps to make
		 * the string cleaner, but are not necessary.
		 *
		 */
		public String toString() {
			StringBuilder finalString = new StringBuilder("[");
			Node<E> current = this;
			if (current != null) {
				while (current.next != null) {
					finalString.append(current.data.toString());
					finalString.append(" ==> ");
					current=current.next;
				}
				finalString.append(current.data.toString());
			}
			finalString.append("]");
			return finalString.toString();
		}

	}

	// Data Fields
	private Node<E> head;
	private int size;

	// Constructor
	SingleLinkedList() {
		head=null;
		size=0;
	}

	SingleLinkedList(Node<E> node) {
		head=node;
		size=getLength(node);
	}

	private void addFirst(E item) {
		this.head = new Node<E>(item, this.head);
		size++;
	}

	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		size++;
	}

	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if (temp == null) {
			return null;
		} else {
			node.next = temp.next;
			size--;
			return temp.data;
		}
	}

	private E removeFirst() {
		if (head == null) {
			throw new NullPointerException("The node is empty!");
		} else {
			Node<E> temp = head;
			head = temp.next;
			size--;
			return temp.data;
		}
	}

	private Node<E> getNode(int index) {
		Node<E> current = head;
		for (int i=0; i<index && current != null; i++) {
			current = current.next;
		}
		return current;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The provided index, "+index+" is outside of the list bounds!");
		}
		Node<E> node = getNode(index);
		return node.data;
	}

	public E set(int index, E newEntry) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The provided index, "+index+" is outside of the list bounds!");
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newEntry;
		return result;
	}

	public void add(int index, E item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}


	public boolean add(E item) {
		add(size, item);
		return true;
	}

	// The SingleLinkedList toString method just points to the Node
	// toString method, as to not write the same code twice or overcomplicate
	// printing Nodes.

	public String toString() {
		if (this.head == null) {
			return "[]";
		}
		return this.head.toString();
	}

	// Exercise 1
	public boolean isSingleton() {
		return size == 1;
	}

	// Exercise 2
	public static boolean allEven(SingleLinkedList<Integer> l) {
		if (l.head == null) {
			return true;
		} else {
			Node<Integer> current = l.head;
			for (int i = 0; i < l.size - 1; i++) {
				if (current.data % 2 != 0) {
					return false;
				}
				current = current.next;
			}
			if (current.data % 2 != 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	// Exercise 3
	public static Integer sumL(SingleLinkedList<Integer> l) {
		int result = 0;
		Node<Integer> current = l.head;
		for (int i = 0; i < l.size; i++) {
			result += current.data;
			current = current.next;
		}
		return result;
	}

	public static Integer sumL(Node<Integer> n) {
		if (n==null) {
			return 0;
		} else {
			return n.data + sumL(n.next);
		}
	}

	// Exercise 4
	public boolean nonDuplicates() {
		if (head == null || head.next == null) {
			return true;
		} else {
			Node<E> temp = head;
			Node<E> restOf = head.next;
			while (temp.next != null) {
				for (int i = 0; i < size; i++) {
					if (temp.data == restOf.data) {
						return false;
					}
				}
				temp = temp.next;
				restOf = restOf.next;
			}
			return true;
		}
	}
	// Exercise 5

	public Node<E> copyL() {
		if (this.head.next == null) {
			return new Node<E>(this.head.data);
		} else {
			E temp = this.head.data;
			this.head = this.head.next;
			return new Node<E>(temp,this.copyL());
		}
	}

	// Exercise 6
	private SingleLinkedList<E> next() {
		this.head = this.head.next;
		size--;
		return this;
	}

	private Node<E> append(Node<E> l1, Node<E> l2) {
		if (this.head.next == null) {
			this.head.next = l2;
			this.head = l1;
			this.size = getLength(l1);
			return this.head;
		} else {
			return this.next().append(l1,l2);
		}
	}

	public Node<E> append(Node<E> n2) {
		return this.append(this.head,n2);
	}

	public Integer getLength(Node<E> node) {
		int i = 0;
		Node<E> current = node;
		while (current != null) {
			i++;
			current = current.next;
		}
		return i;
	}

	// Exercise 7

	public Node<E> reverse() {
		if (head == null || head.next == null) {
			return head;
		} else {
			Node<E> current = head;
			Node<E> result = head;
			for (int i = getLength(head) - 1; i >= 0; i++) {
				result.add(current.data);
				current = current.next;
			}
		}
	}

	private E getLast() {
		if (this.head == null) {
			throw new NoSuchElementException("You broke it.");
		}
		Node<E> current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		return current.data;
	}

	private Node<E> removeLast() {
		this.head = this.removeLast(this.head);
		return this.head;
	}

	private Node<E> removeLast(Node<E> original) {
		if (this.head.next == null) {
			return original;
		}
		if (this.head.next.next == null) {
			this.head.next = null;
			this.size--;
			return original;
		} else {
			return this.next().removeLast(original);
		}
	}

	private Node<E> addVanced(E item) {
		this.append(new Node<E>(item));
		return this.head;
	}

	private Node<E> addVFirst(E item) {
		Node<E> temp = this.head;
		this.head = new Node<E>(item,temp);
		size++;
		return this.head;
	}

	private Node<E> lastToFirst() {
		E last = this.getLast();
		this.addVFirst(last);
		this.head = this.removeLast();
		return this.head;
	}

	public Node<E> reverse() {
		Node<E> current = this.head;
		Integer runs = this.size;
		while (current != null) {
			this.addVFirst(current.data);
			current = current.next;
		}

		for (int i = 0; i < runs; i++) {
			this.removeLast();
		}
		return this.head;
	}

	public Node<E> reverse2() {
		if (this.size <= 1) {
			return head;
		}
		Node<E> current = this.head;
		Node<E> previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		Node<E> result = current;
		current.next = previous;
		while (previous != current) {
			current = this.head;
			while (current != previous) {
				current = current.next;
			}
			previous.next = current;
			previous = this.head;
			if (previous == current) {
				break;
			}
			while (previous.next != current) {
				previous = previous.next;
			}
			current.next = previous;

		}
		this.head.next = null;
		return result;
	}

	// Exercise 8
	public static SingleLinkedList<Integer> doubleL(SingleLinkedList<Integer> l) {
		if (l.size == 0) {
			return l;
		} else {
			SingleLinkedList<Integer> result = l;
			Node<Integer> current = l.head;
			System.out.println(result);
			while (current != null) {
				current.data *= 2;
				result.add(current.data);
				current = current.next;
			}
			System.out.println(result);
			for (int i = 0; i < l.size; i++) {
				result.removeFirst();
			}
			return result;
		}
	}

	// Exercise 9

	public Node<E> repeatLN(Integer n) {
		if (this.head == null) {
			throw new NoSuchElementException("The list is empty.");
		}
		if (n == 0) {
			return null;
		} else {
			SingleLinkedList<E> curr = this;
			Node<E> current = curr.copyL();
			System.out.println(current.data);
			E test = current.data;
			for (int i = 0; i < n-1; i++) {
				this.append(current);
		}
			return this.head;
		}
	}

	// Exercise 11
	public Node<E> removeAdjacentDuplicates() {
		return this.removeAdjacentDuplicates(this.head);
	}

	private Node<E> removeAdjacentDuplicates(Node<E> original) {
		if (this.head.next == null) {
			this.head = original;
			return original;
		} else {
			if (this.head.data == this.head.next.data) {
				this.head.next = this.head.next.next;
				return this.removeAdjacentDuplicates(original);
			} else {
				return this.next().removeAdjacentDuplicates(original);
			}
		}
	}

	// Exercise 12
	public static Node<Integer> filterEven(SingleLinkedList<Integer> l) {
		if (l.head.data % 2 == 0) {
			if (l.isSingleton()) {
				return new Node<Integer>(l.head.data);
			} else {
				return new Node<Integer>(l.head.data,filterEven(l.next()));
			}
		} else {
			if (l.isSingleton()) {
				return null;
			} else {
				return filterEven(l.next());
			}
		}
	}

	// Exercise 13
	private static Node<Integer> singletonNodesZip(Integer first, Integer second) {
		Node<Integer> secondNode = new Node<Integer>(second);
		return new Node<Integer>(first,secondNode);
	}

	public static Node<Integer> zipL(Node<Integer> n1, Node<Integer> n2) {
		if (getSize(n1) != getSize(n2)) {
			throw new IndexOutOfBoundsException("Provided nodes are of unequal length!");
		}
		if (n1.next == null && n2.next == null) {
			return singletonNodesZip(n1.data,n2.data);
		} else {
			SingleLinkedList<Integer> zipped = new SingleLinkedList<Integer>();
			while (n1.next != null) {
				zipped.add(n1.data);
				zipped.add(n2.data);
				n1 = n1.next;
				n2 = n2.next;
			}
			zipped.add(n1.data);
			zipped.add(n2.data);
			return zipped.head;
		}
	}

	private static Integer getSize(Node<Integer> node) {
		int i = 0;
		Node<Integer> current = node;
		while (current != null) {
			i++;
			current = current.next;
		}
		return i;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> intList = new SingleLinkedList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(15);

		SingleLinkedList<Integer> intList2 = new SingleLinkedList<Integer>();
		intList2.add(6);
		intList2.add(7);
		intList2.add(8);
		intList2.add(9);
		intList2.add(10);

		SingleLinkedList<Integer> ex13first = new SingleLinkedList<Integer>();
		ex13first.add(1);
		ex13first.add(3);
		ex13first.add(5);

		SingleLinkedList<Integer> ex13second = new SingleLinkedList<Integer>();
		ex13second.add(2);
		ex13second.add(4);
		ex13second.add(6);

		Node<Integer> node122121 = new Node<Integer>(123);
		SingleLinkedList<Integer> nodeLTest = new SingleLinkedList<Integer>(node122121);

		intList.add(19);
		intList.add(19);
		intList.add(19);
		System.out.println(intList);
		System.out.println(intList.removeAdjacentDuplicates());

	}

}
