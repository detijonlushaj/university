import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:db01",
                "KT0-NGF-U1", "testit2_");
        String query = "SELECT employee_id, last_name FROM hr.employees";
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    long empid = rs.getLong("employee_id");
                    String lastname = rs.getString("last_name");
                    System.out.println(
                            "Employee: ID="+empid+" LastName="+lastname);
                }
            }
        }
    }

}
