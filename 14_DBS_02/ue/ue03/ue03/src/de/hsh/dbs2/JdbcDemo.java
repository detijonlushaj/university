package de.hsh.dbs2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    static int i = 0;


	public static void main(String[] args) throws SQLException {
//		insertEmployee(1, "Meyer", "IT");
//		insertEmployee(2, "Schulze", "IT");
//		showEmployees("IT");
        deleteEmployee(2);
        setDeparment(1, "Trash");
        
        // maximale Anzahl offener Cursor ueberschritten, naemlich 299
        for (int i = 0; i < 300; i++) {
            showEmployees("IT");
        }
	}

	public static void insertEmployee(String name, String dep) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        int id;
        
        String getSeq = "SELECT employee_seq.nextval FROM DUAL";
        try (PreparedStatement seq = conn.prepareStatement(getSeq)) {
            ResultSet rs = seq.executeQuery();
            rs.next();
            id = rs.getInt("nextval");
        }
        
        String SQL = "INSERT INTO EMPLOYEE(employee_id, name, dept) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, dep);
            int cnt = stmt.executeUpdate();
            System.out.printf("Anzahl eingefügte Datensätze: %d\n", cnt);
        }
//		Connection conn = ConnectionManager.getConnection();
//		String SQL = "INSERT INTO EMPLOYEE(employee_id, name, dept) VALUES(?, ?, ?)";
//		try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
//			stmt.setInt(1, id);
//			stmt.setString(2, name);
//			stmt.setString(3, dep);
//			int cnt = stmt.executeUpdate();
//			System.out.printf("Anzahl eingefügte Datensätze: %d\n", cnt);
//		}
	}
	
	public static void showEmployees(String dep) throws SQLException {
        System.out.println(i);
        i++;
        // Achtung: in dieser Methode fehlt die Ressourcen-Freigabe
        // Siehe Aufgabe 1.2
        Connection conn = ConnectionManager.getConnection();
        String SQL =
            "SELECT employee_id, name " +
            "FROM employee " +
            "WHERE dept = ?";
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, dep);
    
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                long emp_id = rs.getLong("employee_id");
                    String name = rs.getString("name");
                    System.out.println("ID=" + emp_id + ", Name=" + name);
            }
        }
	}
	
	public static void deleteEmployee(int id) {
        Connection conn = ConnectionManager.getConnection();
        String SQL = "DELETE FROM employee WHERE employee_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            int n = stmt.executeUpdate();
            System.out.println("Rows deleted: " + n);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void setDeparment(int id, String dept) {
        Connection conn = ConnectionManager.getConnection();
        String SQL = "UPDATE employee SET dept = ? WHERE employee_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, dept);
            stmt.setInt(2, id);
            int n = stmt.executeUpdate();
            System.out.println("Rows modified: " + n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
