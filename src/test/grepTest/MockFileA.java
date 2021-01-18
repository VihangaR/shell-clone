// **********************************************************
// Assignment2:
// Student 1:
// UTORID:ravich68
// UT Student #: 1004019420
// Author: Hamsavardhini Ravichandran
//
// Student 2:
/// UTORID: liuheng7
// UT Student #: 1004076493
// Author: Jessie Liu
//
// Student 3:
// Utorid :leanh8
// UT Student #: 1004381064
// Author : Anh Le
//
// Student 4:
// Utorid :ratnas16
// UT Student #: 1002394642
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
import a2.*;

public class MockFileA extends MockDirectoryItems implements IFile{
	String myContent;
	
	public MockFileA()
	{
		super();
	}
	
	public String getContent() {
		return "This is file a";
	}
	
	public void setContent(String content)
	{
	}
	
	public void appendContent (String content)
	{
	}
}
