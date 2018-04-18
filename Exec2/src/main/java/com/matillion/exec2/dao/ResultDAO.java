package com.matillion.exec2.dao;

import java.util.List;

import com.matillion.exec2.bo.QueryResultObj;

public interface ResultDAO {
	public List<QueryResultObj> select(String department, String payType, String educationLevel);

}
