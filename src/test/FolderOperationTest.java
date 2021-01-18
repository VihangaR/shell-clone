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
import a2.FolderOperation;
import a2.IDirectory;
import a2.IDirectoryItems;
import a2.IFileManager;
import a2.InValidSourceFolderException;
import a2.InvalidParentDestinationFolder;
import a2.InvalidParentSourceFolder;
import a2.SelfDirectoryException;


public class FolderOperationTest {
  /**
   * Setting up all the instance variables to the mock objects created
   */
  private IFileManager FileSystem;
  private FolderOperation Operate;

  @Before
  public void setUp() throws Exception {
    FileSystem = new MockFileSystem1();
    Operate = new FolderOperation(FileSystem);
  }


  @Test
  public void testInvalidParentSource() throws InvalidParentDestinationFolder,
      SelfDirectoryException, InValidSourceFolderException {

    // Checking whether FolderOperation throws an exception when parent source
    // is not valid
    boolean expected = true;
    boolean actual = false;
    try {
      String[] cmdArgs =
          {"cp", "/InvalidParentSourcePath/Source", "/ValidDestinationPath"};
      Operate.handleOperation(cmdArgs);
    } catch (InvalidParentSourceFolder e) {
      // Have two asserts, this one is to make the test case pass since the
      // exception has been correctly thrown by the class
      actual = true;
      assertEquals(expected, actual);
    }
    assertEquals(expected, actual);

  }

  @Test
  public void testInvalidParentDestination() throws SelfDirectoryException,
      InValidSourceFolderException, InvalidParentSourceFolder {

    // Checking whether FolderOperation throws an exception when parent
    // destination is not valid
    boolean expected = true;
    boolean actual = false;
    String[] cmdArgs =
        {"cp", "/ValidParentSourcePath/Source", "/InvalidDestinationPath"};
    try {
      Operate.handleOperation(cmdArgs);
    } catch (InvalidParentDestinationFolder e) {
      // if InvalidParentDestinationFolder exception has been correctly
      // thrown the test case will pass
      actual = true;
      assertEquals(expected, actual);
    }
    assertEquals(expected, actual);
  }

  @Test
  public void testInvalidSource()
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      SelfDirectoryException, InValidSourceFolderException {
    // Checking whether FolderOperation throws an exception when source
    // is not valid
    boolean expected = true;
    boolean actual = false;
    String[] cmdArgs = {"cp", "/ValidParentSourcePath/InvalidSource",
        "ValidParent/ValidDestinationPath"};
    try {
      Operate.handleOperation(cmdArgs);
    } catch (InValidSourceFolderException e) {
      actual = true;
      assertEquals(expected, actual);
    }
    assertEquals(expected, actual);
  }

  @Test
  public void testNewDestinDir()
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      InValidSourceFolderException, SelfDirectoryException {
    // Checking the case when the destination path is wrong, assumed that the
    // destination is a directory and checking if the naming is
    // outputting correctly
    String[] cmdArgs =
        {"cp", "/ValidParentSourcePath/Source", "/ValidDestin1/InvalidDest"};
    Operate.handleOperation(cmdArgs);
    IDirectory Destination = (IDirectory) Operate.getDestinationDir();
    String actual = Destination.getName();
    String expected = "InvalidDest";
    assertEquals(expected, actual);

  }


  @Test
  public void testValidInputs()
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      SelfDirectoryException, InValidSourceFolderException {

    // Checking whether a positive test case works when two directories are
    // given and the HandleOperation is able to provide the correct
    // Directories (checked by asserting names)
    String[] cmdArgs = {"cp", "/ValidParentSourcePath/TrueValidSourcePathDir",
        "/ValidParentSourcePath/TrueValidDestinationPathDir"};
    Operate.handleOperation(cmdArgs);
    IDirectoryItems Source = Operate.getInitialFolder();
    IDirectoryItems Destination = Operate.getDestinationDir();
    String actualSource = Source.getName();
    String actualDestin = Destination.getName();
    String expectedSource = "/ValidParentSourcePath/TrueValidSourcePathDir";
    String expectedDestin =
        "/ValidParentSourcePath/TrueValidDestinationPathDir";
    // checking if the Source Folder is correct
    assertEquals(expectedSource, actualSource);
    // checking whether the Destination Folder is correct
    assertEquals(expectedDestin, actualDestin);

  }

}
