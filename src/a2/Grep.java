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

import java.util.ArrayList;
import java.util.List;

public class Grep extends Command {
  /**
   * Class injected variable
   */
  IFileManager grepFile;

  /**
   * default constructor
   */
  public Grep() {
    grepFile = FileManager.getInstance();
  }

  /**
   * inject constructor
   */
  public Grep(IFileManager inManager) {
    grepFile = inManager;
  }
  
  /**
   * Executes grep
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return fullGrepContent the output
   */
  public String exec(String[] cmdArgs) {
    String fullGrepContent = "";
    // Check if we have -r in our command
    boolean re = false;
    int size;
    String file = "";
    String sign = "";
    if (cmdArgs[cmdArgs.length - 2].equals(">")
        || cmdArgs[cmdArgs.length - 2].equals(">>")) {
      sign = cmdArgs[cmdArgs.length - 2];
      file = cmdArgs[cmdArgs.length - 1];
      re = true;
      size = cmdArgs.length - 2;
    } else {
      size = cmdArgs.length;
    }
    if (!cmdArgs[1].equals("-R")) {
      int i = 2;
      while (i < size) {
        IDirectory pathToDir = grepFile.getSpecificDirectory(cmdArgs[i]);
        List<IFile> fullFile = pathToDir.getAllChildFiles();
        for (IFile e : fullFile) {
          fullGrepContent = fullGrepContent + matchFile.allLine(e, cmdArgs[1]);
        }
        i++;
      }
    } else {
      // Recursively traverse breath first by queueing each item in the
      // direcctory, as well as its children.
      // For each iteration, we "expand" the top, that is get all its children
      // file and directory
      // File goes into fileQueue, dir goes into dirQueue.
      // After each read of dirQueue, check if the dirQueue is empty, then
      // repeat expanding the next time
      List<IDirectory> dirQueue = new ArrayList<>();
      List<IFile> fileQueue = new ArrayList<>();
      int i = 3;
      // Iterate through the path list
      while (i < size) {
        IDirectory pathToDir = grepFile.getSpecificDirectory(cmdArgs[i]);
        dirQueue.add(pathToDir);
        i++;
      }
      int queueI = 0;
      while (queueI < dirQueue.size()) {
        IDirectory candidate = dirQueue.get(queueI);
        List<IDirectory> candidateSubDir = candidate.getAllChildDir();
        List<IFile> candidateSubFiles = candidate.getAllChildFiles();
        dirQueue.addAll(candidateSubDir);
        fileQueue.addAll(candidateSubFiles);
        queueI++;

      }

      while (!fileQueue.isEmpty()) {
        IFile candidateFile = fileQueue.get(0);
        fullGrepContent =
            fullGrepContent + matchFile.allLine(candidateFile, cmdArgs[2]);
        fileQueue.remove(0);

      }

    }
    if (re) {
      redirect(fullGrepContent, sign, file);
    }
    return fullGrepContent;
  }
  
  /**
   * overrides toString to show string representation of grep
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: grep";
    String summary = "\nSummary: Prints any line of a file in the path of"
        + " a REGEX if (-R) is not given, it (-R) is present and if there"
        + " are any directories in the path of the REGEX, then "
        + "recursively traverses the directory\n"
        + "and, for all lines in all files that contain REGEX, prints the path "
        + "to the file\n";
    String use = "Use: \ngrep [-R] REGEX PATH ...  \nWhere [-R] is optional";
    String example =
        "Example: \n/#/: echo \"hello\" > outfile\n/#/: grep \"o\" outfile\n"
            + "hello";
    String result = name + summary + use + example;
    return result;
  }

}
