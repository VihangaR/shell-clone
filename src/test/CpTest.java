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

import a2.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CpTest {
  /**
   * Instance of the real implementation of cp
   */
  public ICp copy;
  /**
   * Made a Mock FolderOperation since Cp depends on it
   */
  public IFolderOperation MockOperate;
  /**
   * Made a Mock FileSystem instance since FolderOperation depends on it
   */
  public IFileManager MockFileSystem;

  /**
   * Setting up all the instance variables to the mock objects created
   */
  @Before
  public void setUp() throws Exception {
    // creating all the instances where the interfaces are using a mock
    // version of the commands and FileSystem
    copy = new Cp();
    MockFileSystem = new MockFileSystem();
    MockOperate = new MockFolderOperation(MockFileSystem);
    copy.changeFolderOperation(MockOperate);

  }

  @Test
  public void testNoInput() {
    // Since there is no input, the FolderOperation will throw an exception
    // called IndexOutofBounds Exception, Cp has to catch this and return a
    // meaningful error message to the user

    String[] cmdArgs = {"cp"};
    String actual = copy.exec(cmdArgs);
    String expected = "Insufficient Arguments, refer man for usage\n";
    assertEquals(expected, actual);


  }

  @Test
  public void testFiletoFile() {
    // existing file and existing destination file: overwrites the contents
    // of the destination file with the contents of the source file
    String[] cmdArgs =
        {"cp", "/ValidParentPath/ValidFile", "/ValidParentPath1/ValidDestFile"};
    String actual = copy.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);
    // This test is to check whether the parent of the source file still
    // contains the source file

    // get the parent directory of the source file
    IDirectory parentDes = MockOperate.getSourceParent();
    IFile InitialFolder = (IFile) MockOperate.getInitialFolder();

    // this test is to check whether the destination file's contents are
    // overridden

    String actualContent =
        ((IFile) MockOperate.getDestinationDir()).getContent();
    String expectedContent = "This is the initial Contents";

    assertEquals(expectedContent, actualContent);
  }


  @Test
  public void testFiletoDirectory() {
    // existing File and existing destination Directory
    // source directory will be added as the subdirectory of destination
    // directory


    String[] cmdArgs = {"cp", "/ValidParentPath/ValidFile",
        "/ValidParent/ValidDestinationDir"};
    String actual = copy.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);

    // need to check whether the destination directory contains the source
    // file

    IDirectory destinationDir = (IDirectory) MockOperate.getDestinationDir();
    IFile sourceFile = (IFile) MockOperate.getInitialFolder();

    boolean actualFileinDir = destinationDir.containsFile(sourceFile);
    boolean expectedFileinDir = true;

    assertEquals(expectedFileinDir, actualFileinDir);
  }

  @Test
  public void testFiletoNewDirectory() {
    // if the path is invalid, ex: cp file1 b/c; then b will be renamed to c
    // and file1 will be copied to c (which is b)

    String[] cmdArgs = {"cp", "/ValidParentPath/ValidFile",
        "/ValidParent/InvalidDestinationDir"};
    String actual = copy.exec(cmdArgs);
    String expected = "";
    assertEquals(expected, actual);

    // get the parent destination directory and check whether it is renamed to
    // InvalidDestinationDir and contains the file (ValidFile)
    IDirectory DestinFolder = (IDirectory) MockOperate.getDestinationDir();
    IFile initialFolder = (IFile) MockOperate.getInitialFolder();
    String actualName = DestinFolder.getName();
    String expectedName = "InvalidDestinationDir";

    assertEquals(expectedName, actualName);

    boolean actualFile = DestinFolder.containsFile(initialFolder);
    assertTrue(actualFile);

  }

  @Test
  public void testFiletoDirectorySameName() {
    // Overwrite if the same srcfilename exists; if the directory does not
    // exist then give an error

    String[] cmdArgs =
        {"cp", "/ValidParent/ValidsrcFile", "/ValidParent1/ValidDir"};
    String actual = copy.exec(cmdArgs);
    String expected = "";

    assertEquals(expected, actual);

    // check whether the file under the destinatioDir contains the contents of
    // the srcFile

    IDirectory DestinFolder = (IDirectory) MockOperate.getDestinationDir();
    String srcFile = ((IFile) MockOperate.getInitialFolder()).getContent();

    boolean actualFileinDir =
        DestinFolder.getChildFile("ValidsrcFile").getContent().equals(srcFile);

    assertTrue(true == actualFileinDir);


  }

  @Test
  public void testFiletoInvalidDirectory() {
    // Give an error saying that the directory does not exist


    // Invalid Parent Directory to the Destination File
    String[] cmdArgs =
        {"cp", "/ValidParentPath/ValidFile", "/InvalidParent/InvalidFile"};
    String actual = copy.exec(cmdArgs);
    String expected = "Invalid Path\n";

    assertEquals(expected, actual);


  }

  @Test
  public void testDirectorytoFile() {
    // Not Possible an error should be printed to the user

    String[] cmdArgs =
        {"cp", "/ValidParentPath/ValidDirectory", "/ValidParent/ValidFile"};
    String actual = copy.exec(cmdArgs);
    String expected =
        "Invalid Operation: a directory cannot be copied to a file!\n";

    assertEquals(expected, actual);


  }

  @Test
  public void testDirectorytoDirectory() {
    // existing src directory is copied to the destination directory as a
    // sub-directory


    String[] cmdArgs =
        {"cp", "/ValidParent/ValidDirectory", "/ValidParent1/ValidDirectory1"};
    String result = copy.exec(cmdArgs);
    String expected = "";

    assertEquals(expected, result);
    // if the two directories are valid, then the only change is that
    // ValidDirectory1 should now contain ValidDirectory

    IDirectory DestinDir = (IDirectory) MockOperate.getDestinationDir();
    IDirectory InitialDir = (IDirectory) MockOperate.getInitialFolder();
    boolean actualDirinDir = DestinDir.containsDirectory(InitialDir);
    boolean expectedResult = true;

    assertEquals(expectedResult, actualDirinDir);

  }

  @Test
  public void testDirectorytoSelf() {
    // cannot add the same directory to self
    // error message needs to be printed to the user

    String[] cmdArgs = {"cp", "/ValidParentDir/ValidChildDir",
        "/ValidParentDir/ValidChildDir"};
    String actual = copy.exec(cmdArgs);
    String expected =
        "Operation failed: Directory cannot be copied as a subdirectory to"
            + "itself\n";

    assertEquals(expected, actual);

  }


}
