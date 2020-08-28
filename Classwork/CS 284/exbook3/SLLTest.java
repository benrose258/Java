package exbook3;

import static org.junit.Assert.*;

import org.junit.Test;

public class SLLTest {

	@Test
	public void ConstructorT1() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		assertEquals("You fucked up.","[]",test.toString());
	}
	
	@Test
	public void addT1() {
		SingleLinkedList<Integer> test = new SingleLinkedList<Integer>();
		test.add(15);
		assertEquals("Something is wrong.","[15]",test.toString());
		test.add(18);
		assertEquals("Something is wrong.","[15 ==> 18]",test.toString());
		test.reverse();
		assertEquals("Something is wrong.","[18 ==> 15]",test.toString());
	}

}
