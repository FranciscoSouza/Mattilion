package com.matillion.exec1.util;

public class CompareStrings {
	public int compare(String str1, String str2) throws StringDifferentLenghtException {
		int qtdDiff = 0;
		if (str1.length() == str2.length()) {

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					qtdDiff++;
				}
			}
		}else {
			throw new StringDifferentLenghtException();
		}
		return qtdDiff;
	}

}
