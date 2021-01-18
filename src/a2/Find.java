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

public class Find extends Command {
  /**
   * Executes find
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    String retValue = "";
    boolean re = false;
    String sign = "";
    String file = "";
    int len = cmdArgs.length;
    String name;
    String type;
    int size;
    if (cmdArgs.length >= 6) {
      if(cmdArgs[len-2].equals(">") || cmdArgs[len-2].equals(">>")) {
        re = true;
        sign = cmdArgs[len-2];
        file = cmdArgs[len-1];
        type = cmdArgs[len - 5];
        name = cmdArgs[len - 3].replace("\"", "");
        size = cmdArgs.length - 7;
      }
      else {
        type = cmdArgs[len - 3];
        name = cmdArgs[len - 1].replace("\"", "");
        size = cmdArgs.length - 5;
      }
      // get the type and name of the item to find
      // get the number of directories to search
      // for every given absolute path of a directory
      for (int j = 1; j <= size; j++) {
        // if we want to find a child directory
        if (type.equals("d")) {
          // get all the child directories in this directory
          List<IDirectory> d = folders(cmdArgs[j]);
          // for every child directory
          for (int i = 0; i < d.size(); i++) {
            // if this is the child directory we want to find
            if (d.get(i).getName().equals(name)) {
              // print the absolute path of this child directory
              retValue += (cmdArgs[j] + d.get(i).getName() + "/");
            }
            retValue += "\n";
          }
        }
        // if we want to find a file
        else if (type.equals("t")) {
          // get all the files in this directory
          List<IFile> f = files(cmdArgs[j]);
          // for every file
          for (int i = 0; i < f.size(); i++) {
            // if this is the file we want to find
            if (f.get(i).getName().equals(name)) {
              // print the absolute path of this file
              retValue += (cmdArgs[j] + f.get(i).getName() + "/");
            }
            retValue += "\n";
          }
        }
      }
      if(re) {
        redirect(retValue, sign, file);
      }
    }
    else {
      retValue = "invalid format";
    }
    return retValue;
  }

  /**
   * finds child directories in given absolute path of a directory
   * 
   * @param directory the absolute path of the directory to search in
   * @return f arraylist of child directories
   */
  private List<IDirectory> folders(String directory) {
    // initialize f
    List<IDirectory> f = new ArrayList<IDirectory>();
    // get the file manager
    FileManager fm = (FileManager) getFileSystem();
    // get the directory at the absolute path
    IDirectory d = fm.getSpecificDirectory(directory);
    // get the child directories of the directory
    f = d.getAllChildDir();
    return f;
  }

  /**
   * finds files in given directory
   * 
   * @param directory the directory to search in
   * @return f arraylist of files in this directory
   */
  private List<IFile> files(String directory) {
    // initialize f
    List<IFile> f = new ArrayList<IFile>();
    // get the file manager
    FileManager fm = (FileManager)getFileSystem();
    // get the directory at the absolute path
    IDirectory d = fm.getSpecificDirectory(directory);
    // get the files of the directory
    f = d.getAllChildFiles();
    return f;
  }

  /**
   * overrides toString to show string representation of find
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: find";
    String summary = "\nSummary: Find recursively descends the directory tree"
        + "for each path listed, finding whether each file/dir exists in"
        + "the FileSystem";
    String use = "\nUse: find " + "path ... -type [f|d] -name expression. ";
    String example =
        "\nExample: \n/#/: ls \ndir1 dir2 dir3 \n/#/: cd dir1\n/#/: "
            + "ls\noutfile1" + "\n/#/: find  /dir1 -type f "
            + "-name \"outfile1\n/dir1/outfile1\n";
    String result = name + summary + use + example;
    return result;
  }
}
