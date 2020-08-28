package exbook4;

public interface SearchTree<E extends Comparable<E>> {
	
	// returns false if the item already exists in the tree
	boolean add(E item);
	
	boolean contains(E item);
	
	// If not found, return null
	E find(E target);
}
