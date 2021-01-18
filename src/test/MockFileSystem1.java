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

import java.util.List;
import a2.IDirectory;
import a2.IFile;
import a2.IFileManager;

public class MockFileSystem1 implements IFileManager {

  @Override
  public List<IDirectory> getAllChildrenDir() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<IFile> getAllChildrenFile() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Checks whether the list contains a File
   * 
   * @return returning the directory of the curdir which is preprogrammed to
   *         handle a test case
   */
  @Override
  public IDirectory getCurDir() {
    // TODO Auto-generated method stub
    return new MockDirectory("/#");
  }

  /**
   * Checks whether the list contains a File
   * 
   * @return returning the directory of the curdir which is preprogrammed to
   *         handle a test case
   */
  @Override
  public IDirectory getSpecificDirectory(String name) {

    IDirectory retValue;
    if (name.equals("/ValidParentSourcePath/Source")
        || name.equals("/ValidParentSourcePath/TrueValidSourcePathDir")
        || name.equals("/ValidParentSourcePath/TrueValidDestinationPathDir")
        || name.equals("/ValidParentSourcePath")
        || name.equals("/ValidDestinationPath")
        || name.equals("/ValidParentSourcePath") || name.equals("/ValidDestin1")
        || name.equals("ValidParent")) {
      retValue = new MockDirectory(name);

    } else {
      retValue = null;
    }
    return retValue;
  }

  @Override
  public IFile getSpecificFile(String name) {

    return null;
  }

  @Override
  public String getFullPath() {

    return null;
  }

  @Override
  public void setCurrentDir(IDirectory currDir) {


  }

  @Override
  public IDirectory getCurrentDir() {

    return null;
  }

  @Override
  public void addDirectoryToPath(String path) {


  }

  @Override
  public IDirectory getParentDirectory() {

    return null;
  }

  @Override
  public IDirectory getRootDirectory() {

    return null;
  }

  @Override
  public boolean alreadyExists(String name) {

    return false;
  }

  @Override
  public void addFileToPath(String name, IFile input) {


  }

}
