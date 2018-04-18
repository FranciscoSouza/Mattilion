package com.matillion.exec1.util;

public class StringDifferentLenghtException extends Exception {

	public StringDifferentLenghtException() {
	}

	public StringDifferentLenghtException(String message) {
		super(message);
	}

	public StringDifferentLenghtException(Throwable cause) {
		super(cause);
	}

	public StringDifferentLenghtException(String message, Throwable cause) {
		super(message, cause);
	}

	public StringDifferentLenghtException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
