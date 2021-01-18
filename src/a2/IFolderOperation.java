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

public interface IFolderOperation {
  
  /**
   * Handle Operation will throw exceptions depending on the paths given
   * 
   * @param cmdArgs raw input from the user
   */
  public void handleOperation(String[] cmdArgs)
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      SelfDirectoryException, InValidSourceFolderException;
  
  /**
   * Gets the parent directory of source directory
   */
  public IDirectory getSourceParent();
  
  /**
   * Gets the parent directory of destination directory
   */
  public IDirectory getParent();
  
  /**
   * Gets the destination directory
   */
  public IDirectoryItems getDestinationDir();
  
  /**
   * Gets the initial folder
   */
  public IDirectoryItems getInitialFolder();

}
