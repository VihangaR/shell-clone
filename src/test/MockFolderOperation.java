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

public class MockFolderOperation implements IFolderOperation {
  /**
   * Initializing all the instance variables that is required for mock and
   * assertions
   */
  private IDirectoryItems initialFolder;
  private IDirectoryItems destinationFolder;
  private IDirectory ParentIniFolder;
  private IDirectory ParentDestinFolder;

  public MockFolderOperation(IFileManager fm) {

  }

  @Override
  public void handleOperation(String[] cmdArgs)
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      SelfDirectoryException {
    try {
      // hardcode strings that will be inside the path and create a series of
      // elseif statements to deal with all the test cases
      // create one Valid parent for src
      if (cmdArgs[1].endsWith("ValidDirectory")
          && cmdArgs[2].endsWith("ValidDirectory1")) {
        this.DirinDirCase();

      } else if (cmdArgs[1] == "/ValidParentDir/ValidChildDir") {
        throw new SelfDirectoryException();
      } else if (cmdArgs[1] == "/ValidParent/ValidsrcFile") {
        this.sameFileCase();
      } else if (cmdArgs[2].equals("/ValidParent/InvalidDestinationDir")) {
        this.validParentInvalidChildDir();
      } else if (cmdArgs[2].equals("/ValidParent/ValidDestinationDir")) {
        this.FiletoValidDirCase();
      } else if (cmdArgs[2].equals("/ValidParentPath1/ValidDestFile")) {
        this.fileToFileCase();

      }
      if (cmdArgs[2].endsWith("SomeInvalidPath")
          && cmdArgs[2].contains("AnotherInValidPath")) {
        throw new InvalidParentDestinationFolder();

      }
      if (cmdArgs[2].equals("/InvalidParent/InvalidFile")) {
        throw new InvalidParentSourceFolder();
      }
      if (cmdArgs[2].endsWith("CreateNewFile")) {
        destinationFolder = new MockFile("CreateNewFile");
        ParentDestinFolder = new MockDirectory("ValidParentPath1");
        ParentDestinFolder.addChildFile((IFile) destinationFolder);

      }
    } catch (IndexOutOfBoundsException e) {
      throw e;
    }



  }

  private void fileToFileCase() {
    initialFolder = new MockFile("ValidFile");
    destinationFolder = new MockFile("ValidDestFile");
    ParentDestinFolder = new MockDirectory("ValidParentDest");
    ParentDestinFolder.addChildFile((IFile) destinationFolder);
    ParentIniFolder = new MockDirectory("ValidParentSrc");
    ParentIniFolder.addChildFile((IFile) initialFolder);
    ((IFile) initialFolder).setContent("This is the initial Contents");

  }

  private void validParentInvalidChildDir() {

    destinationFolder = new MockDirectory("InvalidDestinationDir");
    initialFolder = new MockFile("ValidFile");

  }

  private void DirinDirCase() {
    destinationFolder = new MockDirectory("ValidDestinationDir1");
    initialFolder = new MockDirectory("ValidDirectory");
    ((IDirectory) destinationFolder).addChild(new MockDirectory("SomeNewFile"));
  }

  private void sameFileCase() {
    destinationFolder = new MockDirectory("ValidDestinationDir");
    IFile sameFile = new MockFile("ValidsrcFile");
    sameFile.setContent("DestinationFile'sContents");
    ((IDirectory) destinationFolder).addChildFile(sameFile);
    initialFolder = new MockFile("ValidsrcFile");
    ((IFile) initialFolder).setContent("SrcFileContents");


  }

  private void FiletoValidDirCase() {
    initialFolder = new MockFile("ValidFile");
    ((IFile) initialFolder).setContent("This is the srcdata");
    ParentIniFolder = new MockDirectory("ValidParentPath");
    ParentIniFolder.addChildFile((IFile) initialFolder);
    destinationFolder = new MockDirectory("ValidDestinPath");

  }

  @Override
  public IDirectory getParent() {

    return ParentDestinFolder;
  }

  @Override
  public IDirectoryItems getDestinationDir() {

    return destinationFolder;
  }

  @Override
  public IDirectoryItems getInitialFolder() {

    return initialFolder;
  }

  public IDirectoryItems getInitalParent() {
    return ParentIniFolder;
  }

  @Override
  public IDirectory getSourceParent() {

    return ParentDestinFolder;
  }

}
