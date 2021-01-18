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

import java.util.List;

public class Cp extends Command implements ICp {
  /**
   * HAS-A relationship with FolderOperation
   */
  private IFolderOperation LookUp = new FolderOperation(this.getFileSystem());
  /**
   * Declaring ParentSource; so that it can access it when needed
   */
  private IDirectory ParentSource;
  /**
   * Declaring intialFolder; so that it can access it when needed
   */
  private IDirectoryItems initialFolder;

  /**
   * Executing copy command here; this will call FileOperation which will feed
   * it with all the information abt the Source and Destination Files
   * 
   * @param cmdArgs user arguments
   * @return String contains any errors
   */
  public String exec(String[] cmdArgs) {
    String retValue = "";

    // Once the parent is obtained, remove the directory/file and add
    // it to the destination directory
    try {
      LookUp.handleOperation(cmdArgs);

      initialFolder = LookUp.getInitialFolder();
      IDirectoryItems destinationDir = LookUp.getDestinationDir();
      ParentSource = LookUp.getSourceParent();

      // 1. Write a method to handle the case when they both are files
      if (initialFolder instanceof IFile && destinationDir instanceof IFile) {
        this.FiletoFile(initialFolder, destinationDir);
      } else if (initialFolder instanceof IDirectory
          && destinationDir instanceof IDirectory) {
        this.DirtoDir(initialFolder, destinationDir);
      } else if (initialFolder instanceof IFile
          && destinationDir instanceof IDirectory) {

        this.FiletoDir(initialFolder, destinationDir);

      } else {
        retValue =
            "Invalid Operation: a directory cannot be copied to a file!\n";
      }

      // 2. Method when both are directories
      // 3. Source File and Destination Directory -> two cases
      // if the file does not exist in the destination directory; create file
      // and copy the contents
      // if the file exists call the previous method for file to file copying
      // 4. Source Directory to Destination File -> error



    } catch (IndexOutOfBoundsException e) {
      retValue = "Insufficient Arguments, refer man for usage\n";
    } catch (SelfDirectoryException e) {
      retValue =
          "Operation failed: Directory cannot be copied as a subdirectory to"
              + "itself\n";
    } catch (InvalidParentSourceFolder | InValidSourceFolderException
        | InvalidParentDestinationFolder e) {
      retValue = "Invalid Path\n";
    }
    return retValue;
  }

  /**
   * Ability to change the method of getting the Folders
   * 
   * @param folder of type FolderOperation which would contain new
   *        implementation of how Folders can be retrived from the command args
   */
  public void changeFolderOperation(IFolderOperation folder) {
    LookUp = folder;
  }

  /**
   * Getter for ParentSource
   * 
   * @return ParentSource
   */
  public IDirectory getParentSource() {
    return ParentSource;
  }

  /**
   * Getter for IntialSource
   * 
   * @return initialFolder
   */
  public IDirectoryItems getInitialSource() {
    return initialFolder;
  }

  /**
   * overrides toString to show string representation of copy
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: Copy";
    String summary = "\nSummary: "
        + "Copying a file or directory to another location in the FileSystem"
        + ". If the NEWPATH does not exist in the FileSystem, it is treated"
        + " as a directory.";
    String use = "\nUse: cp OLDPATH NEWPATH \n";
    String example = "Example:\n/#/:ls\n a b \n/#/: cp a b\n/#/: ls\n";
    String result = name + summary + use + example;
    return result;
  }

  private void FiletoFile(IDirectoryItems initialFolder,
      IDirectoryItems destinationDir) {
    // At this time it is safe to assume that all of these are valid
    ((IFile) destinationDir).setContent(((IFile) initialFolder).getContent());
  }

  private void DirtoDir(IDirectoryItems initialFolder,
      IDirectoryItems destinationDir) {
    String initialName = initialFolder.getName();
    if (getFileSystem().alreadyExists(initialName)) {
      this.removeChildDir(initialName, (IDirectory) destinationDir);
    }
    ((IDirectory) destinationDir).addChild((IDirectory) initialFolder);
  }

  private void FiletoDir(IDirectoryItems initialFolder,
      IDirectoryItems destinationDir) {
    IFile desFile =
        ((IDirectory) destinationDir).getChildFile(initialFolder.getName());
    if (desFile == null) {
      ((IDirectory) destinationDir).addChildFile((IFile) initialFolder);
    } else {
      this.FiletoFile((IFile) initialFolder, desFile);
    }
  }

  /**
   * Searches whether the Directory contains the specified child Directory
   * 
   * @param name the name of the child directory
   * 
   */
  private void removeChildDir(String name, IDirectory Source) {
    List<IDirectory> children = (List<IDirectory>) Source.getAllChildDir();
    if (children != null) {
      for (int item = 0; item < children.size(); item++) {
        if (children.get(item).getName().equals(name)) {
          children.remove(item);
          item = children.size();
        }
      }

    }

  }
}


