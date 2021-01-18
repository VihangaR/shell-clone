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

package a2;

import a2.DirectoryItems;
import java.util.ArrayList;
import java.util.List;

public class Directory extends DirectoryItems implements IDirectory{
  
  /**
   * Holds the parent directory
   */
  private IDirectory parent;
  /**
   * Hold the sub directories in the current folder
   */
  private List<IDirectory> children = new ArrayList<>();
  /**
   * Holds the sub files in the current folder
   */
  private List<IFile> childFiles = new ArrayList<>();

  /**
   * Creates a root folder, doesn't take the current directory because the
   * parent directory of the root folder doesn't exist
   * 
   * @param name the name of the directory
   */
  public Directory(String name) {
    super(name);
    this.parent = null;
  }

  

  /**
   * Constructor for directory class
   * 
   * @param parentDirectory the parent directory of the current directory being
   *        created
   * @param name the name of the directory being created
   */
  public Directory(IDirectory parentDirectory, String name) {
    super(name);
    this.parent = parentDirectory;
  }

  /**
   * Gets all the children files of the current directory
   * 
   * @return returns the list of the child files
   */
  public List<IFile> getAllChildFiles() {
    return this.childFiles;
  }

  /**
   * Gets all the children directories of the current directory
   * 
   * @return returns the list of the child directories
   */
  public List<IDirectory> getAllChildDir() {
    return this.children;
  }

  /**
   * Gets the name of the current directory
   * 
   * @return returns the name of the directory
   */

  /**
   * Gets the children directory of the current directory, if it doesn't exist,
   * it will return null
   * 
   * @param name the name of the directory you're searching for
   * @return returns the directory if it's found, otherwise returns null
   */
  public IDirectory getChild(String name) {
    // Loops through the children directories of the current directory
    for (IDirectory element : this.children) {
      // If the name equals to the name of the directory you're searching for,
      // return it
      if (element.getName().equals(name)) {
        return element;
      }
    }
    // Return null otherwise
    return null;
  }

  /**
   * Gets the children files of the current directory, if it doesn't exist, it
   * will return null
   * 
   * @param name the name of the file you're searching for
   * @return returns the file if it's found, otherwise returns null
   */
  public IFile getChildFile(String name) {
    // Loops through the children files of the current directory
    for (IFile element : this.childFiles) {
      // If the name equals to the name of the file you're searching for,
      // return it
      if (element.getName().equals(name)) {
        return element;
      }
    }
    // Return null otherwise
    return null;
  }

  /**
   * Gets the path of the current directory
   * 
   * @return the full path of the current directory
   */
  public String getPath() {
    String result = "";
    Directory curDir = this;
    // Keep looping while the current directories parent exists
    while (curDir.parent != null) {
      // Create the full path string based on the name
      result = curDir.getName() + "/" + result;
      curDir = (Directory) curDir.getParent();
    }
    // Return the full string
    result = "/#/" + result;
    return result;
  }

  /**
   * Will return true if the current directory contains the child directory,
   * otherwise returns false
   * 
   * @param child the child directory you want to look for
   * @return true or false depending on if the current directory has the child
   *         directory
   */
  public boolean containsDirectory(IDirectory child) {
    return children.contains(child);
  }

  /**
   * Gets the parent of the current directory
   * 
   * @return the parent directory
   */
  public IDirectory getParent() {
    return this.parent;
  }

  /**
   * Adds a directory to the list of children directories
   * 
   * @param child the child directory to be added
   */
  public void addChild(IDirectory child) {
    children.add(child);
  }

  /**
   * Removes a directory from the list of children directories
   * 
   * @param child the child directory to be removed
   */
  public void removeChild(IDirectory child) {
    children.remove(child);
  }

  /**
   * Adds a file to the list of children files
   * 
   * @param child the child file to be added
   */
  public void addChildFile(IFile child) {
    childFiles.add(child);
  }

  /**
   * Removes a file from the list of children files
   * 
   * @param child the child file to be removed
   */
  public void removeChildFile(IFile child) {
    childFiles.remove(child);
  }

  /**
   * Searches whether the Directory contains the specified child File
   * 
   * @param child the child file to be found
   * @return boolean to indicate whether the file is found in the directory
   * 
   */

  @Override
  public boolean containsFile(IFile file) {
    // TODO Auto-generated method stub
    return childFiles.contains(file);
  }
}
