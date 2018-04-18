package com.matillion.exec1.test;

import com.matillion.exec1.util.CompareStrings;
import com.matillion.exec1.util.StringDifferentLenghtException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private static String str1;
	private static String str2;
	private CompareStrings compareObj = new CompareStrings();

	public void testShouldHaveFiveDifferences() throws StringDifferentLenghtException {
		str1 = "D23W8MCCIZQOP9";
		str2 = "D236862CEZQOPS";
		assertEquals(5, compareObj.compare(str1, str2));
	}

	public void testShouldHaveFourDifferences() throws StringDifferentLenghtException {
		str1 = "D23W8MCCIZQOP9";
		str2 = "D236862CIZQOPS";
		assertEquals(4, compareObj.compare(str1, str2));
	}

	public void testShouldNoHaveDifferences() throws StringDifferentLenghtException {
		str1 = "D23W8MCCIZQOP9";
		str2 = "D23W8MCCIZQOP9";
		assertEquals(0, compareObj.compare(str1, str2));
	}

	public void testShouldThrowStringDifferentLenghtException() {
		str1 = "D23W8MCCIZQOP9";
		str2 = "D23W8MCCIZQOP912345";

		try {
			compareObj.compare(str1, str2);
			fail("Missing exception");
		} catch (StringDifferentLenghtException e) {
			assertEquals(StringDifferentLenghtException.class, e.getClass());
		}

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}
}
