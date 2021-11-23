package de.hsh.dbs2.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		insertEmployee(1, "Meyer", "IT");
		insertEmployee(2, "Schulze", "IT");
		showEmployees("IT");
	}

	public static void insertEmployee(int id, String name, String dep) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		String SQL = "INSERT INTO EMPLOYEE(employee_id, name, dept) VALUES(?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, dep);
			int cnt = stmt.executeUpdate();
			System.out.printf("Anzahl eingefügte Datensätze: %d\n", cnt);
		}
	}
	
	public static void showEmployees(String dep) throws SQLException {
		// Achtung: in dieser Methode fehlt die Ressourcen-Freigabe
		// Siehe Aufgabe 1.2
		Connection conn = ConnectionManager.getConnection();
		String SQL =
			"SELECT employee_id, name " +
			"FROM employee " +
			"WHERE dept = ?";
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setString(1, dep);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			long emp_id = rs.getLong("employee_id");
	        	String name = rs.getString("name");
	        	System.out.println("ID=" + emp_id + ", Name=" + name);
		}
	}
	
}
