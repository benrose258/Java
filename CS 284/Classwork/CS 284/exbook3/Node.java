package exbook3;

public class Node<AnyType> {

	// Data Fields

		private AnyType data;
		private Node<AnyType> next;

	// Constructors

		Node(AnyType data) {
			this.data=data;
			this.next=null;
		}

		Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}

	// Exercise 1

		private boolean isSingleton(AnyType node) {
			return this.next == null;
		}

		public static void main(String[] args) {
			Node<String> n1 = new Node<String>("1");
			System.out.println(isSingleton(n1));
		}

}
