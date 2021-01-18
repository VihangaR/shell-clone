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
import java.util.ArrayList;
import java.util.List;

import a2.*;
import test.*;

public class MockDirectoryA extends MockDirectoryItems implements IDirectory{
	public MockDirectoryA()
	{
		super();
	}
	
	public String getPath()
	{
		return "/A";
	}

	@Override
	public List<IFile> getAllChildFiles() {
		// TODO Auto-generated method stub
		List<IFile> mockList = new ArrayList<>();
		mockList.add(new MockFileA());
		mockList.add(new MockFileB());
		return mockList;
		
	}

	@Override
	public List<IDirectory> getAllChildDir() {
		// TODO Auto-generated method stub
		List<IDirectory> mockDir = new ArrayList<>();
		mockDir.add(new MockDirectoryB());
		return mockDir;
	}

	@Override
	public IDirectory getChild(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFile getChildFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsDirectory(IDirectory child) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDirectory getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChild(IDirectory child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChild(IDirectory child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChildFile(IFile initialFolder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChildFile(IFile child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsFile(IFile file) {
		// TODO Auto-generated method stub
		return false;
	}
	
		

}
