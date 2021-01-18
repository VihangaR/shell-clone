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
import a2.*;

public class MockFileSystem implements IFileManager {

  // Added this mock FileSystem for Mock FolderOperation

  @Override
  public List<IDirectory> getAllChildrenDir() {

    return null;
  }

  @Override
  public List<IFile> getAllChildrenFile() {

    return null;
  }

  @Override
  public IDirectory getCurDir() {

    return null;
  }

  @Override
  public IDirectory getSpecificDirectory(String name) {

    return null;
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
