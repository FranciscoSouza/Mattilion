package com.matillion.exec2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.matillion.exec2.bo.QueryResultObj;

public class JDBCResultDAO implements ResultDAO {
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/foodmart?user=admin&password=admin";
	

	Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName(MYSQL_DRIVER);
			if (connection == null)
				connection = (Connection) DriverManager
						.getConnection(MYSQL_URL);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// do nothing
		}
	}

	public List<QueryResultObj> select(String department, String payType, String educationLevel) {

		List<QueryResultObj> resultQuery = new LinkedList<QueryResultObj>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT e.employee_id,e.full_name, e.education_level,"
					+ " d.department_description, p.pay_type "
					+ "FROM employee e, department d, position p "
					+ "WHERE "
					+ "((e.department_id = d.department_id)and (p.position_id=e.position_id)) "
					+ "and (upper(d.department_description) like upper('%"+department+"%')) "
					+ "and (upper(e.education_level) like upper('%"+payType+"%')) "
					+ "and (upper(p.pay_type) like upper('"+educationLevel+"%'))");
			

			QueryResultObj obj = null;
			while (resultSet.next()) {
				obj = new QueryResultObj();
				obj.setEmployeeId(Integer.parseInt(resultSet.getString("employee_id")));
				obj.setEmployeeName(resultSet.getString("full_name"));
				obj.setDepartmentName(resultSet.getString("department_description"));
				obj.setPaymentType(resultSet.getString("pay_type"));
				obj.setEducationLevel(resultSet.getString("education_level"));

				resultQuery.add(obj);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultQuery;
	}

}
