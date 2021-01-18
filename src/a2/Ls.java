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
import java.util.List;
import a2.FileManager;

public class Ls extends Command {

  /**
   * Creates the result which will be print to the screen, each item should be
   * on a new line
   * 
   * @param myList the list of the file and directory names
   */
  private String buildString(ArrayList<String> myList) {
    String result = "";
    Collections.sort(myList);
    for (String item : myList) {
      result += item + "\n";
    }
    return result;
  }

  /**
   * Executes ls
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    String ret = "";
    boolean re = false;
    String file = "";
    String sign = "";
    if (cmdArgs.length == 1 || (cmdArgs.length == 3 && cmdArgs[2].contains(">"))) {
      if (cmdArgs.length == 3 && cmdArgs[2].contains(">")) {
        sign = cmdArgs[1];
        file = cmdArgs[2];
      }      
      ArrayList<String> result = new ArrayList<String>();
      IFileManager tempFileManager = FileManager.getInstance();
      // Gets all the children
      List<IDirectory> children = tempFileManager.getAllChildrenDir();
      List<IFile> fChildren = tempFileManager.getAllChildrenFile();
      // Loop through the children while obtaining the names and adding them
      // to the ArrayList
      for (IDirectory element : children) {
        result.add(element.getName());
      }
      for (IFile element : fChildren) {
        result.add(element.getName());
      }
      // Sort the ArrayList to alphabetical order
      Collections.sort(result);
      // Prints out the final string
      return buildString(result);
    } 
    else if (cmdArgs.length > 1) {
      if(cmdArgs[cmdArgs.length-2].contains(">")){
        re = true;
        sign = cmdArgs[cmdArgs.length-2];
        file = cmdArgs[cmdArgs.length-1];
      }
      if (cmdArgs[1].equals("-R")) {
    	int i = 2;
    	IFileManager grabFile = FileManager.getInstance();
    	List<IDirectory> dirQueue = new ArrayList<>();
		List<IFile> fileQueue = new ArrayList<>();
		String message = "";
		// Iterate through the path list
		while(i < cmdArgs.length) {
		  IDirectory pathToDir = (IDirectory) grabFile.getSpecificDirectory(cmdArgs[i]);
		  dirQueue.add(pathToDir);
		  i++;
		}
		if (i == 2)
		{
			IDirectory pathToDir = (IDirectory) grabFile.getSpecificDirectory("./");
			dirQueue.add(pathToDir);
		}
		int queueI = 0;
		while (queueI < dirQueue.size()) {
		  IDirectory candidate = dirQueue.get(queueI);
		  message = message + candidate.getName() + "\n";
		  List<IDirectory> candidateSubDir = candidate.getAllChildDir();
		  List<IFile> candidateSubFiles = candidate.getAllChildFiles();
		  dirQueue.addAll(candidateSubDir);
		  fileQueue.addAll(candidateSubFiles);
		  queueI ++;			
		}
		while (!fileQueue.isEmpty()) {
		  IFile candidateFile = fileQueue.get(0);
		  message = message + candidateFile.getName() + "\n";
		  fileQueue.remove(0);
		}
		ret = message;	  
      }
      else {
        int i;
        IFileManager tempFileManager = FileManager.getInstance();
        for (i = 1; i < cmdArgs.length; i++) {
          ArrayList<String> result = new ArrayList<String>();
          // Tries to get the specific directory or the specific file
          Directory pToDir = (Directory)tempFileManager.getSpecificDirectory(cmdArgs[i]);
          File pToFile = (File)tempFileManager.getSpecificFile(cmdArgs[i]);
          // If it's a path, go to the path and print out the names
          if (pToDir != null) {
            List<IDirectory> children = pToDir.getAllChildDir();
            List<IFile> fChildren = pToDir.getAllChildFiles();
            for (IDirectory element : children) {
              result.add(element.getName());
            }
            for (IFile element : fChildren) {
              result.add(element.getName());
            }
            Collections.sort(result);
            ret = cmdArgs[i] + ": \n" + buildString(result);
          }
          // If it's a file, print the original argument
          else if (pToFile != null) {
            ret = cmdArgs[i];
          }
        }
      }
    }
    if(re) {
      redirect(ret, sign, file);
    }
    return ret;
  }

  /**
   * overrides toString to show string representation of ls
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: ls";
    String summary = "\nSummary: Displays content of a file " + "or directory";
    String use = "\nUse: \nls (-R) [args ...] \nWhere [args ...] can be "
        + "path of file or directory "
        + "and -R is the option to recursively list all the subdirectories"
        + "; if File, \nthen ls displays the path of the file or if Directory,"
        + "then ls displays content (Files/Directories) inside Directory.";
    String example = "\nExample:\n/#/hello/: ls\n hi bye.txt\n/#/hello/: ls "
        + "bye.txt\nbye.txt\n";
    return name + summary + use + example;
  }
}
