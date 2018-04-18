package com.matillion.exec3.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CSVFileUtil {

	private static final String TEST_THREE_CSV = "test_three.csv";
	private static final String DEFAULT_SEPARATOR = ",";

	private List<String> attributes = new ArrayList<String>();

	public String getRandomLoation() {
		int rnd = new Random().nextInt(attributes.size());
		return attributes.get(rnd);
	}

	public void readCSVFile() throws IOException {
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(TEST_THREE_CSV))) {

			while ((line = br.readLine()) != null) {

				String[] lineSplit = line.split(DEFAULT_SEPARATOR);
				attributes.add(new String(lineSplit[0]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
