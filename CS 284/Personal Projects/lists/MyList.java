package lists;

import java.util.Arrays;

class MyList<E> {
	// Data fields
	final static int INITIAL_CAPACITY=5;
	private E[] data;
	int size;
	int capacity; // Current capacity
	
	//Constructor
	MyList() {
		data = (E[]) new Object[INITIAL_CAPACITY];
		size=0;
		capacity=INITIAL_CAPACITY;
	}
	
	// Recursive function example

		public static double fib(double old, double current, int n) {
			if (n<=1) {
				return current;
			} else {
				return fib(current,old+current,n-1);
			}
		}
	
	// Methods
	private void enlarge_array() {
		capacity = capacity*2;
		data = Arrays.copyOf(data, capacity);
	}
	
	public boolean add(E item) {
	     if (size==data.length) {
	    	 	enlarge_array();
	     }
	     
	     data[size] = item;
	     size++;
	     return true;
	}
	
	public void add (int index, E item) {
		if (index<0 || index>size) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (size==data.length) {
			enlarge_array();
		}	
		
		for (int i=size; i>index; i--) {
			data[i]=data[i-1];
		}
		data[index]=item;
		size++;
	}
	
	public void remove(int index) {
	
		for (int i=index; i<size-1; i++) {
			data[i]=data[i+1];
		}
		size--;
		
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) {
		MyList<Integer> l = new MyList<Integer>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.remove(2);
		System.out.println(l);
	}
}