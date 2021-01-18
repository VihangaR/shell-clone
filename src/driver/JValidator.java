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

package driver;

import driver.JCmdManager;

public class JValidator {

  /**
   * Checks if its a valid path (alpha numeric)
   * 
   * @param dirName the directory name
   * @return returns a boolean if its a valid path or not
   */
  public static boolean validArgument(String dirName) {
    String tempStr = dirName.replace("/", "a");
    // Replaces with a because we look for alpha numeric symbols in next line
    tempStr = tempStr.replace("..", "a");
    tempStr = tempStr.replace(".", "a");
    if (!tempStr.matches("[a-zA-Z0-9]+")) {
      return false;
    }
    return true;
  }

  /**
   * Checks if it's a valid name
   * 
   * @param pathname the path name
   * @return returns a boolean if its a valid path or not
   */
  public static boolean validPathDest(String pathname) {
    String[] parsedBySlash = pathname.split("/+");
    if (!parsedBySlash[parsedBySlash.length - 1].matches("[a-zA-Z0-9]+")) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Validates the commands
   * 
   * @param commandArgs The command arguments
   * @return returns true or false depending on if it is valid
   */
  public static boolean validate(String[] commandArgs) {
    // We will have this set to false and do validation below
    boolean isValid = true;
    // Will do validation down here
    if (commandArgs[0].equals("mkdir")) {
      int x = 1;
      while (commandArgs.length > x && commandArgs[x] != null) {
        if (validArgument(commandArgs[x]) == false) {
          System.out.println(commandArgs[x] + " is an invalid name.");
          commandArgs[x] = "";
        }
        x++;
      }
    } else if (commandArgs[0].equals("cd")) {
      if (commandArgs.length == 2) {
        if (validArgument(commandArgs[1]) == false) {
          System.out.println("This is an invalid path");
          isValid = false;
        }
      } else if (commandArgs.length > 2) {
        System.out.println("You can't enter multiple paths");
        isValid = false;
      }
    } else if (commandArgs[0].equals("pwd")) {
      if (commandArgs.length > 1) {
        System.out.println("pwd doesn't take any parameters");
        isValid = false;
      }
    } else if (commandArgs[0].equals("echo")) {
      // Invalid number of arguments
      if (commandArgs.length != 2 && commandArgs.length != 4) {
        System.out.println("Invalid number of arguments");
        isValid = false;
      }
      // Invalid mode (neither append nor overwrite
      else if ((commandArgs.length == 4) && (!commandArgs[2].equals(">"))
          && (!commandArgs[2].equals(">>"))) {
        System.out.println("Invalid mode");
        isValid = false;
      }
    }
    // Cat will check path inside itself so that it just can skip any invalid
    // file name
    if (isValid) {
      JCmdManager commandexec = new JCmdManager();
      commandexec.select(commandArgs);
      return true;
    } else
      return false;
  }
}
