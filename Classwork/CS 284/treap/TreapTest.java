package treap;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {

	@Test
	public void constructorT1() {
		Treap<Integer> test = new Treap<Integer>();
		assertEquals("Something is wrong.", "null", test.toString());
	}
	
	@Test
	public void constructorT2() {
		Treap<Integer> test = new Treap<Integer>(System.currentTimeMillis());
		assertEquals("Something is wrong.", "null", test.toString());
	}
	
	@Test
	public void addT1() {
		Treap<Integer> test = new Treap<Integer>();
		assertEquals("Something is wrong.", true, test.add(12));
		assertEquals("Something is wrong.", false, test.add(12));
	}
	
	@Test
	public void addT2() {
		Treap<Integer> test = new Treap<Integer>();
		assertEquals("Something is wrong.", true, test.add(12,15));
		assertEquals("Something is wrong.", false, test.add(12,22));
		assertEquals("Something is wrong.", true, test.add(4,94));
	}
	
	@Test
	public void findT1() {
		Treap<Integer> test = new Treap<Integer>();
		test.add(19);
		test.add(22);
		test.add(3);
		assertEquals("Something is wrong.", true, test.find(3));
		assertEquals("Something is wrong.", false, test.find(51));
		assertEquals("Something is wrong.", true, test.find(19));
	}
	
	@Test
	public void deleteT1() {
		fail("TODO");
	}
	
	@Test
	public void toStringT1() {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		assertEquals("Something is wrong.", "null",testTree.toString());
	}

}
