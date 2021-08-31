package idLList;

/*
 * Name: Ben Rose
 * CS 284 Section B
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class IDLListTest {

	@Test
	public void ConstructorT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		assertEquals("Constructor toString error","[]",test.toString());
	}

	@Test
	// addT1 tests add(elem)
	public void addT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.add(null);
			assert(false);
		} catch (NullPointerException e) {
			assert(true);
		}
		assertEquals("Something is wrong.",true,test.add(15));
		assertEquals("Something is wrong..","[15]",test.toString());
		assertEquals("Something is wrong.",true,test.add(18));
		assertEquals("Something is wrong.","[18 <=-=> 15]",test.toString());
		assertEquals("Something is wrong.",true,test.add(21));
		assertEquals("Something is wrong.","[21 <=-=> 18 <=-=> 15]",test.toString());
	}

	@Test
	public void addT2() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.add(0,null);
			assert(false);
		} catch (NullPointerException e) {
			assert(true);
		}

		try {
			test.add(123,null);
			assert(false);
		} catch (NullPointerException e) {
			assert(true);
		}

		try {
			test.add(123,456);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		assertEquals("Something is wrong.",true,test.add(0,15));
		assertEquals("Something is wrong..","[15]",test.toString());

		assertEquals("Something is wrong.",true,test.add(1,18));
		assertEquals("Something is wrong.","[15 <=-=> 18]",test.toString());

		assertEquals("Something is wrong.",true,test.add(0,12));
		assertEquals("Something is wrong.","[12 <=-=> 15 <=-=> 18]",test.toString());
	}

	@Test
	public void appendT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.append(null);
			assert(false);
		} catch (NullPointerException e) {
			assert(true);
		}
		assertEquals("Something is wrong.",true,test.append(15));
		assertEquals("Something is wrong..","[15]",test.toString());

		assertEquals("Something is wrong.",true,test.append(18));
		assertEquals("Something is wrong.","[15 <=-=> 18]",test.toString());

		assertEquals("Something is wrong.",true,test.append(21));
		assertEquals("Something is wrong.","[15 <=-=> 18 <=-=> 21]",test.toString());
		try {
			test.append(null);
			assert(false);
		} catch (NullPointerException e) {
			assert(true);
		}
		assertEquals("Something is wrong.","[15 <=-=> 18 <=-=> 21]",test.toString());
	}

	@Test
	public void getT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.get(0);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		assertEquals("Something is wrong.",true,test.append(15));
		assertEquals("Something is wrong.","[15]",test.toString());
		assertEquals("Something is wrong.","15",test.get(0).toString());
		assertEquals("Something is wrong.","[15]",test.toString());

		try {
			test.get(1);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		assertEquals("Something is wrong.","[15]",test.toString());
		assertEquals("Something is wrong.",true,test.append(18));
		assertEquals("Something is wrong.","[15 <=-=> 18]",test.toString());
		assertEquals("Something is wrong.","18",test.get(1).toString());

		assertEquals("Something is wrong.",true,test.append(21));
		assertEquals("Something is wrong.","[15 <=-=> 18 <=-=> 21]",test.toString());
		assertEquals("Something is wrong.","21",test.get(2).toString());

		assertEquals("Something is wrong.","18",test.get(1).toString());
		assertEquals("Something is wrong.","15",test.get(0).toString());
	}

	@Test
	public void getHeadT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.getHead();
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}
		test.append(15);
		assertEquals("Something is wrong.","15",test.getHead().toString());
		assertEquals("Something is wrong.","[15]",test.toString());
		test.append(18);
		assertEquals("Something is wrong.","15",test.getHead().toString());
		assertEquals("Something is wrong.","[15 <=-=> 18]",test.toString());
		test.append(21);
		assertEquals("Something is wrong.","15",test.getHead().toString());
		assertEquals("Something is wrong.","[15 <=-=> 18 <=-=> 21]",test.toString());
	}

	@Test
	public void getLastT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		try {
			test.getLast();
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}
		test.append(15);
		assertEquals("Something is wrong.","15",test.getLast().toString());
		test.append(18);
		test.append(21);
		assertEquals("Something is wrong.","21",test.getLast().toString());
	}

	@Test
	public void sizeT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		assertEquals("Something is wrong.","[]",test.toString());
		assertEquals("Something is wrong.",0,test.size());

		test.append(15);
		assertEquals("Something is wrong.","[15]",test.toString());
		assertEquals("Something is wrong.",1,test.size());

		test.append(18);
		assertEquals("Something is wrong.","[15 <=-=> 18]",test.toString());
		assertEquals("Something is wrong.",2,test.size());

		test.append(21);
		assertEquals("Something is wrong.","[15 <=-=> 18 <=-=> 21]",test.toString());
		assertEquals("Something is wrong.",3,test.size());
	}

	@Test
	public void removeLastT1() {
		IDLList<Integer> test = new IDLList<Integer>();
		assertEquals("Something is wrong.","[]",test.toString());
		try {
			test.removeLast();
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		test.append(15);
		assertEquals("Something is wrong.","[15]",test.toString());
		assertEquals("Something is wrong.",1,test.size());
		assertEquals("Something is wrong.","15",test.removeLast().toString());
		assertEquals("Something is wrong.","[]",test.toString());
		assertEquals("Something is wrong.",0,test.size());

		test.append(18);
		test.append(21);
		assertEquals("Something is wrong.","[18 <=-=> 21]",test.toString());
		assertEquals("Something is wrong.",2,test.size());

		assertEquals("Something is wrong.","21",test.removeLast().toString());
		assertEquals("Something is wrong.","[18]",test.toString());
		assertEquals("Something is wrong.",1,test.size());

		assertEquals("Something is wrong.","18",test.removeLast().toString());
		assertEquals("Something is wrong.","[]",test.toString());
		assertEquals("Something is wrong.",0,test.size());
	}

	@Test
	// removeT1 tests remove(elem)
	public void removeT1() {
		IDLList<String> test = new IDLList<String>();
		assertEquals("Something is wrong.",false,test.remove(""));
		assertEquals("Something is wrong.",false,test.remove(null));

		test.append("Hi");
		test.append("Hi");
		test.append("Hello");
		test.append("Salutations");
		assertEquals("Something is wrong.","[Hi <=-=> Hi <=-=> Hello <=-=> Salutations]",test.toString());

		assertEquals("Something is wrong.",false,test.remove("hi"));
		assertEquals("Something is wrong.","[Hi <=-=> Hi <=-=> Hello <=-=> Salutations]",test.toString());
		assertEquals("Something is wrong.",false,test.remove("H i"));
		assertEquals("Something is wrong.",false,test.remove("Hi "));
		assertEquals("Something is wrong.",false,test.remove(" Hi"));
		assertEquals("Something is wrong.","[Hi <=-=> Hi <=-=> Hello <=-=> Salutations]",test.toString());
		assertEquals("Something is wrong.",true,test.remove("Hi"));
		assertEquals("Something is wrong.","[Hi <=-=> Hello <=-=> Salutations]",test.toString());
		assertEquals("Something is wrong.",true,test.remove("Hi"));
		assertEquals("Something is wrong.","[Hello <=-=> Salutations]",test.toString());

		assertEquals("Something is wrong.",false,test.remove(" <=-=> "));
		assertEquals("Something is wrong.",false,test.remove("["));
		assertEquals("Something is wrong.",false,test.remove("]"));
		assertEquals("Something is wrong.",false,test.remove("Hello <=-=> Salutations"));
		assertEquals("Something is wrong.",false,test.remove("[Hello <=-=> Salutations]"));
		assertEquals("Something is wrong.","[Hello <=-=> Salutations]",test.toString());

		assertEquals("Something is wrong.",true,test.remove("Salutations"));
		assertEquals("Something is wrong.","[Hello]",test.toString());

		assertEquals("Something is wrong.",true,test.remove("Hello"));
		assertEquals("Something is wrong.","[]",test.toString());
		assertEquals("Something is wrong.",false,test.remove(null));
		assertEquals("Something is wrong.",false,test.remove("[]"));
		assertEquals("Something is wrong.","[]",test.toString());
	}

	@Test
	// removeT2 tests remove()
	public void removeT2() {
		IDLList<Double> test = new IDLList<Double>();
		try {
			test.remove();
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}
		test.append(1.23);
		test.append(4.56);
		test.append(7.89);
		assertEquals("Something is wrong.","1.23",test.remove().toString());
		assertEquals("Something is wrong.","[4.56 <=-=> 7.89]",test.toString());
		assertEquals("Something is wrong.","[4.56 <=-=> 7.89]",test.toString());
		assertEquals("Something is wrong.","4.56",test.remove().toString());
		assertEquals("Something is wrong.","[7.89]",test.toString());
		assertEquals("Something is wrong.","7.89",test.remove().toString());
		assertEquals("Something is wrong.","[]",test.toString());
	}

	@Test
	public void removeAtT1() {
		IDLList<String> test = new IDLList<String>();
		try {
			test.removeAt(0);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}
		test.append("Goodbye");
		assertEquals("Something is wrong.","Goodbye",test.removeAt(0).toString());
		assertEquals("Something is wrong.","[]",test.toString());
		test.append("Bye");
		test.append("See ya");
		test.append("Leave already");

		try {
			test.removeAt(3);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		try {
			test.removeAt(-1);
			assert(false);
		} catch (IndexOutOfBoundsException e) {
			assert(true);
		}

		assertEquals("Something is wrong.","[Bye <=-=> See ya <=-=> Leave already]",test.toString());
		assertEquals("Something is wrong.","See ya",test.removeAt(1).toString());
		assertEquals("Something is wrong.","[Bye <=-=> Leave already]",test.toString());

		assertEquals("Something is wrong.","Leave already",test.removeAt(1).toString());
		assertEquals("Something is wrong.","[Bye]",test.toString());

		assertEquals("Something is wrong.","Bye",test.removeAt(0).toString());
		assertEquals("Something is wrong.","[]",test.toString());
	}

	@Test
	public void toStringT1() {
		IDLList<String> test = new IDLList<String>();
		assertEquals("Empty IDLL toString failure","[]",test.toString());

		test.add("above.");
		assertEquals("Singleton IDLL toString failure.","[above.]",test.toString());

		test.add("works");
		assertEquals("Something is wrong.","[works <=-=> above.]",test.toString());

		test.add("this");
		assertEquals("Something is wrong.","[this <=-=> works <=-=> above.]",test.toString());

		test.add("proven");
		assertEquals("Something is wrong.","[proven <=-=> this <=-=> works <=-=> above.]",test.toString());

		test.add("much");
		assertEquals("Something is wrong.","[much <=-=> proven <=-=> this <=-=> works <=-=> above.]",test.toString());

		test.add("pretty");
		assertEquals("Something is wrong.","[pretty <=-=> much <=-=> proven <=-=> this <=-=> works <=-=> above.]",test.toString());

		test.add("I've");
		assertEquals("Something is wrong.","[I've <=-=> pretty <=-=> much <=-=> proven <=-=> this <=-=> works <=-=> above.]",test.toString());
	}

	/*
	 * Though the longest runtime among the two of these
	 * is 0.005s (as of about 10 tests), the runtime of append
	 * has never gone above half the runtime of add, leading
	 * me to believe that, though so inconsequential, adding
	 * at the tail of a list is twice as fast as adding at
	 * its head.
	 */

	/*
	 * The next five functions test whether the add, append, get, removeLast,
	 * remove(E elem), and size() are indeed using fast indexing. I would
	 * assume they aren't necessary, but I think that they are something that
	 * should be tested. Also the success of these functions should be based
	 * on their respective runtimes, as they have all been proven to pass
	 * above.
	 */

	@Test
	public void timeComplexityAppendGet() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.append(i);
		}
		assertEquals("Something is wrong","9999",test.get(9999).toString());
	}

	@Test
	public void timeComplexityAddGet() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.add(i);
		}
		assertEquals("Something is wrong","0",test.get(9999).toString());
	}

	@Test
	public void timeComplexityAppendRemoveLast() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.append(i);
		}
		assertEquals("Something is wrong","9999",test.removeLast().toString());
	}

	@Test
	public void timeComplexityAppendRemoveE() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.append(i);
		}
		assertEquals("Something is wrong",false,test.remove(10000));
	}

	@Test
	public void timeComplexityAppendSize() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.append(i);
		}
		assertEquals("Something is wrong",10000,test.size());
	}

	@Test
	public void AppendGetEfficiency() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.add(i, i);
		}
		assertEquals("Something is wrong","9999",test.get(9999).toString());
	}

	@Test
	public void AddGetEfficiency() {
		IDLList<Integer> test = new IDLList<Integer>();
		for (int i = 0; i < 10000; i++) {
			test.add(0,i);
		}
		assertEquals("Something is wrong","0",test.get(9999).toString());
	}

}
