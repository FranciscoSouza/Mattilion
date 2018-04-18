package com.matillion.exec3;

import com.matillion.exec3.util.CSVFileUtil;
import com.matillion.exec3.util.DistanceTime;
/**
 * Hello world!
 *
 */
import com.matillion.exec3.util.ParseUtil;

public class App {
	public static void main(String[] args) {
		CSVFileUtil cCSVFileUtil = new CSVFileUtil();
		try {
			cCSVFileUtil.readCSVFile();

			String source = cCSVFileUtil.getRandomLoation();
			String destination = cCSVFileUtil.getRandomLoation();
			String distance = new ParseUtil().parseDistance(new DistanceTime().calculate(source, destination));

			System.out.println("It will take " + distance + " to walk from " + source + " to " + destination);
		}

		catch (Exception e) {
			System.out.println("Exception Occurred");
		}
	}
}
