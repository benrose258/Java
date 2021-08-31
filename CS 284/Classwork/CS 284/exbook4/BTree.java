package exbook4;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Ben Rose
 */

public class BTree<E extends Comparable<E>> {
	protected class Node<E> {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data, Node<E> left, Node<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public Node(E data) {
			this.data = data;
		}
	}

	protected Node<E> root;
	protected boolean addReturn;
	protected boolean deleteReturn;

	BTree() {
		root = null;
	}

	BTree(E data) {
		root = new Node<E>(data);
	}

	BTree(Node<E> root) {
		this.root = root;
	}

	BTree(E data, BTree<E> leftTree, BTree<E> rightTree) {
		root = new Node<E>(data,leftTree.root,rightTree.root);
	}

	public int noOfNodes() {
		return noOfNodes(root);
	}

	private int noOfNodes(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + noOfNodes(root.left) + noOfNodes(root.right);
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}

	public int noOfLeaves() {
		return noOfLeaves(root);
	}

	private int noOfLeaves(Node<E> root) {
		if (root == null) {
			// If the tree was empty to begin with, the recursive call of the left or right
			// subtree is not a leaf; used in lieu of if root.left != null and root.right != null
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return noOfLeaves(root.left) + noOfLeaves(root.right);
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int sumT() {
		return sumT(root);
	}

	private int sumT(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return (int) root.data + sumT(root.left) + sumT(root.right);
		}
	}

	public E findMax() {
		if (root == null) {
			throw new NoSuchElementException("There is no maximum in an empty tree!");
		} else {
			return findMax(root);
		}
	}

	private E findMax(Node<E> root) {
		if (root.right == null) {
			return root.data;
		} else {
			return findMax(root.right);
		}
	}

	public E findMin() {
		if (root == null) {
			throw new NoSuchElementException("There is no minimum in an empty tree!");
		} else {
			return findMin(root);
		}
	}

	private E findMin(Node<E> root) {
		if (root.left == null) {
			return root.data;
		} else {
			return findMin(root.left);
		}
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node<E> root) {
		if (root == null) {
			return true;
		} else if (root.left == null && root.right == null) {
			return true;
		} else if (root.left == null) {
			return root.data.compareTo(root.right.data) < 0 && isBST(root.right);
		} else if (root.right == null) {
			return root.data.compareTo(root.left.data) > 0 && isBST(root.left);
		} else {
			return root.data.compareTo(root.left.data) > 0 && root.data.compareTo(root.right.data) < 0 && isBST(root.left) && isBST(root.right);
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

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(Node<E> root) {
		if (root == null) {
			return true;
		} else if (root.right == null && root.left == null) { // At a leaf
			return true;
		} else if ((root.right == null) != (root.left == null)) { // If root.right and root.left are either both empty or both not empty
			return false;
		} else { // Neither are leaves
			return isFull(root.right) && isFull(root.left);
		}
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node<E> root) {
		if (root == null) {
			return true;
		} else if (Math.abs(height(root.left) - height(root.right)) <= 1) { // if the difference in height is at most 1
			return true;
		} else {
			return false;
		}
	}

	public boolean isPerfect() {
		return isFull() && noOfNodes() == Math.pow(2, height()) - 1;
	}

	public BTree<E> getLeftSubtree() {
		if (root == null) {
			throw new NoSuchElementException("The tree is empty.");
		} else {
			return buildTree(root.left);
		}
	}

	public BTree<E> getRightSubtree() {
		if (root == null) {
			throw new NoSuchElementException("The tree is empty.");
		} else {
			return buildTree(root.right);
		}
	}

	protected BTree<E> buildTree(Node<E> root) {
		if (root == null) {
			return new BTree<E>();
		} else {
			return new BTree<E>(root.data, buildTree(root.left), buildTree(root.right));
		}
	}

	public E getData() {
		if (root == null) {
			throw new NoSuchElementException("The tree is empty.");
		} else {
			return root.data;
		}
	}

	public boolean isLeaf() {
		if (root == null) {
			return false;
		} else {
			return root.right == null && root.left == null;
		}
	}

	public boolean add(E key) {
		root = add(root, key);
		return addReturn;
	}

	private Node<E> add(Node<E> root, E key) {
		if (root == null) {
			addReturn = true;
			return new Node<E>(key);
		} else {
			int comparison = root.data.compareTo(key);
			if (comparison == 0) { // If root.data == key
				addReturn = false;
				return root;
			} else if (comparison > 0) { // If root.data is greater than the key
				addReturn = true;
				root.left = add(root.left, key);
				return root;
			} else { // If root.data is less than the key
				addReturn = true;
				root.right = add(root.right,key);
				return root;
			}
		}
	}

	public void remove(E key) {
		root = remove(root, key);
	}

	private Node<E> remove(Node<E> root, E key) {
		if (root == null) {
			throw new NoSuchElementException("The key does not exist in the tree!");
		} else {
			int comparison = root.data.compareTo(key);
			if (comparison > 0) {
				root.left = remove(root.left, key);
			} else if (comparison < 0) {
				root.right = remove(root.right, key);
			} else { // key == root.data
				if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				} else { // Root has two children
					if (root.left.right == null) {
						root.data = root.left.data;
						root.left = root.left.left;
					} else {
						root.data = findRemoveMax(root.left);
					}
				}
			}
			return root;
		}
	}

	private E findRemoveMax(Node<E> root) {
		if (root.right.right == null) {
			E result = root.right.data;
			root.right = root.right.left;
			return result;
		} else {
			return findRemoveMax(root.right);
		}
	}

	/**
	 * Exercise Booklet
	 */

	public BTree<E> copy() {
		if (root == null) {
			return new BTree<E>();
		} else {
			return new BTree<E>(root);
		}
	}

	public BTree<E> mirror() {
		root = mirror(root);
		return this;
	}

	private Node<E> mirror(Node<E> root) {
		if (root == null) {
			return root;
		} else {
			Node<E> temp = root.right;
			root.right = root.left;
			root.left = temp;
			mirror(root.left);
			mirror(root.right);
			return root;
		}
	}

	public void prune(int level) {
		prune(root, level);
		return;
	}

	private void prune(Node<E> root, int level) {
		if (root == null) {
			return;
		} else if (level == 0) {
			root = null;
			return;
		} else if (level == 1) {
			root.left = null;
			root.right = null;
			return;
		} else {
			level--;
			prune(root.left, level);
			prune(root.right, level);
			return;
		}
	}

	public void add2(E key) {
		root = add2help(key);
	}

	private Node<E> add2help(E key) {
		if (root == null) {
			root = new Node<E>(key);
		} else {
			Node<E> current = root;
			boolean inserted = false;
			while (!inserted) {
				int comparison = current.data.compareTo(key);
				if (comparison == 0) {
					throw new IllegalArgumentException("Key already exists.");
				} else if (comparison > 0) {
					if (current.left==null) {
							current.left=new Node<E>(key);
							inserted=true;
						} else {
							current = current.left;
						}
				} else {
					if (current.right==null) {
						current.right=new Node<E>(key);
						inserted=true;
					} else {
						current = current.right;
					}
				}
			}
		}
		return root;
	}

	public String toString() {
		return toString(root,0);
	}

	private String toString(Node<E> n, int depth) {
		StringBuilder finalTree = new StringBuilder();
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

	public static void main(String[] args) {
		BTree<Integer> emptyT = new BTree<Integer>();

		BTree<String> stringBST = new BTree<String>("b", new BTree<String>("a"), new BTree<String>("c"));

		BTree<Integer> t1 = new BTree<Integer>(2, new BTree<Integer>(1), new BTree<Integer>(4));
		BTree<Integer> t2 = new BTree<Integer>(32, new BTree<Integer>(16), new BTree<Integer>(64));
		BTree<Integer> t = new BTree<Integer>(8, t1, t2);

		System.out.println(t);
		t.add2(12);
		System.out.println(t);
	}
}
