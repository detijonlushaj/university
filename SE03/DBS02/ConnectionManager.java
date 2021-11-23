package de.hsh.dbs2.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection conn;

	static {
		conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", "user", "password");
			System.out.println("Connect durchgefuehrt ....");
		} catch (Exception e) {
			System.err.println("Error while connecting to database");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
