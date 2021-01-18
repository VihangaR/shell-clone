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

import a2.File;

public class Cat extends Command {
  /**
   * Executes cat
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */


  public static boolean validPathDest(String pathname) {
    String[] parsedBySlash = pathname.split("/+");
    if (!parsedBySlash[parsedBySlash.length - 1].matches("[a-zA-Z0-9.]+")) {
      return false;
    } else {
      return true;
    }
  }

  public String exec(String[] cmdArgs) {
    // gets the file manager
    IFileManager tempFileManager = FileManager.getInstance();
    // initialize result to be empty
    String result = "";
    String sign = "";
    String file = "";
    int size = cmdArgs.length;
    boolean re = false;
    if (cmdArgs[cmdArgs.length-2].contains(">")) {
      re = true;
      sign = cmdArgs[cmdArgs.length-2];
      file = cmdArgs[cmdArgs.length-1];
      size = cmdArgs.length-2;
    }
    // for every file
    for (int i = 1; i < size; i++) {
      // if this is not the first file
      // get the file contents at this file
      IFile tempFile = (IFile)tempFileManager.getSpecificFile(cmdArgs[i]);
      // if there's no such file
      if (!validPathDest(cmdArgs[i])) {
        // display error message

        if (i > 1) {
          // add 1 new lines
          result = result + "\n";
        }
        result = result + "Cat " + cmdArgs[i] + " : File name invalid";
      } else if (tempFile == null) {
        if (i > 1) {
          // add 1 new lines
          result = result + "\n";
        }
        result = result + "Cat " + cmdArgs[i] + " : File does not exist";

      }
      // if there is
      else {
        // get content of the file
        if (i > 1) {
          // add 3 new lines
          result = result + "\n\n\n";
        }
        result = result + tempFile.getContent();
      }
    }
    if(re) {
      redirect(result, sign, file);
    }
    return result;
  }

  /**
   * overrides toString to show string representation of cat
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: cat";
    String summary = "\nSummary: concatentate and print files";
    String use =
        "\nUse:  Reads files sequentially, writing them to the" + "console";
    String example = "\nExample:\n/#/: ls\nfile1 file2\n/#/: cat file1 file2\n"
        + "Content from file1\n\nContent from File2\n";
    return name + summary + use + example;
  }
}
