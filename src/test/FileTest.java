// **********************************************************
// Assignment2:
// Student 1:
// UTORID: REDACTED
// UT Student #: REDACTED
// Author: REDACTED
//
// Student 2:
/// UTORID: REDACTED
// UT Student #: REDACTED
// Author: REDACTED
//
// Student 3:
// Utorid :REDACTED
// UT Student #: REDACTED
// Author : REDACTED
//
// Student 4:
// Utorid :REDACTED
// UT Student #: REDACTED
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

package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import a2.File;
import a2.IFile;

public class FileTest {

  /**
   * Setting up the instance variables
   */
  public IFile file;

  @Before
  public void setUp() throws Exception {
    file = new File("InitialName", "Initial Contents");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testName() {
    // Checking whethet the name of the File is registered correctly
    String actual = file.getName();
    String expected = "InitialName";
    assertEquals(expected, actual);
  }

  @Test
  public void testSetContent() {
    // Checking whether the contents are added correctly using getContent
    file.setContent("Overidden data");
    String actual = file.getContent();
    String expected = "Overidden data\n";
    assertEquals(expected, actual);
  }

  @Test
  public void testAppendContent() {
    // Checking whether content has been added correctly into the File
    file.appendContent("New Content Added!");
    String actual = file.getContent();
    String expected = "Initial Contents\n" + "New Content Added!\n";
    assertEquals(expected, actual);
  }

}
