package net.nuke24.languageutil39.SourceLocationUtilTest;

import junit.framework.TestCase;
import net.nuke24.languageutil39.sloc.BasicSourceSpan;
import net.nuke24.languageutil39.sloc.SourceLocationUtil;
import net.nuke24.languageutil39.sloc.SourceSpan;

public class SourceLocationUtilTest
extends TestCase
{
	SourceSpan ss1 = BasicSourceSpan.point("foo", 12, 13);
	SourceSpan ss2 = BasicSourceSpan.point("foo", 12, 13);
	SourceSpan ss3 = BasicSourceSpan.span("foo", 12, 13, 12, 15);
	
	public void testEqualsSelf() {
		assertEquals(ss1, ss1);
	}
	public void testEqualsIdentical() {
		assertEquals(ss1, ss2);
	}
	public void testNotEqualsNull() {
		assertFalse(ss1.equals(null));
	}
	
	public void testSuffix() {
		assertEquals("", SourceLocationUtil.sourceLocationToSuffix(null, " whatever "));
	}
}
