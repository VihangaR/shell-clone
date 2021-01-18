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

import java.util.List;

public interface IDirectory extends IDirectoryItems{
  
  /**
   * Gets all the children files of the current directory
   * 
   * @return returns the list of the child files
   */

  List<IFile> getAllChildFiles();
  
  /**
   * Gets all the children directories of the current directory
   * 
   * @return returns the list of the child directories
   */
  List<IDirectory> getAllChildDir();
  /**
   * Gets the name of the current directory
   * 
   * @return returns the name of the directory
   */
  String getName();
  
  /**
   * Gets the children directory of the current directory, if it doesn't exist,
   * it will return null
   * 
   * @param name the name of the directory you're searching for
   * @return returns the directory if it's found, otherwise returns null
   */
  IDirectory getChild(String name);
  
  /**
   * Gets the children files of the current directory, if it doesn't exist, it
   * will return null
   * 
   * @param name the name of the file you're searching for
   * @return returns the file if it's found, otherwise returns null
   */
  IFile getChildFile(String name);
  
  /**
   * Gets the path of the current directory
   * 
   * @return the full path of the current directory
   */
  String getPath();
  /**
   * Will return true if the current directory contains the child directory,
   * otherwise returns false
   * 
   * @param child the child directory you want to look for
   * @return true or false depending on if the current directory has the child
   *         directory
   */
  boolean containsDirectory(IDirectory child);
  /**
   * Gets the parent of the current directory
   * 
   * @return the parent directory
   */
  IDirectory getParent();
  /**
   * Adds a directory to the list of children directories
   * 
   * @param child the child directory to be added
   */
  void addChild(IDirectory child);
  /**
   * Removes a directory from the list of children directories
   * 
   * @param child the child directory to be removed
   */
  
  void removeChild(IDirectory child);
  
  /**
   * Adds a file to the list of children files
   * 
   * @param initialFolder the child file to be added
   */
  void addChildFile(IFile initialFolder);
  /**
   * Removes a file from the list of children files
   * 
   * @param child the child file to be removed
   */
  void removeChildFile(IFile child);
  /**
   * Ability to find a particular file inside the directory
   * @param file
   * @return boolean that indicates whether the child is found inside directory
   */
  public boolean containsFile(IFile file);

}
