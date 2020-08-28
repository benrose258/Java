package idLList;

/*
 * Name: Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IDLListComplexityTest {

	// Testing to see if the get function indeed worked as a constant time operation
	
	@Test
	public void test() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.append(i);
		}
		assertEquals("Something is wrong","9999",test.get(9999).toString());
	}

}