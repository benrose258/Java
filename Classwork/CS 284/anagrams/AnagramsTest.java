package anagrams;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

/**
 * CS 284 Section B
 * Homework 6
 * 
 * I pledge my honor that I have abided by the Stevens Honor System. -Ben Rose
 * 
 * @author Ben Rose
 *
 */

public class AnagramsTest {
	
	@Test
	// Checks entries in letter table to see if it was indeed built.
	// Also inadvertently tests the constructor, as the constructor calls buildLetterTable
	public void buildLetterTableTest() {
		Anagrams a = new Anagrams();
		assertEquals("Something is wrong.","2",a.letterTable.get('a').toString());
		assertEquals("Something is wrong.","3",a.letterTable.get('b').toString());
		assertEquals("Something is wrong.","5",a.letterTable.get('c').toString());
		assertEquals("Something is wrong.","7",a.letterTable.get('d').toString());
		assertEquals("Something is wrong.","11",a.letterTable.get('e').toString());
		assertEquals("Something is wrong.","13",a.letterTable.get('f').toString());
		assertEquals("Something is wrong.","17",a.letterTable.get('g').toString());
		assertEquals("Something is wrong.","19",a.letterTable.get('h').toString());
		assertEquals("Something is wrong.","23",a.letterTable.get('i').toString());
		assertEquals("Something is wrong.","29",a.letterTable.get('j').toString());
		assertEquals("Something is wrong.","31",a.letterTable.get('k').toString());
		assertEquals("Something is wrong.","37",a.letterTable.get('l').toString());
		assertEquals("Something is wrong.","41",a.letterTable.get('m').toString());
		assertEquals("Something is wrong.","43",a.letterTable.get('n').toString());
		assertEquals("Something is wrong.","47",a.letterTable.get('o').toString());
		assertEquals("Something is wrong.","53",a.letterTable.get('p').toString());
		assertEquals("Something is wrong.","59",a.letterTable.get('q').toString());
		assertEquals("Something is wrong.","61",a.letterTable.get('r').toString());
		assertEquals("Something is wrong.","67",a.letterTable.get('s').toString());
		assertEquals("Something is wrong.","71",a.letterTable.get('t').toString());
		assertEquals("Something is wrong.","73",a.letterTable.get('u').toString());
		assertEquals("Something is wrong.","79",a.letterTable.get('v').toString());
		assertEquals("Something is wrong.","83",a.letterTable.get('w').toString());
		assertEquals("Something is wrong.","89",a.letterTable.get('x').toString());
		assertEquals("Something is wrong.","97",a.letterTable.get('y').toString());
		assertEquals("Something is wrong.","101",a.letterTable.get('z').toString());
	}
	
	@Test
	// Tests myHashCode.
	public void myHashCodeTest() {
		Anagrams a = new Anagrams();
		assertEquals("Something is wrong.", "30", a.myHashCode("abc").toString());
	}
	
	@Test
	// Tests addWord.
	public void addWordTest() {
		Anagrams a = new Anagrams();
		assertEquals("Something is wrong.", false, a.anagramTable.containsKey(a.myHashCode("a")));
		a.addWord("a");
		assertEquals("Something is wrong.", true, a.anagramTable.containsKey(a.myHashCode("a")));
	}
	
	@Test
	// Tests getMaxEntries.
	public void getMaxEntriesTest() {
		Anagrams a = new Anagrams();
		a.addWord("ava");
		a.addWord("aav");
		a.addWord("vaa");
		assertEquals("Something is wrong.", 1, a.getMaxEntries().size());
		a.addWord("baa");
		a.addWord("aba");
		assertEquals("Something is wrong.", 1, a.getMaxEntries().size());
		a.addWord("aab");
		assertEquals("Something is wrong.", 2, a.getMaxEntries().size());
		assertEquals("Something is wrong.", "ava", a.getMaxEntries().get(0).getValue().get(0));
		assertEquals("Something is wrong.", "baa", a.getMaxEntries().get(1).getValue().get(0));
	}

}