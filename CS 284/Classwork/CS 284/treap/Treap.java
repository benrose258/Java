package treap;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/*
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

public class Treap<E extends Comparable<E>> {

	private static class Node<E> {

		public E data; // key for the search
		public int priority; // random heap priority
		public Node<E> left;
		public Node<E> right;

		public Node(E data, int priority) {
			this.data = data;
			this.priority = priority;
			this.right = null;
			this.left = null;
		}

		public Node(E data, int priority, Node<E> left, Node<E> right) {
			this.data = data;
			this.priority = priority;
			this.left = left;
			this.right = right;
		}

		public Node<E> rotateRight() {
			Node<E> temp = this.left;
			try {
				this.left = this.left.right;
			} catch (NullPointerException e) {
				this.left = null;
			}
			temp.right = this;
			return temp;
		}

		public Node<E> rotateLeft() {
			Node<E> temp = this.right;
			try {
				this.right = this.right.left;
			} catch (NullPointerException e) {
				this.right = null;
			}
			temp.left = this;
			return temp;
		}
	}

	private Node<E> root;
	private Random priorityGenerator;
	private boolean success;

	public Treap() {
		root = null;
		priorityGenerator = new Random();
	}

	public Treap(long seed) {
		root = null;
		priorityGenerator = new Random(seed);
	}

	public boolean add(E key) {
		return add(key, priorityGenerator.nextInt(100));
	}

	public boolean add(E key, int priority) {
		if (root == null) {
			Node<E> toAdd = new Node<E>(key, priority);
			root = toAdd;
			return true;
		} else {
			Stack<Node<E>> trace = new Stack<Node<E>>();
			Node<E> current = root;
			boolean inserted = false;
			while (!inserted) {
				trace.push(current);
				int comparison = current.data.compareTo(key);
				if (comparison == 0) {
					return false;
				} else if (comparison > 0) {
					if (current.left==null) {
							current.left=new Node<E>(key, priority);
							trace.push(current.left);
							inserted=true;
						} else {
							current = current.left;
						}
				} else {
					if (current.right==null) {
						current.right=new Node<E>(key, priority);
						trace.push(current.right);
						inserted=true;
					} else {
						current = current.right;
					}
				}
			}
			reheap(trace);
		}
		return true;
	}

	/**
	 *
	 * @param trace: trace up to the inserted item
	 * @return
	 */

	private void reheap(Stack<Node<E>> trace) {
		if (trace.size() == 1) {
			return;
		} else if (trace.size() == 2) {
			Node<E> child = trace.pop();
			Node<E> parent = trace.pop();
			if (child.priority > parent.priority) {
				if (child.data.compareTo(parent.data) < 0) {
					parent = parent.rotateRight();
				} else {
					parent = parent.rotateLeft();
				}
			}
			root = parent;
		} else {
			Node<E> child = trace.pop();
			Node<E> parent = null;
			Node<E> grandparent = null;
			while (trace.size() > 1) {
				parent = trace.pop();
				grandparent = trace.pop();
				int comparison = 0;
				if (grandparent != null) {
					comparison = grandparent.data.compareTo(parent.data);
				}
				if (child.priority > parent.priority) {
					if (child.data.compareTo(parent.data) < 0) {
						parent = parent.rotateRight();
					} else {
						parent = parent.rotateLeft();
						child = parent.left;
					}
				} else if (child.priority < parent.priority) {
					return;
				} else {
					System.out.println("broken");
					System.out.println(parent.data+","+parent.priority);
					System.out.println(child.data+","+child.priority);
					System.out.println(grandparent.data+","+grandparent.priority);
					System.out.println("end broken");
					return;
				}
				if (comparison < 0) {
					grandparent.right = parent;
				} else if (comparison > 0) {
					grandparent.left = parent;
				}
				child = parent;
				parent = grandparent;
				try {
					grandparent = trace.pop();
				} catch (EmptyStackException e) {
					break;
				}
				trace.push(parent);
				trace.push(child);
			}
			if (child.priority > parent.priority) {
				if (child.data.compareTo(parent.data) < 0) {
					parent = parent.rotateRight();
				} else {
					parent = parent.rotateLeft();
				}
			}
			root = parent;
		}
		return;
	}

	public boolean delete(E key) {
		boolean found = find(key);
		if (found) {
			root = delete(root, key);
		}
		return found;
	}

	private Node<E> delete(Node<E> root, E key) {
		if (root == null) {
			return root;
		} else {
			int comparison = root.data.compareTo(key);
			if (comparison > 0) {
				root.left = delete(root.left, key);
			} else if (comparison < 0) {
				root.right = delete(root.right, key);
			} else { // key == root.data
				Node<E> current = root;
				while (!(current.left == null && current.right == null)) {
					if (current.right == null) { // rotate left
						current = current.rotateLeft();
					} else {
						current = current.rotateLeft();
					}
				}
			}
			return root;
		}
	}

	private E findDeleteMax(Node<E> root) {
		if (root.right.right == null) {
			E result = root.right.data;
			root.right = root.right.left;
			return result;
		} else {
			return findDeleteMax(root.right);
		}
	}

	public boolean find(E key) {
		return find(root, key);
	}

	private boolean find(Node<E> root, E key) {
		if (root == null) {
			return false;
		} else if (root.data.compareTo(key) == 0) {
			return true;
		} else if (root.data.compareTo(key) < 0) {
			return find(root.right, key);
		} else {
			return find(root.left, key);
		}
	}

	public void rotationRTest() {
		root = root.rotateRight();
		return;
	}

	public void rotationLTest() {
		root = root.rotateLeft();
		return;
	}

	public String toString() {
		return toString(root, 0);
	}

	private String toString(Node<E> root, int depth) {
		StringBuilder finalTreap = new StringBuilder();
		// Adding spaces
		for (int i = 0; i<depth; i++) {
			finalTreap.append("  ");
		}
		if (root == null) {
			finalTreap.append("null");
		} else {
			finalTreap.append("(key="+root.data.toString()+", priority="+root.priority+")");
			finalTreap.append("\n");
			depth++;
			finalTreap.append(toString(root.left, depth));
			finalTreap.append("\n");
			finalTreap.append(toString(root.right, depth));
		}
		return finalTreap.toString();
	}

	public static void main(String[] args) {

		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);

		System.out.println(testTree);
		System.out.println(testTree.delete(1));
		System.out.println(testTree);
	}
}
