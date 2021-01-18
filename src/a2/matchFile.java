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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchFile {
	
	public static String allLine(IFile inFile, String regexIn)
	{
		// Get file content
		String content = inFile.getContent();
		// Split file content by newline
		String[] contentSplit = content.split("\n");
		// regContent contains all line that contains the regex
		String regContent = "";

		// Iterate through the lines
		for (String lineInFile : contentSplit)
		{
			// Regex compile
			Pattern p = Pattern.compile(regexIn);
		    Matcher lineParsing = p.matcher(lineInFile);
		    // If the line contains that regex (aka, regex.find returns true) add line to regContent
		    if (lineParsing.find())
		    {
		    	regContent = regContent + lineInFile + "\n";
		    }
		}
		return regContent;
	}

}
