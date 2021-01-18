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

import java.lang.reflect.Array;
import java.util.Arrays;
import a2.InvalidParentDestinationFolder;

public class FolderOperation implements IFolderOperation {
  /**
   * Declaring instance variables Dependency injection design pattern is used
   * here as FolderOperation will not know its dependency until when the
   * constructor is called injecting a FileSystem from outside
   */
  private IFileManager FileSystem;
  private IDirectory ParentSource;
  private IDirectoryItems InitialFolder;
  private IDirectoryItems DestinationDir;
  private IDirectory ParentDestin;

  /**
   * Constructor for FolderOperation
   * 
   * @param FileSystem the File System used to perform searches/operations
   */
  public FolderOperation(IFileManager fileSystem) {
    // Following the dependency injection pattern here
    this.FileSystem = fileSystem;
  }

  /**
   * Handle Operation will throw exceptions depending on the paths given
   * 
   * @param cmdArgs raw input from the user
   */
  @Override
  public void handleOperation(String[] cmdArgs)
      throws InvalidParentDestinationFolder, InvalidParentSourceFolder,
      SelfDirectoryException, InValidSourceFolderException {

    // 1. Check whether the Source file/directory exists; if not throw an
    // exception
    ParentSource = this.findParent(cmdArgs[1].split("/"));
    ParentDestin = this.findParent(cmdArgs[2].split("/"));
    if (ParentSource == null) {
      throw new InvalidParentSourceFolder();
    }
    if (ParentDestin == null) {
      throw new InvalidParentDestinationFolder();
    }
    // 2. Determine the type of DirectoryItem (IDirectory or IFile item)
    InitialFolder = this.findChild(cmdArgs[1]);
    DestinationDir = this.findChild(cmdArgs[2]);

    if (InitialFolder == null) {
      throw new InValidSourceFolderException();
    }
    String[] destPath = cmdArgs[2].split("/");
    String name = destPath[destPath.length - 1];
    // if there is no destination; then assume that it is a directory and
    // change the name of its parent directory
    if (DestinationDir == null) {
      validateDestination((IDirectory) DestinationDir, name);
    }
    if (DestinationDir.equals(InitialFolder)) {
      throw new SelfDirectoryException();
    }
  }


  private void validateDestination(IDirectory destination, String name)
      throws InvalidParentSourceFolder {
    // An Assumption is made here: when there is an invalid Destination Folder
    // given, assume that it is a directory
    if (destination == null && !ParentDestin.getName().equals("/#")) {
      ParentDestin.setName(name);
      DestinationDir = ParentDestin;
    } else {
      throw new InvalidParentSourceFolder();
    }


  }

  /**
   * Finds the child for the given path
   * 
   * @return Directory corresponding to the path goiven
   */
  public IDirectoryItems findChild(String path) {

    IFile itemFile = FileSystem.getSpecificFile(path);
    IDirectory itemDir = FileSystem.getSpecificDirectory(path);
    IDirectoryItems retCorrect =
        ((itemFile == null) ? ((itemDir == null) ? null : itemDir) : itemFile);;
    return retCorrect;
  }

  /**
   * Getter for ParentSource
   * 
   * @return ParentSource
   */
  @Override
  public IDirectory getSourceParent() {

    return ParentSource;
  }

  /**
   * Getter for Destination Parent
   * 
   * @return Parentdestination
   */
  @Override
  public IDirectory getParent() {

    return ParentDestin;
  }

  /**
   * Getter for DestinationDir
   * 
   * @return Destination Dir is returned
   */
  @Override
  public IDirectoryItems getDestinationDir() {

    return DestinationDir;
  }

  /**
   * Getter for Initial/the File to be copied/moved
   * 
   * @return initialFolder
   */
  @Override
  public IDirectoryItems getInitialFolder() {

    return InitialFolder;
  }


  private IDirectory findParent(String[] srcPath) {
    // if the length is 1 then the user is referring to the current directory
    IDirectory retValue;
    if (srcPath.length == 1) {
      retValue = FileSystem.getCurDir();
    } else {
      String[] ParentPath = Arrays.copyOf(srcPath, srcPath.length - 1);
      try {
        retValue =
            FileSystem.getSpecificDirectory(String.join("/", ParentPath));
      } catch (NullPointerException e) {
        retValue = null;
      }

    }
    return retValue;
  }


}
