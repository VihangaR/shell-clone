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
import driver.JParser;

public class Number extends Command{
  
  /**
   * Executes !
   * 
   * @param cmdArgs the array of the input command splitted by spaces
   * @return "" symbolizing successfully executed
   */
  public String exec(String[] cmdArgs) {
    if(cmdArgs.length == 1 || cmdArgs.length == 3 && cmdArgs[1].contains(">")) {
      // get the number n
      String[] args = cmdArgs[0].split("!");
      String input = args[1];
      // make n int
      int n = Integer.parseInt(input);
      // get the nth command in history
      String command = JParser.getCommands().get(n-1);
      // add command to list of commands in hsitory
      JParser.addCommand(command);
      // execute the command
      String[] newArgs = command.split(" ");
      JCmdManager commandexec = new JCmdManager();
      commandexec.select(newArgs);
    }
    return "";
  }
  
  /**
   * overrides toString to show string representation of !
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: !";
    String summary = "\nSummary: given n, gets the nth command in history and" +
    " executes it";
    String use = "\nUse: \n!n \nWhere n can be any integer >= 1 ";
    String example = "\nExample:\n/#/: mkdir a"+"\n/#/: ls\na\n/#/: !2"
        + "\na\n";
    return name + summary + use + example;
  }
}
