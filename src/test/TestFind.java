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

package test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import a2.*;
import driver.*;
import junit.framework.Assert;

public class TestFind {
  private Find find = new Find();

  @Test
  public void testValid() {
    String[] command = new String[] {"mkdir", "a"};
    JCmdManager commandexec = new JCmdManager();
    commandexec.select(command);
    String[] cmdArgs = {"find", "/", "-type", "d", "name", "\"a\""};
    assertEquals("/a/", find.exec(cmdArgs));
  }


}
