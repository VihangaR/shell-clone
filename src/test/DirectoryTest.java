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
import a2.Directory;
import a2.IDirectory;
import a2.File;
import a2.IFile;

public class DirectoryTest {
  public IDirectory directoryA;
  public IDirectory directoryB;
  public IFile fileA;
  @Before
  public void setUp() throws Exception {
    directoryA = new Directory("directoryA");
    directoryB = new Directory(directoryA, "directoryB");
    directoryA.addChild(directoryB);
    fileA = new File("fileA", "Sample Text");
    directoryA.addChildFile(fileA);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testName() {
    String actual = directoryA.getName();
    String expected = "directoryA";
    assertEquals(expected, actual);
  }
  @Test
  public void testGetDirectory() {    
    IDirectory actual = directoryA.getChild("directoryB");
    IDirectory expected = directoryB;
    assertEquals(expected, actual);
  }
  @Test
  public void testContainsDirectory() {    
    boolean actual = directoryA.containsDirectory(directoryB);
    boolean expected = true;
    assertEquals(expected, actual);
  }
  @Test
  public void testGetFile() {    
    IFile actual = directoryA.getChildFile("fileA");
    IFile expected = fileA;
    assertEquals(expected, actual);
  }
  @Test
  public void testGetPath() {
    String actual = directoryA.getPath();
    String expected = "/#/";
    assertEquals(expected, actual);
  }

}
