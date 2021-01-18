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
import test.*;
import a2.*;

public class MockFileManagerA extends MockDirectoryItems implements IFileManager  {
	
	MockDirectoryA mockDirA = new MockDirectoryA();
	MockDirectoryB mockDirB = new MockDirectoryB();
	
	
	@Override
	public List<IDirectory> getAllChildrenDir() {
		// TODO Auto-generated method stub
		
		return mockDirA.getAllChildDir();
		
	}

	@Override
	public List<IFile> getAllChildrenFile() {
		// TODO Auto-generated method stub
		return mockDirA.getAllChildFiles();
	}

	@Override
	public Directory getCurDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDirectory getSpecificDirectory(String name) {
		if (name.equals("/A"))
		{
			return mockDirA;
		}
		else if (name.equals("/A/B"))
		{
			return mockDirB;
		}
		else
		{
			return null;
		}
	}

	@Override
	public File getSpecificFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFullPath() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Directory getCurrentDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDirectoryToPath(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Directory getParentDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Directory getRootDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alreadyExists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCurrentDir(IDirectory currDir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFileToPath(String name, IFile input) {
		// TODO Auto-generated method stub
		
	}
	

}
