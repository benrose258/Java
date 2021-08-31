package exbook4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinTree<E extends Comparable<E>> {
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

	BinTree() {
		root = null;
	}

	BinTree(E data) {
		root = new Node<E>(data);
	}

	BinTree(E data, BinTree<E> leftTree, BinTree<E> rightTree) {
		root = new Node<E>(data,leftTree.root,rightTree.root);
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

	public int noOfNodes() {
		return noOfNodes(root);
	}

	private int noOfNodes(Node<E> root) {
		if (root == null) {
			return 0;
		}
		return 1 + noOfNodes(root.right) + noOfNodes(root.left);
	}

	public int sumT() {
		return sumT(root);
	}

	private int sumT(Node<E> root) {
		if (root == null) {
			return 0;
		} else {
			return (int) root.data + sumT(root.right) + sumT(root.left);
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node<E> root) {
		if (root == null) {
			return true;
		} else {
			if (root.left == null && root.right == null) {
				return true;
			} else if (root.left == null) {
				return (int) root.data < (int) root.right.data && isBST(root.right);
			} else if (root.right == null) {
				return (int) root.data > (int) root.left.data && isBST(root.left);
			} else {
				return (int) root.data > (int) root.left.data && (int) root.data < (int) root.right.data && isBST(root.left) && isBST(root.right);
			}
		}
	}

	public boolean isLeaf() {
		if (root == null) {
			return false;
		} else {
			return root.left == null && root.right == null;
		}
	}

	public int noOfLeaves() {
		return noOfLeaves(root);
	}

	private int noOfLeaves(Node<E> root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
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
		} else if (root.left == null && root.right == null) {
			return true;
		} else if (root.left != null && root.right != null) {
			return isFull(root.left) && isFull(root.right);
		} else {
			return false;
		}
	}

	public boolean isPerfect() {
		if (isEmpty()) {
			return true;
		} else {
			return noOfNodes() == Math.pow(2, height()) - 1;
		}
	}

	public BinTree<E> copy() {
		if (isEmpty()) {
			return new BinTree<E>();
		} else {
			BinTree<E> copy = new BinTree<E>();
			copy.root = new Node<E>(root.data, root.left, root.right);
			return copy;
		}
	}

	public BinTree<E> mirror() {
		return mirror(root);
	}

	private BinTree<E> mirror(Node<E> root) {
		if (root == null) {
			return new BinTree<E>();
		} else {
			return new BinTree<E>(root.data, mirror(root.right), mirror(root.left));
		}
	}

	/*
	 * tree of height 3
	 * prune(3) keeps
	 */
	public void prune(int level) {
		if (level == 0) {
			root = null;
			return;
		} else {
			prune(level, root);
		}
	}

	private void prune(int level, Node<E> root) {
		if (root == null) {
			return;
		} else if (level == 1) {
			root.left = null;
			root.right = null;
			return;
		} else {
			level--;
			prune(level, root.left);
			prune(level, root.right);
		}
	}

	public boolean isBalanced() {
		if (root == null) {
			return true;
		} else {
			int heightDif = height(root.left) - height(root.right);
			return heightDif == -1 || heightDif == 0 || heightDif == 1;
		}
	}

	public ArrayList<E> ancestors(E item) {
		return ancestors(item, root, new ArrayList<E>());
	}

	private ArrayList<E> ancestors(E item, Node<E> root, ArrayList<E> result) {
		if (root == null) {
			throw new NoSuchElementException("The provided item does not exist in the tree.");
		} else if (root.data.compareTo(item) == 0) {
			return result;
		} else {
			result.add(root.data);
			if (root.data.compareTo(item)<0) { // root.data < item, go right
				return ancestors(item,root.right,result);
			} else { // root.data > item, go left
				return ancestors(item,root.left,result);
			}
		}
	}

	public ArrayList<E> bfs() {
		if (root == null) {
			return new ArrayList<E>();
		} else {
			return bfs(root, new ArrayList<E>());
		}
	}

	private ArrayList<E> bfs(Node<E> root, ArrayList<E> allLevels) {
		return null; // TODO
	}

	public static void main(String[] args) {
		BinTree<Integer> emptyT = new BinTree<Integer>();

		BinTree<Integer> t1 = new BinTree<Integer>(16, new BinTree<Integer>(8), new BinTree<Integer>(32));
		BinTree<Integer> t2 = new BinTree<Integer>(256, new BinTree<Integer>(128), new BinTree<Integer>(512));
		BinTree<Integer> t = new BinTree<Integer>(64, t1, t2);

		System.out.println(t);

		System.out.println(t.ancestors(8));

	}

}
