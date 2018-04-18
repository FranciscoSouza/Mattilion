package com.matillion.exec3;

import java.io.IOException;

import com.matillion.exec3.util.DistanceTime;
import com.matillion.exec3.util.ParseUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase

{

	private String source = "Skegness";
	private String destination = "Stotfold";

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * @throws IOException
	 */
	public void testRightDistance() throws IOException {
		String distance = new ParseUtil().parseDistance(new DistanceTime().calculate(source, destination));
		assertEquals("2 hours 20 mins", distance);
	}
	
	/**
	 * @throws IOException
	 */
	public void testWrongDistance() throws IOException {
		String distance = new ParseUtil().parseDistance(new DistanceTime().calculate(source, destination));
		assertNotSame("3 hours 30 mins", distance);
	}

}
