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
import org.junit.Before;
import org.junit.Test;
import a2.*;
import driver.*;

public class TestPopd {
  private Popd popd;
  private JCmdManager cmdexec;
  @Before
  public void setUp() throws Exception {
    popd = new Popd();
    cmdexec = new JCmdManager();

  }
  
  @Test
  public void testValid() {
    String[] mkdir = new String[] {"mkdir", "a"};
    cmdexec.select(mkdir);
    String[] pushd = new String[] {"pushd"};
    cmdexec.select(pushd);
    String[] cmdArgs = {"popd"};
    assertEquals("", popd.exec(cmdArgs));
  }

}
