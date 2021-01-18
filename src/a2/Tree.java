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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import a2.Command;
import driver.JCmdManager;

public class Tree extends Command {
  /**
   * Executes tree
   * 
   * @param cmdArgs the array of the input command split by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    // initialize tree
    String tree = "/";
    // get file manager
    IFileManager tempManager = FileManager.getInstance();
    String curDirectory = tempManager.getFullPath();
    if (curDirectory.contains("/#")) {
      curDirectory = curDirectory.substring(2);
    }
    // get root directory, the directories and files of the root directory
    IDirectory rootDir = tempManager.getRootDirectory();
    List<IDirectory> childDir = rootDir.getAllChildDir();
    List<IFile> childFile = rootDir.getAllChildFiles();
    // print the tree for them
    tree += drawTree(rootDir, childDir, childFile, " ") + "\n";
    //showUser.printMsg(tree);
    // get current directory, and cd into it
    Cd tempCd = new Cd();
    String[] curCmdArgs = {"cd", curDirectory};
    tempCd.exec(curCmdArgs);
    if(cmdArgs.length == 3) {
      String sign = cmdArgs[1];
      String file = cmdArgs[2];
      redirect(tree, sign, file);

    }
    return tree;
  }

  /**
   * Given current directory, list of directories in current directory, and list
   * of files in current directory, and string of spaces, return a visual
   * representation of the tree
   * 
   * @param rootDir current directory
   * @param childDir list of directories in current directory
   * @param childFile list of files in current directory
   * @param spaces the spaces needed to indent
   * @return tree the visual representation of tree stored in a string
   */
  private String drawTree(IDirectory rootDir, List<IDirectory> childDir,
      List<IFile> childFile, String spaces) {
    // initialize tree to be empty
    String tree = "";
    int fileSize = childFile.size();
    // if there's are files
    if (fileSize != 0) {
      List<String> alphaFile = new ArrayList<String>();
      // for every file
      for (int item = 0; item < childFile.size(); item++) {
        // indent it to the correct number of spaces and add it to tree
        alphaFile.add(childFile.get(item).getName());
      }
      Collections.sort(alphaFile);
      for (int item = 0; item < alphaFile.size(); item++) {
        tree += "\n" + spaces + alphaFile.get(item);
      }
    }
    int dirSize = childDir.size();
    // if there are directories
    List<IDirectory> alphaDir = this.getAlphaDir(childDir);
    if (dirSize != 0) {
      // for every directory
      for (int item = 0; item < alphaDir.size(); item++) {
        // indent it to the correct number of spaces and add it to tree
        tree += "\n" + spaces + alphaDir.get(item).getName();
        // repeated do this for every directory and file in this directory
        IDirectory newRootDir = alphaDir.get(item);
        List<IDirectory> newChildDir = newRootDir.getAllChildDir();
        List<IFile> newChildFile = newRootDir.getAllChildFiles();
        tree += drawTree(newRootDir, newChildDir, newChildFile, spaces + " ");
      }
    }
    return tree;
  }

  /**
   * overrides toString to show string representation of tree
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: Tree";
    String summary = "\nSummary: "
        + "From the root directory (/#/), the tree command displays the"
        + " entire file system as a tree.";
    String use = "\nUse: tree \n";
    String example = "Example:\n/#/:tree\n    /#/\n       A\n       B\nif"
        + " A and B are the only directories in the parent directory";
    String result = name + summary + use + example;
    return result;
  }

  /**
   * Given a List of Directories, this method sorts according to ascending
   * alphabetical order
   * 
   * @param childDir the list containing all child Directories of a specific
   *        parent Directory
   * @return childDir an alphabetic sorting of child Directories
   */

  private List<IDirectory> getAlphaDir(List<IDirectory> childDir) {
    // Creating a comparator in order to facilitate the comparison of two
    // Directory objects from the List
    Collections.sort(childDir, new Comparator<IDirectory>() {
      public int compare(IDirectory dir1, IDirectory dir2) {
        // Returns an integer that signifies the result of comparison
        return dir1.getName().compareTo(dir2.getName());
      }
    });
    return childDir;
  }
}
