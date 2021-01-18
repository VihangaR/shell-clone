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

public class MockCp implements ICp {
  /**
   * Setting up all the instance variables to initiate mock
   */
  private IDirectory ParentSource;
  private IDirectoryItems InitialSource;

  @Override
  public String exec(String[] cmdArgs) {

    String retValue = "";
    // using a series of if else statements in order to deal with all the
    // inputs to mock what the cp command can return to mv
    if (cmdArgs[0].equals("NotenoughArgs")) {
      // Checking what the mv command will do when a string is passed instead
      retValue = "Insufficient Arguments, refer man for usage\n";
    } else if (cmdArgs[1].equals("/ValidParentDirectory/ValidInitialDir")) {
      // these few cases will return an empty string, which would mean that
      // cp has correctly executed
      ParentSource = new MockDirectory("ValidParentFile");
      InitialSource = new MockDirectory("ValidInitialDir");

    } else if (cmdArgs[1].equals("/ValidParentDirectory/ValidInitialFile")) {
      ParentSource = new MockDirectory("ValidParentFile");
      InitialSource = new MockFile("ValidInitialFile");
    } else if (cmdArgs[1].equals("/Someinvalidpath")) {
      retValue = "Invalid Path\n";
    } else {
      retValue = "Invalid Operation: a directory cannot be copied to a file!\n";
    }
    return retValue;
  }

  @Override
  public void changeFolderOperation(IFolderOperation folder) {}

  /**
   * Getter method for getting ParentSource
   */
  @Override
  public IDirectory getParentSource() {

    return ParentSource;
  }

  /**
   * Getter method for getting IntialSource
   */
  @Override
  public IDirectoryItems getInitialSource() {

    return InitialSource;
  }

}
