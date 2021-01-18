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
import a2.Directory;
import a2.File;

public class FileManager implements IFileManager{
  /**
   * Creates the root directory
   */
  private IDirectory rootDir = new Directory("/#");
  /**
   * Sets the current directory equal to the root directory
   */
  private IDirectory curDir = rootDir;
  /**
   * Creates singleReference
   */
  private static IFileManager singleReference = null;


  /**
   * Simple constructor for the FileManager
   * 
   * @param startingDir the starting directory of the FileManager
   */
  public FileManager(IDirectory startingDir) {
    curDir = startingDir;
  }

  /**
   * Gets the instance of the FileManager
   * 
   * @return singleReference pointer
   */
  public static IFileManager getInstance() {
    if (singleReference == null) {
      singleReference = new FileManager();
    }
    return singleReference;
  }

  /**
   * Gets all the children directories
   * 
   * @return returns the children directories of the current directory
   */
  public List<IDirectory> getAllChildrenDir() {
    return curDir.getAllChildDir();
  }

  /**
   * Gets all the children files
   * 
   * @return returns the children files of the current directory
   */
  public List<IFile> getAllChildrenFile() {
    // Returns all the files within the current directory
    return curDir.getAllChildFiles();
  }

  /**
   * Gets the current directory
   * 
   * @return returns the current directory
   */
  public IDirectory getCurDir() {
    return curDir;
  }
  
  private IDirectory getSpecificItemDir(String name, String type) {
    String[] splittedName = name.split("/+");
    IDirectory tempCur = curDir;
    int curLength = 0;
    int size;
    if(type.equals("d")) {
      size = splittedName.length - 1;
    }
    else {
      size = splittedName.length - 2;
    }
    while (curLength <= size) {
      if (splittedName[curLength].equals("..")) {
        IDirectory tempcur1 = tempCur.getParent();
        if (tempcur1 != null) {
          tempCur = tempcur1;
        }
      } 
      else if (splittedName[curLength].equals("")) {
        tempCur = rootDir;
      } 
      else if ((splittedName[curLength].equals("."))) {
      } 
      else {
        tempCur = tempCur.getChild(splittedName[curLength]);
      }
      curLength++;
    }
    return tempCur;
  }

  /**
   * Gets the specific directory, can take in either a directory name, relative
   * path or full path
   * 
   * @param name name of the path or directory
   * @return returns the directory based on the name of the path
   */
  public IDirectory getSpecificDirectory(String name) {
    IDirectory d = getSpecificItemDir(name, "d");
    return d;
  }
  /**
   * Gets the specific file based on the name, can be a file or the path to a
   * file
   * 
   * @param name name of the file or path
   * @return returns the file
   */
  public IFile getSpecificFile(String name) {
    IDirectory d = getSpecificItemDir(name, "f");
    String[] splittedName = name.split("/+");
    IFile f = d.getChildFile(splittedName[splittedName.length - 1]);
    return f;
  }
  /**
   * Gets the full path based on the position of the current directory
   * 
   * @return the full path of the current directory
   */
  public String getFullPath() {
    return curDir.getPath();
  }

  /**
   * Private constructor
   */
  private FileManager() {}

  /**
   * Sets the current directory
   * 
   * @param currDir the current directory to be set equal to
   */
  public void setCurrentDir(IDirectory currDir) {
    curDir = currDir;
  }

  /**
   * Gets the current directory
   * 
   * @return currDir the current directory
   */
  public IDirectory getCurrentDir() {
    return curDir;
  }

  /**
   * Adds the directory to the path
   * 
   * @param path adds the directory to the current directory
   */
  public void addDirectoryToPath(String path) {
    IDirectory newDir = new Directory(curDir, path);
    curDir.addChild(newDir);
  }

  /**
   * Gets the parent directory
   * 
   * @return returns the parent directory of the current directory
   */
  public IDirectory getParentDirectory() {
    return curDir.getParent();
  }

  /**
   * Gets the root directory
   * 
   * @return returns the root directory
   */
  public IDirectory getRootDirectory() {
    while (curDir.getName() != "/#") {
      curDir = curDir.getParent();
    }
    return curDir;
  }

  /**
   * Checks if a file or directory already exists, used when creating files or
   * directories
   * 
   * @param name name of the file or directory
   * @return returns true or false depending on if it exists or not
   */
  public boolean alreadyExists(String name) {
    IDirectory tempCur = curDir;
    IFileManager tempFileManager = FileManager.getInstance();
    String[] splittedName = name.split("/+");
    if (splittedName.length == 1) {
      if (tempCur.getChildFile(name) == null && tempCur.getChild(name) == null){
        return false;
      } else {
        return true;
      }
    } else if (splittedName.length > 1) {
      int dirIndex = name.lastIndexOf('/');
      IDirectory target = tempFileManager
          .getSpecificDirectory(name.substring(0, dirIndex));
      if (target == null) {
        System.out.println("The path does not exist");
        return true;
      } else {
        tempFileManager.setCurrentDir(target);
        if (curDir.getChildFile(name.substring(dirIndex + 1)) == null &&
            curDir.getChild(name.substring(dirIndex + 1)) == null) {
          tempFileManager.setCurrentDir(tempCur);
          return false;
        } else {
          tempFileManager.setCurrentDir(tempCur);
          return true;
        }
      }
    }
    return false;
  }

  

  /**
   * Adds the file to the given path
   * 
   * @param name name of the path
   * @param input the file to be added to the path
   */
  public void addFileToPath(String name, IFile input) {
    String[] splittedName = name.split("/+");
    IDirectory tempCur = curDir;
    int i = 0;
    while (i <= splittedName.length - 2) {
      if (splittedName[i].equals("..")) {
        IDirectory tempcur1 = tempCur.getParent();
        if (tempcur1 != null) {
          tempCur = tempcur1;
        }
      } else if (splittedName[i].equals("")) {
        tempCur = rootDir;
      } else if ((splittedName[i].equals("."))) {
      } else {
        tempCur = tempCur.getChild(splittedName[i]);
      }
      i = i + 1;
    }
    tempCur.addChildFile((IFile) input);
  }

}
