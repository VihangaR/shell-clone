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

package driver;

import java.lang.reflect.InvocationTargetException;
import a2.*;
import a2.Number;



public class JCmdManager {
  /**
   * The purpose of this Class is to identify the specific command that the user
   * entered and facilitate it's execution This is the default constructor
   */

  /**
   * Creates a new console to be returned in getShowUser
   */
  private Console showUser = new Console();

  public JCmdManager() {}

  /**
   * Select method helps to identify a certain command (multiple forms) and
   * executes it
   * 
   * @param commandArgs The input of the user in the form of a string array
   * 
   */
  // Handles all the commands
  public int select(String[] commandArgs) {
    // Using try catch block to handle the case where the command does not exist
    String returnVal = "";
    try {
      Command command;
      // Check if the first character is a !, then call the !number instance
      if (commandArgs[0].contains("!")) {
        command = new Number();
      }
      else {
      // Creates a reference to a particular command
      command = getCommandInstance(commandArgs[0]);
      }
      // Uses polymorphism as it adapts based on the command arguments passed
      returnVal = command.exec(commandArgs);

      if (commandArgs[0].equals("pwd")) {
        returnVal+= "\n";
      }
    } catch (Exception ErrorHandler) {
      // System.out.println(ErrorHandler.getMessage());
      showUser.printMsg(ErrorHandler.getMessage());
    }
    
    showUser.printMsg(returnVal);
   

    return 0;
  }

  /**
   * Creates a reference to the base class (Command), but it refers to a
   * particular type of command by analyzing the user input. It also throws a
   * exception if there is no CMD found/implemented
   * 
   * @param cmdInput This is the command entered by the user in the form of str
   * @throws Exception When the CMD given is invalid, the method throws an
   *         Exception which is caught by Select and resolved
   */
  public Command getCommandInstance(String cmdInput) throws Exception {
    Command command = null;
    // Changing the case of the input to match command classes
    String commandType =
        cmdInput.substring(0, 1).toUpperCase() + cmdInput.substring(1);
    // Handles the case when the command is not implemented/invalid
    try {
      // Method that creates a instance of a command given by the user
      command = (Command) Class.forName("a2." + commandType)
          .getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException
        | ClassNotFoundException | IllegalArgumentException
        | InvocationTargetException | NoSuchMethodException
        | SecurityException e) {
      // Handles the case when the command given is invalid
      throw new ErrorHandler("CMD not found");
    }
    return command;
  }

  /**
   * returns the console to display contents
   * 
   * @return showUser the console to show user
   */
  public Console getShowUser() {
    return showUser;
  }
}

