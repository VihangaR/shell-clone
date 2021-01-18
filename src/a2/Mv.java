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

public class Mv extends Command {
  /**
   * Declaring cp since it HAS-A relationship with Mv
   */
  private ICp copy = new Cp();

  /**
   * Executes Mv
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return Empty String if no errors are found
   */
  public String exec(String[] cmdArgs) {

    // executes copy
    String retValue = copy.exec(cmdArgs);
    // if there is no errors found in copy, then pop the initialFolder from
    // its parent to complete move
    if (retValue.equals("")) {
      IDirectory ParentSource = copy.getParentSource();
      IDirectoryItems initialFolder = copy.getInitialSource();
      if (initialFolder instanceof IFile) {
        ParentSource.removeChildFile((IFile) initialFolder);
      } else {
        ParentSource.removeChild((IDirectory) initialFolder);
      }

    }

    return retValue;
  }

  /**
   * Sets a different cp implementation; this will improve flexibility if there
   * are additional user requirements given
   * 
   * @param copy a different implementation
   */
  public void setDifferentCopy(ICp copy) {
    // Ability to change the implementation of copy which would help for
    // future purposes when copy is completely changed by the user's
    // requirements
    this.copy = copy;
  }

  /**
   * overrides toString to show string representation of cp
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: mv";
    String summary = "\nSummary: Move an item from one path to another path";
    String use = "\nUse: mv OLDPATH NEWPATH \nWhere OLDPATH is the path to "
        + "the directory of the item you want to move into NEWPATH";
    String example =
        "\nExample:\n/#/: mkdir home\n/#/: mkdir /home/folder\n/#/: echo "
            + "\"test file\" > /home/file\n/#/: mv /home/file /home/folder";
    return name + summary + use + example;
  }

}
