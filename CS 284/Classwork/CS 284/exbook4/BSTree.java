package exbook4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import queues.QueueLL;

public class BSTree<E extends Comparable<E>> {
	protected class Node<E> {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data, Node<E> left, Node<E> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(E data) {
			super();
			this.data = data;
		}
	}

	// Data fields
	protected Node<E> root;

	BSTree() {
		root = null;
	}

	BSTree(E data) {
		root = new Node<E>(data);
	}

	BSTree(E data, BSTree<E> leftTree, BSTree<E> rightTree) {
		root = new Node<E>(data,leftTree.root,rightTree.root);
	}

	BSTree(Node<E> root) {
		this.root = root;
	}

	private String toString(Node<E> n, int depth) {
		StringBuilder finalTree = new StringBuilder();
		// Adding indentation
		for (int i = 0; i<depth; i++) {
			finalTree.append("--");
		}
		if (n == null) {
			finalTree.append("null");
		} else {
			finalTree.append(n.data.toString());
			finalTree.append("\n");
			finalTree.append(toString(n.left, depth+1));
			finalTree.append("\n");
			finalTree.append(toString(n.right, depth+1));
		}
		return finalTree.toString();
	}

	public String toString() {
		return toString(root,0);
	}

	public boolean isLeaf() {
		return isLeaf(root);
	}

	private boolean isLeaf(Node<E> root) {
		if (root == null) {
			return false;
		}
		return root.left == null && root.right == null;
	}

	public int height() {
		return height(root);
	}

