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

import java.util.Stack;

public class Pushd extends Command {
  // make a stack to store items
  private static Stack<String> s = new Stack<String>();

  /**
   * Executes pushd * @param cmdArgs the array of the input command splitted by
   * spaces
   * 
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    // get file manager
    IFileManager tempFileManager = FileManager.getInstance();
    // add to stack the path of current directory
    s.push(tempFileManager.getFullPath());;
    return "";
  }

  /**
   * Remove and return the most recent item in stack
   * 
   * @return str the poped string
   */
  public static String pop() {
    Console c = new Console();
    // initialize return string to be null
    String str = null;
    // if stack isn't empty
    if (!s.isEmpty()) {
      // return the most recent path
      str = s.pop();
    }
    // if it is
    else {
      // display error message
      c.printMsg("directory stack is empty");
    }
    return str;
  }

  /**
   * overrides toString to show string representation of pushd
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: pushd";
    String summary =
        "\nSummary: saves the current directory on directory stack";
    String use = "Use: \npushd";
    String example = "Example:\n/#/hello/hi/bye/: pushd\n";
    String result = name + summary + use + example;
    return result;

  }
}
