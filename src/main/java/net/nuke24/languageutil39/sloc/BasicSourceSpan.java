package net.nuke24.languageutil39.sloc;

public class BasicSourceSpan
implements SourceSpan
{
	final String fileUri;
	final int lineIndex;
	final int columnIndex;
	final int endLineIndex;
	final int endColumnIndex;
	public BasicSourceSpan(String fileUri, int lineIndex, int columnIndex, int endLineIndex, int endColumnIndex) {
		this.fileUri = fileUri;
		this.lineIndex = lineIndex;
		this.columnIndex = columnIndex;
		this.endLineIndex = endLineIndex;
		this.endColumnIndex = endColumnIndex;
	}
	public static BasicSourceSpan point(String fileUri, int lineIndex, int columnIndex) {
		return new BasicSourceSpan(fileUri, lineIndex, columnIndex, lineIndex, columnIndex);
	}
	public static BasicSourceSpan span(String fileUri, int lineIndex, int columnIndex, int endLineIndex, int endColumnIndex) {
		return new BasicSourceSpan(fileUri, lineIndex, columnIndex, endLineIndex, endColumnIndex);
	}
	
	@Override public boolean equals(Object obj) {
		if( !(obj instanceof SourceSpan) ) return false;
		SourceSpan hsl = (SourceSpan)obj;
		return SourceLocationUtil.sourceSpansAreEqual(this, hsl);
	}
	
	@Override public int hashCode() {
		return SourceLocationUtil.hashCode(this);
	}
	
	@Override public String toString() {
		return SourceLocationUtil.sourceLocationToSuffix(this, "");
	}
	
	@Override public String getFileUri() { return fileUri; }
	@Override public int getLineIndex() { return lineIndex; }
	@Override public int getColumnIndex() { return columnIndex; }
	@Override public int getEndLineIndex() { return endLineIndex; }
	@Override public int getEndColumnIndex() { return endColumnIndex; }
}
