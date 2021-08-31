package exbook3;

public interface StackInterface<E> {

	E push(E item);
	
	E peek();
	
	E pop();
	
	boolean isEmpty();
	
}
