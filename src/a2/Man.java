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

public class Man extends Command {
  /**
   * Executes man
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return 0 symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    // using an instance of the CmdManager class
    // Bringing an instance of the console to print to user
    // In case there are no CMD given to man
    
    String retValue;
    if (cmdArgs.length == 1| cmdArgs.length == 3) {
      retValue = ("What manual page do you want?");
    } else {
      // If there is a CMD, then check whether it is for Exit
      String infoCmd = cmdArgs[1];
      if (!infoCmd.equals("exit")) {
        JCmdManager commandexec = new JCmdManager();
        Command command;
        try {
          // Gets the instance of the command from the JCmdManager instance
          command = commandexec.getCommandInstance(infoCmd);
          // Printing the message to the User via console
          retValue = (command.toString());
          if (cmdArgs.length == 3) {
            redirect(retValue, cmdArgs[1], cmdArgs[2]);
          }
        } catch (Exception ErrorHandler) {
          retValue = (ErrorHandler.getMessage());
        }
      } else {
        // prints information about the exit command
        retValue = ((this.exitToString()));
      }
    }
    return retValue;
  }

  /**
   * overrides toString to show string representation of man
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: man";
    String summary = "\nSummary: Displays manual pages for commands";
    String use = "\nUse: man [CMD]\nWhere [CMD] is any command";
    Pwd tempPwd = new Pwd();
    String example = "\nExample:\n/#/: man pwd\n" + tempPwd.toString();
    return name + summary + use + example;
  }

  /**
   * overrides toString to show string representation of exit
   * 
   * @return result the String representation
   */
  public String exitToString() {
    String name = "\nName: exit";
    String summary = "\nSummary: terminates Shell";
    String use = "\nUse: exit";
    String example = "\nExample:\n/#/: exit\n";
    return name + summary + use + example;
  }

}
