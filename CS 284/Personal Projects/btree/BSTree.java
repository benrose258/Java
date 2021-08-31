package btree;

public class BSTree<E extends Comparable<E>> extends BinTree<E>{ 
	// Constructors
	BSTree() {
		super();
	}
	BSTree(E data) {
		super(data);
	}
	BSTree(E data, BSTree<E> left, BSTree<E> right) {
		super(data,left,right);
	}
	
	// Methods
	private boolean find(E key, Node<E> n) {
		if (n==null) {
			return false;
		} else {
			int comparison = n.data.compareTo(key);
			if (comparison==0) { // n.data==key
				return true;
			}  else {
				if (comparison<0) {  // n.data<key
					return find(key,n.right);
				} else { // n.data>key
					return find(key,n.left);
				}
			}
		}
	}
	
	public boolean find(E key) {
		return find(key,root);
	}
  
	private Node<E> add(E key, Node<E> n) {
	  if (n==null) {
		  return new Node<E>(key);
	  } else {
		  int comparison=n.data.compareTo(key);
		  if (comparison==0) {
			  throw new IllegalArgumentException();
		  } else {
			  if (comparison<0) {
				  n.right=add(key,n.right);
				  return n;
			  } else {
				  n.left=add(key,n.left);
				  return n;
			  }
		  }
	  }
	}
	
	public void add(E key) {
		add(key,root);
	}
	
	public E max() {
		return max(root);
	}
	
	private E max(Node<E> root) {
		if (root == null) {
			throw new NullPointerException("The tree is empty.");
		} else {
			if (root.right == null) {
				return root.data;
			} else {
				return max(root.right);
			}
		}
	}
	
	/*
	 * Helper function needed to examine nodes one level up
	 */
	public E removeMax() {
		if (root == null) {
			throw new NullPointerException("The tree is empty.");
		} else {
			return removeMax(root);
		}
	}
	
	private E removeMax(Node<E> root) {
		if (root.right == null) {
			E temp = root.data;
			root = root.left;
			return temp;
		} else {
			if (root.right.right == null) {
				E temp = root.right.data;
				root.right = root.right.left;
				return temp;
			} else {
				return removeMax(root.right);
			}
		}
	}
		
	public static void main(String[] args) {
		BSTree<Integer> emptyT = new BSTree<Integer>();
		BSTree<Integer> t1 = new BSTree<Integer>(32,new BSTree<Integer>(),new BSTree<Integer>(35));
		BSTree<Integer> t2 = new BSTree<Integer>(55,new BSTree<Integer>(47),new BSTree<Integer>(74,new BSTree<Integer>(62),new BSTree<Integer>()));
		BSTree<Integer> t = new BSTree<Integer>(44,t1,t2);
		
		System.out.println(t);
//		System.out.println(t.find(74));
//		System.out.println(t.find(75));
		t.add(77);
		System.out.println(t);
		System.out.println(t.removeMax());
		System.out.println(t);
		System.out.println(t.removeMax());
		System.out.println(t);
//		System.out.println(t.mirror());
//		System.out.println(t.noOfNodes());
//		System.out.println(t.isLeaf());
//		System.out.println((new BSTree<Integer>(4)).isLeaf());
//		System.out.println(t.isFull());
	}
}
