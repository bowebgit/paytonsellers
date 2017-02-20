package com.paytonsellersbooks.dao.jdbc;

import java.sql.Connection;

public interface DAO {
	Connection getConnection();
	void closeResources(Connection conn);
}
