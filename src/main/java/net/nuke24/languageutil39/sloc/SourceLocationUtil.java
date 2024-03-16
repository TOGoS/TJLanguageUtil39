package net.nuke24.languageutil39.sloc;

public class SourceLocationUtil
{
	public static boolean sourceSpansAreEqual(SourceSpan a, SourceSpan b) {
		if( a == b ) return true;
		if( a == null || b == null ) return false;
		return
			(a.getFileUri() == b.getFileUri() ||
			(a.getFileUri() != null && a.getFileUri().equals(b.getFileUri()))) &&
			a.getLineIndex() == b.getLineIndex() &&
			a.getColumnIndex() == b.getColumnIndex() &&
			a.getEndLineIndex() == b.getEndLineIndex() &&
			a.getEndColumnIndex() == b.getEndColumnIndex();
	}
	
	protected static boolean isPointForStringificationPurposes(SourceSpan ss) {
		return (
			ss.getEndLineIndex() == -1
		) || (
			ss.getEndLineIndex() == ss.getLineIndex() && 
			ss.getEndColumnIndex() == ss.getColumnIndex()
		);
	}
	
	public static String sourceLocationToSuffix(SourceSpan ss, String prefix) {
		return (ss == null || (
			ss.getFileUri() == null &&
			ss.getLineIndex() == -1 && ss.getColumnIndex() == -1 &&
			ss.getEndLineIndex() == -1 && ss.getEndColumnIndex() == -1
		)) ? "" : prefix +
			ss.getFileUri()+"#"+
			(ss.getLineIndex()+1)+","+(ss.getColumnIndex()+1)+
			(isPointForStringificationPurposes(ss) ? "" : ".."+(ss.getEndLineIndex()+1)+","+(ss.getEndColumnIndex()+1));
	}
	
	public static int hashCode(SourceSpan ss) {
		return
			(ss.getFileUri() == null ? 0 : ss.getFileUri().hashCode()) +
			(ss.getLineIndex()      <<  0) +
			(ss.getColumnIndex()    <<  8) +
			(ss.getEndLineIndex()   << 16) +
			(ss.getEndColumnIndex() << 24);
	}
}
