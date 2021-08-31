package exbook3;

import java.util.Arrays;

public class ArrayList<E> {

	// Default capacity
	public static final int INITIAL_CAPACITY = 5;

	// The underlying data array
	private E[] data;

	// Current size
	private int size = 0;

	// Current capacity
	private int capacity = 0;

	// Constructor
	public ArrayList() {
		capacity = INITIAL_CAPACITY;
		data = (E[]) new Object[capacity];
	}

	// Adds entry newEntry to the end of the array
	public boolean add(E newEntry) {
		if (size == capacity) {
			reallocate();
		}
		data[size] = newEntry;
		size++;
		return true;
	}

	// Adds entry "newEntry" at given index
	public void add(int index, E newEntry) {
		// Check bounds for index
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " is out of bounds!");
		}
		// Check if array can currently contain another entry
		if (size >= capacity) {
			reallocate();
		}
		// Shift data to make room for newEntry
		for (int i=size; i > index; i--) {
			data[i] = data[i-1];
		}
		// Insert newEntry
		data[index] = newEntry;
		size++;
	}

	// Makes space in arrays
	private void reallocate() {
		capacity *= 2;
		data = Arrays.copyOf(data, capacity);
	}

	// Accesses the array's entry at index "index"
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " is out of bounds!");
		}
		return data[index];
	}

	// Sets the entry at index "index" to newEntry
	public E set(int index, E newEntry) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " is out of bounds!");
		}
		E oldEntry = data[index];
		data[index] = newEntry;
		return oldEntry;
	}

	// Removes an item from the array, updates array, then returns what was removed
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " is out of bounds!");
		}
		E removedEntry = data[index];

		for (int i = index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		size--;
		return removedEntry;
	}

	public E removeFirst() {
		return remove(0);
	}

	// Exercise 1
	public static boolean isSingleton(ArrayList myList) {
		return myList.size == 1;
	}

	// Exercise 2
	public static boolean allEven(ArrayList<Integer> myList) {
		for (int i=0; i<myList.size; i++) {
			if (myList.get(i) % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	// Exercise 3
	public static Integer sumL(ArrayList<Integer> myList) {
		int result = 0;
		for (int i=0; i < myList.size; i++) {
			result += myList.get(i);
		}
		return result;
	}

	// Exercise 4
	public static boolean nonDuplicates(ArrayList<Integer> myList) {
		if (myList.size <= 1) {
			return true;
		}
		ArrayList<Integer> temp = myList;
		int head = temp.remove(0);
		for (int i=0; i < temp.size; i++) {
			if (head == temp.get(i)) {
				return false;
			}
		}
		return nonDuplicates(temp);
	}

	// Exercise 5


	private void reallocate() {
		capacity *= 2;
		data = Arrays.copyOf(data, capacity);
	}

// Exercise 6
	public static ArrayList<Integer> append(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> finalList = list1;
		for (int i = 0; i<list2.size; i++) {
			finalList.add(list2.get(i));
		}
		return finalList;
	}

	// Exercise 7
	public static ArrayList<Integer> reverse(ArrayList<Integer> myList) {
		ArrayList<Integer> revList = myList;
		for (int i = myList.size - 1; i >= 0; i--) {
			revList.add(myList.get(i));
		}

		for (int i = 0; i < myList.size; i++) {
			revList.removeFirst();
		}
		return revList;
	}


	@Override
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String finalString = "";
		for (int i = 0; i < size-1; i++) {
			finalString = finalString + data[i]+", ";
		}
		finalString = "[" + finalString + data[size-1] + "]";
		return finalString;
	}

	public static void main(String[] args) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(15);
		numList.add(12);
		numList.add(13);
		numList.add(9);
		numList.add(2);
		numList.add(5);
		numList.add(444);
		System.out.println(numList);
		System.out.println(isSingleton(numList));
		System.out.println(allEven(numList));
		System.out.println(sumL(numList));
		System.out.println(nonDuplicates(numList));
		System.out.println(copyL(numList));
		System.out.println(reverse(numList));
		ArrayList<Integer> numList2 = new ArrayList<Integer>();
		numList2.add(10);
		numList2.add(100);
		System.out.println(append(numList,numList2));
	}
}
