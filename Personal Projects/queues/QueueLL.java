package queues;

import java.util.NoSuchElementException;

public class QueueLL<E> {

		public class Node<E> {
			// Data fields
			private E data;
			Node<E> next;
			//Constructor
			Node(E item) {
				data=item;
				next=null;
			}
			Node(E item,Node<E> next) {
				data=item;
				this.next=next;
			}
		}
		// Data fields
		Node<E> front;
		Node<E> rear;
		int size=0;

		// Constructor
		public QueueLL() {
			front=null;
			rear=null;
			size=0;
		}

		// Methods

		/**
		 * Returns entry at front of queue without removing it. If the
		   queue is empty, throws NoSuchElementException
		 * @return
		 */
		public E element() {
			if (size == 0) {
				throw new NoSuchElementException("You broke it.");
			} else {
				return front.data;
			}
		}

		/**
		 * Insert an item at the rear of a queue
		 * @param item
		 * @return true if insertion was successful, false otherwise
		 */
		public boolean offer(E item) {
			if (front == null) {
				front = new Node<E>(item);
				rear = front;
				size=1;
			} else {
				rear.next = new Node<E>(item);
				rear=rear.next;
				size++;
			}
			return true;
		}

		/**
		 * Removes an entry from the front of the
		 * queue if it is not empty. If the
		   queue is empty, throws NoSuchElementException
		 * @return Entry at front of the queue
		 */
		public E remove() {
			if (size == 0) {
				throw new NoSuchElementException("You broke it.");
			} else {
				E temp = front.data;
				front = front.next;
				if (front==null) { // queue is empty after removal
					rear = null;
				}
				size--;
				return temp;
			}
		}

		/**
		 * Returns the size of the queue
		 * @return
		 */
		public int size() {
			return size;
		}

		public boolean empty() {
			return front==null;
		}

		public String toString() {
			StringBuilder finalString = new StringBuilder();
			finalString.append("<");
			Node<E> current=front;
			while (current!=null) {
				finalString.append(","+current.data);
				current = current.next;
			}
			finalString.append(">");
			return finalString.toString();

		}

		public static void main(String[] args) {
			QueueLL<Integer> q = new QueueLL<Integer>();

			q.offer(1);
			q.offer(4);
			q.offer(7);

			QueueLL<Integer> q2 = new QueueLL<Integer>();

			q2.offer(2);
			q2.offer(5);
			q2.offer(8);

		}
}
