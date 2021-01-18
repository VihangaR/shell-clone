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

import driver.JCmdManager;

public class Popd extends Command {
  /**
   * Executes popd
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    Console c = new Console();
    String str = "";
    if(cmdArgs.length == 1) {
      // get the most recent path from directory stack
      str = Pushd.pop();
      // if there is such path
      if(!str.equals(null)) {
        String[] dir = str.split("#");
        // cd into that directory
        String[] command = new String[] {"cd", dir[1]};
        JCmdManager commandexec = new JCmdManager();
        commandexec.select(command);
      }
    }
    else {
        // display error message
        c.printMsg("popd doesn't take in parameters");
    }
  return "";
  }

  /**
   * overrides toString to show string representation of popd
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: popd";
    String summary =
        "\nSummary: remove the most recent directory saved on directory stack "
            + "and cd into that directory\n";
    String use = "Use: popd\n";
    String example =
        "Example:\n/#/hello/hi/bye/: pushd \n/#/hello/hi/bye/: cd .. "
            + "\n/#/hello/hi/: popd \n/#/hello/hi/bye/:\n";
    return name + summary + use + example;
  }
}
