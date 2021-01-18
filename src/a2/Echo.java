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

public class Echo extends Command {
  /**
   * Executes echo
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    IFileManager tempFileManager = FileManager.getInstance();
    if (cmdArgs.length == 2) {
      // the string is that parameter
      System.out.println(cmdArgs[1]);
    }
    // Since we assume that any command passing in is valid, we just have to
    // check 2 files
    else {
      // Request a pointer to the file
      IFile fileaccess = tempFileManager.getSpecificFile(cmdArgs[3]);
      // if this pointer exists
      if (fileaccess != null) {
        // If the mode is append, we append the content to the file
        if (cmdArgs[2].equals(">>")) {
          fileaccess.appendContent(cmdArgs[1]);
        }
        // If the mode is overwrite, we overwrite the content to the file
        else if (cmdArgs[2].equals(">")) {
          fileaccess.setContent(cmdArgs[1]);
        }
      }
      // If not
      else {
        if (cmdArgs[2].equals(">") || cmdArgs[2].equals(">>")) {
          String[] nameSplitted = cmdArgs[3].split("/+");
          fileaccess =
              (IFile) new File(nameSplitted[nameSplitted.length - 1], cmdArgs[1]);
          if (!tempFileManager
              .alreadyExists(cmdArgs[3])) {
            tempFileManager.addFileToPath(cmdArgs[3], fileaccess);
            fileaccess.setContent(cmdArgs[1]);
          } else {
            System.out.println("Name already exist");
          }
        }
      }
    }
    return "";
  }

  /**
   * overrides toString to show string representation of echo
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: echo";
    String summary = "\nSummary: if only a string is passed, print the string"
        + "\nif in write mode with given string, and filename, make a"
        + " file with the string"
        + "\nif file doesn't exist. if it does, overwrite the file"
        + "\nif in append mode, if file with given filename exists, append"
        + " the given string to that file";
    String use = "\nUse: echo \"str\" where str is the string, print str"
        + "\necho echo \"str\" > where str is the string, filename is the name"
        + " of file to write in, if file already exists, overwrite, if not,"
        + "create a new file with filename and append \"str\" to it";
    String example = "\nExample:\n/#/hello/hi/: echo \"Hello\" > file"
        + "\n/#/hello/hi/: cat file \n/#/hello/hi/: "
        + "\"Hello\" \n/#/hello/hi/:\n";
    return name + summary + use + example;
  }
}