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

public class TestHistory {
  private IFileManager fs;
  private History history;
  private JCmdManager c;
  @Before
  public void setUp() throws Exception {
    fs = new MockFileSystem();
    history = new History();
    c = new JCmdManager();
  }
  @Test
  public void testHistory() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history"};
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, history.exec(h));
  }
  
  @Test
  public void testHistoryRedirectOutput() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history", ">", "file"};
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, history.exec(h));
  }
  
  @Test
  public void testHistoryRedirectOutputFile() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history", ">", "file"};
    c.select(h);
    String[] c = new String[] {"cat", "file"};
    Cat cat = new Cat();
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, cat.exec(c));
  }

  @Test
  public void testHistoryParameter() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history", "3"};
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, history.exec(h));
  }
  
  @Test
  public void testHistoryParameterRedirect() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history", "3", ">", "file"};
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, history.exec(h));
  }
  
  @Test
  public void testHistoryParameterRedirectFile() {
    String[] mkdir = new String[] {"mkdir", "a"};
    c.select(mkdir);
    String[] cd = new String[] {"cd", "a"};
    c.select(cd);
    String[] h = new String[] {"history", "3", ">", "file"};
    c.select(h);
    String[] c = new String[] {"cat", "file"};
    Cat cat = new Cat();
    String expect = "1. mkdir a\n2. cd a\n3. history\n";
    assertEquals(expect, cat.exec(c));
  }
}
