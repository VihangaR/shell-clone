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
import a2.ICp;
import a2.IDirectory;
import a2.IFile;
import a2.Mv;

public class MvTest {
  /**
   * Declaring the mv that was implemented for the tests
   */
  public Mv move = new Mv();
  public ICp copy;

  @Before
  public void setUp() throws Exception {
    // Since move depends on cp, instantiated a mock Cp
    move = new Mv();
    copy = new MockCp();
    move.setDifferentCopy(copy);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testFiletoDir() {
    // given a File, move it to the destination file
    // need to only check whether the parent of the file does not contain File
    // anymore
    String[] cmdArgs =
        {"mv", "/ValidParentDirectory/ValidInitialFile", "SomeValidDirectory"};
    String actual = move.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);

    IDirectory Parent = copy.getParentSource();
    IFile Child = (IFile) copy.getInitialSource();
    assertFalse(Parent.containsFile(Child));
  }

  @Test
  public void testInsuffidientInput() {
    // checking whether mv outputs the following result since there were no
    // arguments given to move
    String[] cmdArgs = {"NotenoughArgs"};
    String actual = move.exec(cmdArgs);
    String expected = "Insufficient Arguments, refer man for usage\n";
    assertEquals(expected, actual);
  }

  @Test
  public void testDirtoDir() {
    // Checking the case when there are two valid directories
    String[] cmdArgs =
        {"mv", "/ValidParentDirectory/ValidInitialDir", "SomeValidDirectory"};
    String actual = move.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);

    IDirectory Parent = copy.getParentSource();
    IDirectory Child = (IDirectory) copy.getInitialSource();
    assertFalse(Parent.containsDirectory(Child));
  }

  @Test
  public void testDirtoFile() {
    String[] cmdArgs = {"mv", "/ParentDirectory/ValidInitialDir", "SomeFile"};
    String actual = move.exec(cmdArgs);
    String expected =
        "Invalid Operation: a directory cannot be copied to a file!\n";
    assertEquals(expected, actual);
  }

  @Test
  public void testFiletoFile() {
    // Checking the case when there are two valid files
    String[] cmdArgs =
        {"mv", "/ValidParentDirectory/ValidInitialFile", "SomeValidDirectory"};
    String actual = move.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);

    IDirectory Parent = copy.getParentSource();
    IFile Child = (IFile) copy.getInitialSource();
    assertFalse(Parent.containsFile(Child));
  }

}
