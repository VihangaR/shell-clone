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

import driver.JValidator;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 0 if no command
// 1 if valid command
// 2 if invalid command
// -1 if command is exit

public class JParser {


  /**
   * Holds the commands
   */
  private static ArrayList<String> commands = new ArrayList<String>();
  
  /**
   * Returns adds a command to the array list of commands
   */
  public static void addCommand(String cmd) {
    commands.add(cmd);
  }
  
  /**
   * The purpose of this class is to parse user's input; stripping spaces and
   * responsible for exit command
   * 
   * @param commandIn input string from the user
   * @return result An integer to identify whether the commands have executed
   *         successfully
   */
  public static int parse(String commandIn) {
    // if the command isn't !
    if(! (commandIn.contains("!"))) {
      // store the command
      commands.add(commandIn);
    }
    if (commandIn.length() > 3 && commandIn.substring(0, 4).equals("echo")) {

      String[] commandArgs = echoParser(commandIn);
      boolean isValid = JValidator.validate(commandArgs);
      if (isValid) {
        return 1;
      } else {
        return 2;
      }

    }
    // Strips the string
    else {
      commandIn = commandIn.trim();
      // Splits the whitespace
      String[] commandArgs = commandIn.split("\\s+");
      // If there's no command
      if (commandArgs.length == 0) {
        return 0;
      } else if (commandArgs[0].equals("exit")) {
        return -1;
      } else {
        // Validate the string here
        boolean isValid = JValidator.validate(commandArgs);
        if (isValid) {
          return 1;
        } else {
          return 2;
        }
      }
    }
  }

  /**
   * Returns an array list containing all the recent commands
   * 
   * @return commands An array that is used to print all the recent commands
   *         entered by the user
   */
  public static ArrayList<String> getCommands() {
    return commands;
  }

  /**
   * Takes in a command string and parse it by white space, retaining things
   * between quote
   * 
   * @param commandIn the command string
   * @return returns the parsed arguments
   */
  public static String[] echoParser(String commandIn) {
    String r = "([^\" ]+)|(\"([^\"]*)\")";
    // Compile regex to a pattern to be used by matcher
    Pattern p = Pattern.compile(r);
    Matcher commandParsing = p.matcher(commandIn);
    // Since string is not extensible, we use array list here
    ArrayList<String> parsedCommand = new ArrayList<String>();
    while (commandParsing.find()) {
      String matched1 = commandParsing.group(1);
      String matched3 = commandParsing.group(3);
      if (matched1 != null) {
        parsedCommand.add(matched1);
      } else if (matched3 != null) {
        parsedCommand.add(matched3);
      }
    }
    String[] commandArgs = parsedCommand.toArray(new String[0]);
    return commandArgs;
  }

}
