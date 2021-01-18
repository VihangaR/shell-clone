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

public class MockFile implements IFile {
  /**
   * Storing the name and contents
   */
  private String name;
  private String content;


  /**
   * Initializes the file
   * 
   * @param name name to add
   * 
   */
  public MockFile(String name) {
    this.name = name;
  }

  /**
   * gets the contents
   * 
   * @returns file content
   */
  @Override
  public String getContent() {

    return this.content;
  }

  /**
   * Sets the content
   * 
   * @param content string to add
   */
  @Override
  public void setContent(String content) {

    this.content = content;

  }

  @Override
  public void appendContent(String content) {


  }

  @Override
  public String getName() {

    return null;
  }

  @Override
  public void setName(String name) {


  }

}