	private int height(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return 1+Math.max(height(root.right), height(root.left));
		}
	}

	public int noOfNodes() {
		return noOfNodes(root);
	}

	private int noOfNodes(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + noOfNodes(root.right) + noOfNodes(root.left);
		}
	}

	public int noOfLeaves() {
		return noOfLeaves(root);
	}

	private int noOfLeaves(Node<E> root) {
		if (root == null) {
			return 0;
		} else if (isLeaf(root)) {
			return 1;
		} else {
			return noOfLeaves(root.left) + noOfLeaves(root.right);
		}
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(Node<E> root) {
		if (root == null) {
			return true;
		} else if (!(root.left == null) == (root.right == null)) {
			return false;
		} else {
			return isFull(root.left) && isFull(root.right);
		}
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node<E> root) {
		if (root == null) {
			return true;
		} else if (Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.right) && isBalanced(root.left);
		}
	}

	public boolean isPerfect() {
		if (root == null) {
			return true;
		}
		return isFull() && noOfNodes() == Math.pow(2, height()) - 1;
	}

	public BSTree<E> copy() {
		BSTree<E> copy = new BSTree<E>();
		copy.root = root;
		return copy;
	}

	public BSTree<E> mirror() {
		root = mirror(root);
		return this;
	}

	private Node<E> mirror(Node<E> root) {
		if (root == null) {
			return root;
		}
		Node<E> temp = root.right;
		root.right = root.left;
		root.left = temp;
		root.right = mirror(root.right);
		root.left = mirror(root.left);
		return root;
	}

	public void add(E item) {
		root = add(item, root);
	}

	public Node<E> add(E item, Node<E> root) {
		if (root == null) {
			root = new Node<E>(item);
		} else {
			int comparison = root.data.compareTo(item);
			if (comparison > 0) {
				root.left = add(item, root.left);
			} else if (comparison < 0) {
				root.right = add(item, root.right);
			} else {
				throw new IllegalArgumentException("The item is already in the tree.");
			}
		}
		return root;
	}

	public ArrayList<E> ancestors(E key) {
		return ancestors(root, key, new ArrayList<E>());
	}

	private ArrayList<E> ancestors(Node<E> root, E key, ArrayList<E> result) {
		if (root == null) {
			throw new IllegalArgumentException("The key was not found in the tree!");
		} else {
			int comparison = root.data.compareTo(key);
			if (comparison == 0) {
				return result;
			} else {
				result.add(root.data);
				if (comparison < 0) {
					return ancestors(root.right, key, result);
				} else {
					return ancestors(root.left, key, result);
				}
			}
		}
	}

	public void prune(int level) {
		root = prune(root, level);
	}

	private Node<E> prune(Node<E> root, int level) {
		if (level == 0) {
			root = null;
			return root;
		} else if (root == null) {
			return root;
		} else {
			root.left = prune(root.left, level - 1);
			root.right = prune(root.right, level - 1);
			return root;
		}
	}

	public ArrayList<E> bfs() {
		ArrayList<E> result = new ArrayList<E>();
		QueueLL<Node<E>> items = new QueueLL<Node<E>>();
		items.offer(root);
		while (items.empty() == false) {
			Node<E> item = items.remove();
			if (!(item == null)) {
				result.add(item.data);
				items.offer(item.left);
				items.offer(item.right);
			}
		}
		return result;
	}

	public ArrayList<ArrayList<E>> bfs2() {
		ArrayList<ArrayList<E>> result = new ArrayList<ArrayList<E>>();
		QueueLL<Node<E>> items = new QueueLL<Node<E>>();
		items.offer(root);
		while (items.empty() == false) {
			ArrayList<E> subLevel = new ArrayList<E>();
			int size = items.size();
			for (int i = 0; i < size; i++) {
				Node<E> item = items.remove();
				if (item != null) {
					subLevel.add(item.data);
					items.offer(item.left);
					items.offer(item.right);
				}
			}
			if (subLevel.size() != 0) {
				result.add(subLevel);
			}
		}
		if (result.isEmpty()) {
			result.add(new ArrayList<E>());
		}
		return result;
	}

	public ArrayList<BSTree<E>> projectLevel(int level) {
		ArrayList<BSTree<E>> result = new ArrayList<BSTree<E>>();
		QueueLL<Node<E>> items = new QueueLL<Node<E>>();
		items.offer(root);
		while (level != 0) {
			int size = items.size();
			for (int i = 0; i < size; i++) {
				Node<E> item = items.remove();
				if (item != null) {
					items.offer(item.left);
					items.offer(item.right);
				}
			}
			level--;
		}
		while (!items.empty()) {
			result.add(new BSTree<E>(items.remove()));
		}
		return result;
	}

	public ArrayList<BSTree<E>> subTrees() {
		ArrayList<BSTree<E>> result = new ArrayList<BSTree<E>>();
		for (int i = 0; i < height(); i++) {
			result.addAll(projectLevel(i));
		}
		return result;
	}

	public void remove(E key) {
		root = remove(root, key);
	}

	private Node<E> remove(Node<E> root, E key) {
		if (root == null) {
			throw new NoSuchElementException("The key doesn't exist in the tree.");
		} else {
			int comparison = root.data.compareTo(key);
			if (comparison > 0) {
				root.left = remove(root.left, key);
			} else if (comparison < 0) {
				root.right = remove(root.right, key);
			} else {
				if (root.right == null) {
					return root.left;
				} else if (root.left == null) {
					return root.right;
				} else if (root.left.right == null) {
					root.data = root.left.data;
					root.left = root.left.left;
				} else {
					root.data = findRemoveMax(root.left);
				}
			}
		}
		return root;
	}

	private E findRemoveMax(Node<E> root) {
		if (root.right == null) {
			E temp = root.data;
			root = root.left;
			return temp;
		} else if (root.right.right == null) {
			E temp = root.right.data;
			root.right = root.right.left;
			return temp;
		} else {
			return findRemoveMax(root.right);
		}
	}

	public static void main(String[] args) {
		BSTree<Integer> emptyT = new BSTree<Integer>();

		BSTree<Integer> t1 = new BSTree<Integer>(2, new BSTree<Integer>(1), new BSTree<Integer>(4));
		BSTree<Integer> t2 = new BSTree<Integer>(32, new BSTree<Integer>(16), new BSTree<Integer>(64));

		BSTree<Integer> t3 = new BSTree<Integer>(20, t1, emptyT);
		BSTree<Integer> t4 = new BSTree<Integer>(15, emptyT, t2);
		BSTree<Integer> t5 = new BSTree<Integer>(17, t4, t3);

		BSTree<Integer> t = new BSTree<Integer>(8, t1, t2);

		System.out.println(t);
		System.out.println(t);
	}
}
