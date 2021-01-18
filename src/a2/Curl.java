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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Scanner;
import a2.Command;

public class Curl extends Command {
  public String exec(String[] cmdArgs) {
    /**
     * Executes curl
     * 
     * @param cmdArgs the array of the input command splitted by spaces
     * @return Empty String, since curl has no output
     */
    String text = "";
    Command command = null;
    try {
      // Creates a new URL using the given argument
      URL url = new URL(cmdArgs[1]);
      String fileName = cmdArgs[1].substring(cmdArgs[1].lastIndexOf('/') + 1);
      fileName = fileName.replaceAll("[^a-zA-Z0-9.]", "");
      // Opens it in a scanner so it can be parsed through
      Scanner scanner = new Scanner(url.openStream());
      // Add each line to a string so it can be put into a file
      while (scanner.hasNext()) {
        text += scanner.nextLine() + "\n";
      }
      // Use the already made echo function which was created in a2a
      command = (Command) Class.forName("a2.Echo").getDeclaredConstructor()
          .newInstance();
      String[] commands = new String[] {"echo",
          text.substring(0, text.length() - 2), ">", fileName};
      command.exec(commands);
      scanner.close();
    } catch (IOException | InstantiationException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException
        | ClassNotFoundException e) {
      System.out.println("The text from the file could not be grabbed");
    }
    return "";
  }

  /**
   * overrides toString to show string representation of curl
   * 
   * @return result the String representation
   */
  public String toString() {
    String name = "\nName: curl";
    String summary = "\nSummary: Gets and creates a file of a given URL";
    String use =
        "\nUse: curl link \nWhere link is a link to a html file, text file or "
            + "any other type of readable file";
    String example =
        "\nExample:\n/#/: curl http://www.cs.cmu.edu/~spok/grimmtmp/073.txt";
    return name + summary + use + example;
  }
}
