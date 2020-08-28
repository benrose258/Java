package exbook4;

import exbook4.BTree.Node;

public class AVLTree<E extends Comparable<E>> extends BSTreeWithRotate<E> {

	private class AVLNode<E> extends Node<E> {
		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;

		private int balance;

		public AVLNode(E item) {
			super(item);
			balance = BALANCED;
		}

		@Override
		public String toString() {
			return balance + ": " + super.toString();
		}
	}

	private boolean increase; // Flag to indicate that the height of the tree has increased
	private boolean decrease; // Flag to indicate that the height of the tree has decreased

	@Override
	public boolean add(E item) {
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}

	private AVLNode<E> add(AVLNode<E> root, E item) {
		if (root == null) {
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		} else {
			int comparison = root.data.compareTo(item);
			if (comparison == 0) {
				addReturn = false;
				increase = false;
				return root;
			} else if (comparison < 0) {
				root.left = add((AVLNode<E>) root.left, item);
				if (increase) {
					root.balance--;
					if (root.balance == 0) {
						increase = false;
					}
					if (root.balance < AVLNode.LEFT_HEAVY) {
						increase = false;
//						rebalanceLeft(root);
					}
				}
				return root;
			} else {
				root.right = add((AVLNode<E>) root.right, item);
				if (increase) {
					root.balance++;
					if (root.balance == 0) {
						increase = false;
					}
					if (root.balance > AVLNode.RIGHT_HEAVY) {
//						rebalanceRight(root);
					} else {
						return root;
					}
				}
			}
		}
		return root;
	}

}
