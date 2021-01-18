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

import driver.JParser;
import java.util.ArrayList;

public class History extends Command {
  /**
   * Executes history
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return result the nth recent commands given n or the whole history
   */
  public String exec(String[] cmdArgs) {
    String result = "";
    // get commands
    ArrayList<String> commands = JParser.getCommands();
    // if there are no parameters passed
    if (cmdArgs.length == 1 || cmdArgs.length == 3) {
      // get all the commands
      for (int i = 0; i < commands.size(); i++) {
        result += (i + 1) + ". " + commands.get(i) + "\n";
      }
      // if redirection is called
      if(cmdArgs.length == 3) {
        // redirect
        String sign = cmdArgs[1];
        String file = cmdArgs[2];
        redirect(result, sign, file);
      }
    } 
    else {
      // if a number n is passed
      int n = Integer.parseInt(cmdArgs[1]);
      // get the nth recent commands
      for (int i = commands.size() - n; i < commands.size(); i++) {
        result += (i + 1) + ". " + commands.get(i) + "\n";
      }
      // if redirection is called
      if(cmdArgs.length == 4) {
        // redirect
        String sign = cmdArgs[1];
        String file = cmdArgs[2];
        redirect(result, sign, file);
      }
    }
    return result;
  }


  /**
   * overrides toString to show string representation of history
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: history";
    String summary = "\nSummary: Displays nth recent commands, if no n is given"
        + " display all commands called";
    String use = "Use: \nhistory [args ...] \nWhere [args ...] is an integer n"
        + " such that the most nth recent commands are called";
    String example =
        "Example:\n/#/hello/hi/bye/: pwd\n/#/hello/hi/bye/\n 1. pwd";
    String result = name + summary + use + example;
    return result;
  }
}
