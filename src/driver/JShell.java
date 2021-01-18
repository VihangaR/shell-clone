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

import java.util.Scanner;
import driver.JParser;
import a2.Pwd;

public class JShell {
  /**
   * The purpose of JShell is to receive input/commands from the user and
   * process the input through the InputParser
   * 
   * @param args command line arguments
   */

  public static void main(String[] args) {
    // Created an instance of PWD because we will always be printing the
    // full path in the shell
    Pwd pwdInstance = new Pwd();
    // Create new Scanner class
    Scanner keyIn = new Scanner(System.in);
    // Stores user input
    String userInput;
    // Print current working directory
    System.out.print(pwdInstance.exec(args));
    System.out.print(": ");
    // Read the command from input
    userInput = keyIn.nextLine();
    int status = JParser.parse(userInput);
    while (status != -1) {
      System.out.print(pwdInstance.exec(args));
      System.out.print(": ");
      userInput = keyIn.nextLine();
      status = JParser.parse(userInput);
    }
    // closed the Standard input
    keyIn.close();
  }


}
