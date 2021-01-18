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

public class Pwd extends Command {
  /**
   * Executes pwd
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    // get file manager
    IFileManager tempFileManager = FileManager.getInstance();
    // print the full path
    String result = tempFileManager.getFullPath();
    if(cmdArgs.length == 3) {
      redirect(result, cmdArgs[1], cmdArgs[2]);
    }
    return result;
  }

  /**
   * overrides toString to show string representation of pwd
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: pwd";
    String summary = "\nSummary: Displays the absolute path name of the "
        + "current working directory.\n";
    String use = "Use: pwd \n";
    String example = "Example:\n/#/hello/hi/bye/: pwd\n/#/hello/hi/bye/\n";
    String result = name + summary + use + example;
    return result;
  }
}
