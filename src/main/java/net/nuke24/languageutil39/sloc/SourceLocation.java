package net.nuke24.languageutil39.sloc;

public interface SourceLocation
{
	public String getFileUri();
	
	// 0-based indexes for lines and columns.
	// Add 1 if you want the conventional 'line number' or 'column number'
	// (noting that some programs number columns from zero).
	// -1 for unknown
	
	public int getLineIndex();
	public int getColumnIndex();
}
