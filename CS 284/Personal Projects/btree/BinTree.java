package btree;

public class BinTree<E> {
	protected class Node<F> {
		protected F data;
		protected Node<F> left;
		protected Node<F> right;
		public Node(F data, Node<F> left, Node<F> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(F data) {
			super();
			this.data = data;
		}

	}
	// Data fields
	protected Node<E> root;
	// Constructors
	BinTree() {
		root=null;
	}
	BinTree(E data) {
		root = new Node<E>(data);
	}
	BinTree(E data, BinTree<E>leftTree, BinTree<E>rightTree) {
		root = new Node<E>(data,leftTree.root,rightTree.root);
	}

	private int height(Node<E> n) {
		if (n==null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}
	public int height() {
		return height(root);
	}

	private int noOfNodes(Node<E> n) {
		if (n==null) {
			return 0;
		} else {
			return 1 + noOfNodes(n.left)+noOfNodes(n.right);
		}
	}
	public int noOfNodes() {
		return noOfNodes(root);
	}

	public boolean isLeaf() {
		return root!=null && root.left==null && root.right==null;
	}

	private boolean isFull(Node<E> n) {
		if (n==null) {
			return true;
		} else {
			return isLeaf() || (n.left!=null && n.right!=null && isFull(n.left) && isFull(n.right)) ;
		}
	}

	public boolean isFull() {
		return isFull(root);
	}

	private String toString(Node<E> n, int depth) {
		StringBuilder r = new StringBuilder();
		for (int i=0;i<depth;i++) {
			r.append("--");
		}
		if (n==null) {
			r.append("null");
		} else {
			r.append(n.data.toString());
			r.append("\n");
			r.append(toString(n.left, depth+1));
			r.append("\n");
			r.append(toString(n.right, depth+1));
		}
		return r.toString();
	}

	// Exercise 8
	public int noOfLeaves() {
		return noOfLeaves(root);
	}
	private int noOfLeaves(Node<E> n) {
		if (n==null) {
			return 0;
		}
		if (n.left==null && n.right==null) {
			return 1;
		}
		return noOfLeaves(n.right) + noOfLeaves(n.left);
	}

	// Exercise 9
	public void prune(int level) {
		if (level>height(root)) {
			return;
		} else {
			prune(level,root);
		}
	}

	private void prune(int level, Node<E> n) {
		if (level == 0) {
			n.left = null;
			n.right = null;
			return;
		}
		if (n.left != null) {
			prune(level-1, n.left);
		}
		if (n.right != null) {
			prune(level-1, n.right);
		}
	}

	public String toString() {
		return toString(root,0);
	}

	public static void main(String[] args) {
		BinTree<Integer> t1 = new BinTree<Integer>(23,new BinTree<Integer>(12),new BinTree<Integer>(27));
		BinTree<Integer> t2 = new BinTree<Integer>(72,new BinTree<Integer>(43),new BinTree<Integer>());
		BinTree<Integer> t = new BinTree<Integer>(34,t1,t2);

		System.out.println(t);
		System.out.println(t.height());
		System.out.println(t.noOfNodes());
		System.out.println(t.isLeaf());
		System.out.println((new BinTree<Integer>(4)).isLeaf());
		System.out.println(t.isFull());
	}
}
