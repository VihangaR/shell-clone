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

public class Mkdir extends Command {
  /**
   * Executes mkdir
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    IFileManager tempFileManager = FileManager.getInstance();
    int size = cmdArgs.length;
    if(cmdArgs[cmdArgs.length-2].contains(">")) {
      size = cmdArgs.length-2;
    }
    // Adds the directory to the path using the given command
    // This loop handles multiple requests for creating a directory
    for (int numArg = 1; numArg < size; numArg++) {
      // changes to the specified directory given absolute or relative path
      // tempFileManager.findDirFromPath(cmdArgs[numArg]);
      String[] splittedName = cmdArgs[numArg].split("/+");
      if (splittedName.length == 1) {
        if (tempFileManager.alreadyExists(cmdArgs[numArg]) == true) {
          System.out.println(
              "An item with the name " + cmdArgs[numArg] + " already exists.");
        } else {
          tempFileManager.addDirectoryToPath(cmdArgs[numArg]);
        }
      } else if (splittedName.length > 1) {
        int dirIndex = cmdArgs[numArg].lastIndexOf('/');
        IDirectory target = tempFileManager
            .getSpecificDirectory(cmdArgs[numArg].substring(0, dirIndex));
        if (target == null) {
          System.out.println("The path does not exist, could not create the "
              + cmdArgs[numArg].substring(dirIndex + 1) + " directory.");
        } else {
          IDirectory curDir = tempFileManager.getCurDir();
          tempFileManager.setCurrentDir(target);
          if (tempFileManager
              .alreadyExists(cmdArgs[numArg].substring(dirIndex + 1)) == true) {
            System.out.println("An item with the name "
                + cmdArgs[numArg].substring(dirIndex + 1) + " already exists.");
            tempFileManager.setCurrentDir(curDir);
          } else {
            tempFileManager
                .addDirectoryToPath(cmdArgs[numArg].substring(dirIndex + 1));
            tempFileManager.setCurrentDir(curDir);
          }
        }
      }
    }
    return "";
  }

  /**
   * overrides toString to show string representation of mkdir
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: mkdir";
    String summary = "\nSummary: Creates Directories";
    String use = "\nUse: mkdir [args ...]\nWhere [args ...] "
        + "can be absolute or" + " relative path specifiying a name";
    String example =
        "\nExample\n/#/: ls\n/#/: mkdir newfolder\n/#/: " + "ls\nnewfolder\n";
    String result = name + summary + use + example;
    return result;
  }
}
