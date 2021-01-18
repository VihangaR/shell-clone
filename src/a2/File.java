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

public class File extends DirectoryItems implements IFile{

  private String content;


  /**
   * constructor for a file
   * 
   * @param name name of this file
   * @param content the content of the file
   */
  public File(String name, String content) {
    super(name);
    // Creation of the file
    this.setContent(content);
    
  }

  /**
   * Gets content of the file; a getter method
   * 
   * @returns content A string denoting the content of the file
   */

  public String getContent() {
    // Gets the content of the file
    return content;
  }

  /**
   * Sets content of the file; a getter method
   * 
   * @param content A string denoting the content of the file
   */
  public void setContent(String content) {
    // Sets the content of the file
    this.content = content + "\n";
  }

  /**
   * Appends given content to the existing content of the File
   * 
   * @param content A string denoting the content of the file
   */

  public void appendContent(String content) {
    // Appends content rather than setting it
    this.content += content + "\n";
  }

  /**
   * Gets the name of the File
   * 
   * @returns name A string denoting the name of the file
   */


}
