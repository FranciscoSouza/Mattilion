package com.matillion.exec2;

import com.matillion.exec2.dao.JDBCResultDAO;

/**
 * Hello world!
 *
 */

public class App {
	private static String department;
	private static String payType;
	private static String educationLevel;
	
	public static void main(String[] args) {
		
		if (args.length == 3) {
			
			department = args[0];
			educationLevel = args[1];
			payType = args[2];
			
			JDBCResultDAO jdbcResult = new JDBCResultDAO();
			jdbcResult.getConnection();
			System.out.println(jdbcResult.select(department, educationLevel, payType));
			jdbcResult.closeConnection();
		}else {
			System.out.println("Should contains three parameters [department, payType, educationLevel]");
		}
	}
}
