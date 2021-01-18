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
import a2.Number;

public class TestMan {

  private Man tempMan = new Man();

  @Test
  public void testValidCd() {
    // Testing whether the given valid CMD executes in Man
    String[] cmdArgs = {"man", "cd"};
    assertEquals(
        "\nName: cd" + "\nSummary: Changes the working directory in shell"
            + "\nUse: cd [args ...] \nWhere [args ...] can either be a path"
            + "(both absolute and relative) or null (returns to parent dir) "

            + "\nExample:\n/#/: ls\nnewfolder tempfolder\n/#/: cd newfolder\n"
            + "/#/newfolder: \n",
        tempMan.exec(cmdArgs));
  }

  @Test
  public void testFalseCmd() throws Exception {
    String[] cmdArgs = {"man", "hello"};
    try {
      tempMan.exec(cmdArgs);
    } catch (Exception ErrorHandler) {
      assertEquals("CMD not found", ErrorHandler.getMessage());
    }

  }


  @Test
  public void testInvalidMan() {
    // Testing whether the given valid CMD executes in Man
    String[] cmdArgs = {"man"};
    assertEquals("What manual page do you want?", tempMan.exec(cmdArgs));
  }

  /**
   * Testing toString() methods for man
   */
  @Test
  public void testValidMkdirtoString() {
    Mkdir curMkdir = new Mkdir();
    String expected = "\nName: mkdir" + "\nSummary: Creates Directories"
        + "\nUse: mkdir [args ...]\nWhere [args ...] " + "can be absolute or"
        + " relative path specifiying a name"
        + "\nExample\n/#/: ls\n/#/: mkdir newfolder\n/#/: " + "ls\nnewfolder\n";
    assertEquals(expected, curMkdir.toString());
  }

  @Test
  public void testValidCdtoString() {
    Cd curCd = new Cd();
    String expected =
        "\nName: cd" + "\nSummary: Changes the working directory in shell"
            + "\nUse: cd [args ...] \nWhere [args ...] can either be a path"
            + "(both absolute and relative) or null (returns to parent dir) "

            + "\nExample:\n/#/: ls\nnewfolder tempfolder\n/#/: cd newfolder\n"
            + "/#/newfolder: \n";
    assertEquals(expected, curCd.toString());
  }


  @Test
  public void testValidPwdtoString() {
    Pwd curPwd = new Pwd();
    String expected = "\nName: pwd" +

        "\nSummary: Displays the absolute path name of the "
        + "current working directory.\n" + "Use: pwd \n"
        + "Example:\n/#/hello/hi/bye/: pwd\n/#/hello/hi/bye/\n";
    assertEquals(expected, curPwd.toString());
  }

  @Test
  public void testValidPushdtoString() {
    Pushd curPushd = new Pushd();
    String expected = "\nName: pushd"
        + "\nSummary: saves the current directory on directory stack"
        + "Use: \npushd" + "Example:\n/#/hello/hi/bye/: pushd\n";
    assertEquals(expected, curPushd.toString());
  }

  @Test
  public void testValidPopdtoString() {
    Popd curPopd = new Popd();
    String expected = "\nName: popd"

        + "\nSummary: remove the most recent directory saved on "
        + "directory stack " + "and cd into that directory\n" + "Use: popd\n"
        + "Example:\n/#/hello/hi/bye/: pushd \n/#/hello/hi/bye/: cd .. "
        + "\n/#/hello/hi/: popd \n/#/hello/hi/bye/:\n";
    assertEquals(expected, curPopd.toString());
  }

  @Test
  public void testValidHistorytoString() {
    History curHistory = new History();
    String expected = "\nName: history"
        + "\nSummary: Displays nth recent commands, if no n is given"
        + " display all commands called"
        + "Use: \nhistory [args ...] \nWhere [args ...] is an integer n"
        + " such that the most nth recent commands are called"
        + "Example:\n/#/hello/hi/bye/: pwd\n/#/hello/hi/bye/\n 1. pwd";
    assertEquals(expected, curHistory.toString());
  }

  @Test
  public void testValidCattoString() {
    Cat curCat = new Cat();
    String expected = "\nName: cat" + "\nSummary: concatentate and print files"
        + "\nUse:  Reads files sequentially, writing them to the" + "console"
        + "\nExample:\n/#/: ls\nfile1 file2\n/#/: cat file1 file2\n"
        + "Content from file1\n\nContent from File2\n";
    assertEquals(expected, curCat.toString());
  }

