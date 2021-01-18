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

import java.util.ArrayList;
import java.util.List;
import a2.File;
import a2.IDirectory;
import a2.IDirectoryItems;
import a2.IFile;


public class MockDirectory implements IDirectory {
  /**
   * Storing the name of the Directory -> this is used to validate the output
   * using assertions
   */
  private String name;
  /**
   * Storing all the children directories
   */
  private List<IDirectory> ChildDir = new ArrayList<IDirectory>();
  /**
   * Storing all the children Files
   */
  private List<IFile> ChildFiles = new ArrayList<IFile>();

  /**
   * Calling the mock Directory -> implemented such that the name is stored
   * which is different from the actual implementation
   */
  public MockDirectory(String name) {
    this.name = name;
  }

  @Override
  public List<IFile> getAllChildFiles() {
    // TODO Auto-generated method stub
    return ChildFiles;
  }

  @Override

  public List<IDirectory> getAllChildDir() {

    return null;
  }

  /**
   * Getter for name
   */
  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public IDirectory getChild(String name) {

    return null;
  }

  /**
   * This method is a getter method for child File
   */
  @Override
  public IFile getChildFile(String name) {

    IFile childFile;
    if (ChildFiles.size() > 0) {
      childFile = ChildFiles.get(0);
    } else {
      childFile = null;
    }
    return childFile;
  }

  @Override
  public String getPath() {

    return null;
  }


  @Override
  public IDirectory getParent() {

    return null;
  }


  @Override
  public void removeChild(IDirectory child) {


  }

  /**
   * Adds ChildFile to the List
   */
  @Override
  public void addChildFile(IFile initialFolder) {
    ChildFiles.add(initialFolder);

  }

  /**
   * Sets the name of the MockDirectory
   * 
   * @param name String
   */

  @Override
  public void setName(String name) {
    // TODO Auto-generated method stub
    this.name = name;
  }

  /**
   * Checks whether the list contains a File
   * 
   * @param file file to check
   * @return boolean to indicate whether the list contains the file
   */
  public boolean containsFile(IFile file) {
    return ChildFiles.contains(file);
  }

  /**
   * Checks whether the list contains a File
   * 
   * @param directory directory to add
   * 
   */
  @Override
  public void addChild(IDirectory child) {

    ChildDir.add(child);
  }

  /**
   * Checks whether the list contains a Directory
   * 
   * @param directory directory to check
   * @return boolean to indicate whether the list contains the direcrtory
   */
  @Override
  public boolean containsDirectory(IDirectory child) {

    return ChildDir.contains(child);

  }

  @Override
  public void removeChildFile(IFile child) {

  }

}
