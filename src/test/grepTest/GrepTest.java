// **********************************************************
// Assignment2:
// Student 1:
// UTORID:ravich68
// UT Student #: 1004019420
// Author: Hamsavardhini Ravichandran
//
// Student 2:
/// UTORID: liuheng7
// UT Student #: 1004076493
// Author: Jessie Liu
//
// Student 3:
// Utorid :leanh8
// UT Student #: 1004381064
// Author : Anh Le
//
// Student 4:
// Utorid :ratnas16
// UT Student #: 1002394642
// Author : Vihanga Ratnasinghe
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Test;

import a2.Grep;
import test.MockFileManagerA;


class GrepTest {
	
	@Test
	void testGrepNoRecursionABgrepThis() {
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep", "This", "/A"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file a\nThis is file b\n";
		assertEquals(expected,actual);
	}
	
	@Test
	void testGrepNoRecursionBgrepThis()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep", "This", "/A/B"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\n";
		assertEquals(expected,actual);
	}
	
	@Test
	void testGrepRecursionAgrepThis()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep","-R", "b", "/A"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\nThis is file b\n";
		assertEquals(expected,actual);
		
	}
	@Test
	void testGrepRecursionABgrepThis()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep","-R", "This", "/A/B"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\n";
		assertEquals(expected,actual);
		
	}
	
	@Test
	void testGrepNoRecursionABgrepB() {
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep", "b", "/A"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\n";
		assertEquals(expected,actual);
	}
	
	@Test
	void testGrepNoRecursionBgrepB()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep", "b", "/A/B"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\n";
		assertEquals(expected,actual);
	}
	
	@Test
	void testGrepRecursionAgrepB()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep","-R", "b", "/A"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\nThis is file b\n";
		assertEquals(expected,actual);
		
	}
	@Test
	void testGrepRecursionABgrepB()
	{
		Grep testGrep = new Grep(new MockFileManagerA());
		String[] cmdVector = {"grep","-R", "b", "/A/B"};
		String actual = testGrep.exec(cmdVector);
		String expected = "This is file b\n";
		assertEquals(expected,actual);
		
	}


}