  @Test
  public void testValidEchotoString() {
    Echo curEcho = new Echo();
    String expected = "\nName: echo"
        + "\nSummary: if only a string is passed, print the string"
        + "\nif in write mode with given string, and filename, make a"
        + " file with the string"
        + "\nif file doesn't exist. if it does, overwrite the file"
        + "\nif in append mode, if file with given filename exists, append"
        + " the given string to that file"
        + "\nUse: echo \"str\" where str is the string, print str"
        + "\necho echo \"str\" > where str is the string, filename is the name"
        + " of file to write in, if file already exists, overwrite, if not,"
        + "create a new file with filename and append \"str\" to it"
        + "\nExample:\n/#/hello/hi/: echo \"Hello\" > file"
        + "\n/#/hello/hi/: cat file \n/#/hello/hi/: "
        + "\"Hello\" \n/#/hello/hi/:\n";
    assertEquals(expected, curEcho.toString());
  }

  @Test
  public void testValidFindtoString() {
    Find curFind = new Find();
    String expected = "\nName: find"
        + "\nSummary: Find recursively descends the directory tree"
        + "for each path listed, finding whether each file/dir exists in"
        + "the FileSystem" + "\nUse: find "
        + "path ... -type [f|d] -name expression. "
        + "\nExample: \n/#/: ls \ndir1 dir2 dir3 \n/#/: cd dir1\n/#/: "
        + "ls\noutfile1" + "\n/#/: find  /dir1 -type f "
        + "-name \"outfile1\n/dir1/outfile1\n";
    assertEquals(expected, curFind.toString());
  }

  @Test
  public void testValidTreetoString() {
    Tree curTree = new Tree();
    String expected = "\nName: Tree" + "\nSummary: "
        + "From the root directory (/#/), the tree command displays the"
        + " entire file system as a tree." + "\nUse: tree \n"
        + "Example:\n/#/:tree\n    /#/\n       A\n       B\nif"
        + " A and B are the only directories in the parent directory";
    assertEquals(expected, curTree.toString());

  }

  @Test
  public void testValidCptoString() {
    Cp curCp = new Cp();
    String expected = "\nName: Copy";
    String summary = "\nSummary: "
        + "Copying a file or directory to another location in the FileSystem"
        + ". If the NEWPATH does not exist in the FileSystem, it is treated"
        + " as a directory.";
    String use = "\nUse: cp OLDPATH NEWPATH \n";
    String example = "Example:\n/#/:ls\n a b \n/#/: cp a b\n/#/: ls\n";
    expected += summary + use + example;
    assertEquals(expected, curCp.toString());

  }

  @Test
  public void testValidCurltoString() {
    Curl curCurl = new Curl();
    String expected = "\nName: curl";
    String summary = "\nSummary: Gets and creates a file of a given URL";
    String use =
        "\nUse: curl link \nWhere link is a link to a html file, text file or "
            + "any other type of readable file";
    String example =
        "\nExample:\n/#/: curl http://www.cs.cmu.edu/~spok/grimmtmp/073.txt";
    expected += summary + use + example;
    assertEquals(expected, curCurl.toString());

  }

  @Test
  public void testValidGreptoString() {
    Grep curGrep = new Grep();
    String expected = "\nName: grep";
    String summary = "\nSummary: Prints any line of a file in the path of"
        + " a REGEX if (-R) is not given, it (-R) is present and if there"
        + " are any directories in the path of the REGEX, then "
        + "recursively traverses the directory\n"
        + "and, for all lines in all files that contain REGEX, "
        + "prints the path " + "to the file\n";
    String use = "Use: \ngrep [-R] REGEX PATH ...  \nWhere [-R] is optional";
    String example =
        "Example: \n/#/: echo \"hello\" > outfile\n/#/: grep \"o\" outfile\n"
            + "hello";
    expected += summary + use + example;
    assertEquals(expected, curGrep.toString());

  }

  @Test
  public void testValidNumbertoString() {
    Number curNum = new Number();
    String expected = "\nName: !";
    String summary = "\nSummary: given n, gets the nth command in history and"
        + " executes it";
    String use = "\nUse: \n!n \nWhere n can be any integer >= 1 ";
    String example =
        "\nExample:\n/#/: mkdir a" + "\n/#/: ls\na\n/#/: !2" + "\na\n";
    expected += summary + use + example;
    assertEquals(expected, curNum.toString());

  }
}
