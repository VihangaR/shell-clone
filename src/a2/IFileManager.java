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

public interface IFileManager {
  public List<IDirectory> getAllChildrenDir();
  /**
   * Gets all the children files
   * 
   * @return returns the children files of the current directory
   */
  public List<IFile> getAllChildrenFile();

  /**
   * Gets the current directory
   * 
   * @return returns the current directory
   */
  public IDirectory getCurDir();
  

  /**
   * Gets the specific directory, can take in either a directory name, relative
   * path or full path
   * 
   * @param name name of the path or directory
   * @return returns the directory based on the name of the path
   */
  public IDirectory getSpecificDirectory(String name);
  /**
   * Gets the specific file based on the name, can be a file or the path to a
   * file
   * 
   * @param name name of the file or path
   * @return returns the file
   */
  public IFile getSpecificFile(String name);
  /**
   * Gets the full path based on the position of the current directory
   * 
   * @return the full path of the current directory
   */
  public String getFullPath();
  /**
   * Sets the current directory
   * 
   * @param currDir the current directory to be set equal to
   */
  public void setCurrentDir(IDirectory currDir);

  /**
   * Gets the current directory
   * 
   * @return currDir the current directory
   */
  public IDirectory getCurrentDir();

  /**
   * Adds the directory to the path
   * 
   * @param path adds the directory to the current directory
   */
  public void addDirectoryToPath(String path);

  /**
   * Gets the parent directory
   * 
   * @return returns the parent directory of the current directory
   */
  public IDirectory getParentDirectory();

  /**
   * Gets the root directory
   * 
   * @return returns the root directory
   */
  public IDirectory getRootDirectory();

  /**
   * Checks if a file or directory already exists, used when creating files or
   * directories
   * 
   * @param name name of the file or directory
   * @return returns true or false depending on if it exists or not
   */
  public boolean alreadyExists(String name);
  /**
   * Adds the file to the given path
   * 
   * @param name name of the path
   * @param input the file to be added to the path
   */
  public void addFileToPath(String name, IFile input);

  

}
