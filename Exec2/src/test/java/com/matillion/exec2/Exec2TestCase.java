package com.matillion.exec2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.matillion.exec2.bo.QueryResultObj;
import com.matillion.exec2.dao.JDBCResultDAO;

public class Exec2TestCase {
	private JDBCResultDAO jdbcResult;

	@Before
	public void setUp() throws Exception {
		jdbcResult = new JDBCResultDAO();
		jdbcResult.getConnection();

	}

	@After
	public void tearDown() throws Exception {
		jdbcResult.closeConnection();

	}

	@Test
	public void shouldGetSevenRecords() {
		List<QueryResultObj> resultList = jdbcResult.select("general manag", "degr", "mont");
		assertEquals(7, resultList.size());
	}
	
	@Test
	public void shouldGetZeroRecords() {
		List<QueryResultObj> resultList = jdbcResult.select("general manag", "degr", "wek");
		assertEquals(0, resultList.size());
	}

	@Test
	public void shouldCheckTheFisrtRecord() {
		QueryResultObj objExpected = new QueryResultObj();
		objExpected.setEmployeeId(1);
		objExpected.setDepartmentName("HQ General Management");
		objExpected.setEducationLevel("Graduate Degree");
		objExpected.setEmployeeName("Sheri Nowmer");
		objExpected.setPaymentType("Monthly");
		
		QueryResultObj objReturned = new QueryResultObj();
		List<QueryResultObj> resultList = jdbcResult.select("general manag", "degr", "");
		objReturned = resultList.get(0);
		assertEquals(objExpected, objReturned);
	}
}
