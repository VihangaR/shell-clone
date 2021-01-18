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

import a2.FileManager;

public class Cd extends Command {
  /**
   * Executes cd
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    IFileManager tempFileManager = FileManager.getInstance();
    // Target directory which will hold the eventual target
    IDirectory target;
    // if there are no parameters or the parameter is /
    if (cmdArgs.length == 1 || cmdArgs[1].equals("/")) {
      // Need to go back to the parent directory
      target = tempFileManager.getRootDirectory();
    }
    // if the parameter is ..
    else if (cmdArgs[1].equals("..")) {
      // get the the parent directory
      target = tempFileManager.getParentDirectory();
      // if there's no parent directory
      if (target == null) {
        // display error message
        System.out.println("Does not exist");
      }
      // if there is
      else {
        // cd into parent directory
        tempFileManager.setCurrentDir(target);
      }
    }
    // if there's parameter
    else {
      // then it's the full path, so get the directory of this path
      target = tempFileManager.getSpecificDirectory(cmdArgs[1]);
      // if there's no such path
      if (target == null) {
        // display error message
        System.out.println("Does not exist");
      }
      // if there is
      else {
        // cd into that
        tempFileManager.setCurrentDir(target);
      }
    }
    return "";
  }

  /**
   * overrides toString to show string representation of cd
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: cd";
    String summary = "\nSummary: Changes the working directory in shell";
    String use = "\nUse: cd [args ...] \nWhere [args ...] can either be a path"
        + "(both absolute and relative) or null (returns to parent dir) ";
    String example =
        "\nExample:\n/#/: ls\nnewfolder tempfolder\n/#/: cd newfolder\n"
            + "/#/newfolder: \n";
    return name + summary + use + example;
  }
}
