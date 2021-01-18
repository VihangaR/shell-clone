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
import org.junit.Test;
import a2.*;
import driver.*;

/**
 * 
 * JCmdManager is powered by two methods (
 *
 */
public class TestJCmdManager {
  private JCmdManager CmdManager = new JCmdManager();


  @Test
  public void TestValidCdCommandInstance() throws Exception {
    String cmdArg = "cd";
    try {
      Command actual = CmdManager.getCommandInstance(cmdArg);
      String expectedName = "Cd";
      String actualName = actual.getClass().getSimpleName();
      assertEquals(expectedName, actualName);
    } catch (Exception e) {
      fail("Not the same command as user entered");
    }
  }

  @Test
  public void TestInValidCdCommandInstance() throws Exception {
    String cmdArg = "c";
    try {
      Command actual = CmdManager.getCommandInstance(cmdArg);
      String expectedName = "Cd";
      String actualName = actual.getClass().getSimpleName();
      assertEquals(expectedName, actualName);
    } catch (Exception ErrorHandler) {
      assertEquals("CMD not found", ErrorHandler.getMessage());
    }
  }

  @Test
  public void TestValidMkdirCommandInstance() throws Exception {
    String cmdArg = "mkdir";
    try {
      Command actual = CmdManager.getCommandInstance(cmdArg);
      String expectedName = "Mkdir";
      String actualName = actual.getClass().getSimpleName();
      assertEquals(expectedName, actualName);
    } catch (Exception e) {
      fail("Not the same command as user entered");
    }
  }

  @Test
  public void TestInValidMkdirCommandInstance() throws Exception {
    String cmdArg = "mk";
    try {
      Command actual = CmdManager.getCommandInstance(cmdArg);
      String expectedName = "Mkdir";
      String actualName = actual.getClass().getSimpleName();
      assertEquals(expectedName, actualName);
    } catch (Exception ErrorHandler) {
      assertEquals("CMD not found", ErrorHandler.getMessage());
    }
  }



}
