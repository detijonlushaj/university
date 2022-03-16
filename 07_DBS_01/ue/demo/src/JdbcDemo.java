import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JdbcDemo {

    private static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@dboracleserv.inform.hs-hannover.de:1521:db01", "user", "password");
            demo2();
        } catch (SQLException e) {
            System.out.println("Fehler beim Ausführen einer Datenbank-Anfrage: ");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Errorcode: " + e.getErrorCode()); 
        }

    }

    public static void demo1() throws SQLException {
        String query = "SELECT employee_id, last_name FROM hr.employees ORDER BY employee_id";
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    long empid = rs.getLong("employee_id");
                    String lastname = rs.getString("last_name");
                    System.out.println("Employee: ID=" + empid + " LastName=" + lastname);
                }
            }
        } 
    }

    public static void demo2() throws SQLException {
        String query = "SELECT employee_id, last_name FROM hr.employees WHERE department_id = ? AND salary > ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, 80);   // department_id
            stmt.setFloat(2, 10000);   // salary
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    long empid = rs.getLong("employee_id");
                    String lastname = rs.getString("last_name");
                    System.out.println("Employee: ID=" + empid + " LastName=" + lastname);
                }
            }
        }
    }

    public static void demo3() throws SQLException {
        String query = "SELECT employee_id, last_name, department_id FROM hr.employees";
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    long empid = rs.getLong("employee_id");
                    String lastname = rs.getString("last_name");
                    System.out.print("Employee: ID=" + empid + " LastName=" + lastname);
                    int deptId = rs.getInt("department_id");
                    boolean wasNull = rs.wasNull();
                    if (wasNull)
                        System.out.println(" NO Department             <---- ");
                    else
                        System.out.println(" Department_id=" + deptId);
                }
            }
        }
    }

    public static void demo4() throws SQLException {
        String query = "SELECT employee_id, last_name FROM hr.employees WHERE department_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setNull(1, Types.NUMERIC);  // Achtung: funktioniert nicht!!
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    long empid = rs.getLong("employee_id");
                    String lastname = rs.getString("last_name");
                    System.out.println("Employee: ID=" + empid + " LastName=" + lastname);
                }
            }
        }
    }

    public static void demo5() throws SQLException {
        String createOrderItems =  
                "CREATE TABLE order_items(" +
                        "    order_id NUMBER(8), " + 
                        "    line_item_id NUMBER(5)," +
                        "    product_name VARCHAR2(50)," +
                        "    unit_price NUMBER(8,2)," + 
                        "    quantity NUMBER(5)" +
                        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createOrderItems);
        }
    }

    public static void demo6() throws SQLException {
        String insertItem1 = "INSERT INTO order_items VALUES (123,12,'SampleItem1',48.32,12)";
        String insertItem2 = "INSERT INTO order_items VALUES (124,12,'SampleItem2',12.1,1)";
        String insertItem3 = "INSERT INTO order_items VALUES (125,14,'SampleItem3',0.89,200)";
        try (Statement stmt = conn.createStatement()) {
            int num = stmt.executeUpdate(insertItem1);
            num += stmt.executeUpdate(insertItem2);
            num += stmt.executeUpdate(insertItem3);
            System.out.println("Tabelle orderItems "+num+" Zeilen eingefügt!");
        } 
    }

    /**
     * Benötigt folgende Tabelle:

       create table person (
        id number,
        name varchar2(100),
        dob date
       );

     * @throws SQLException
     */
    public static void demo7() throws SQLException {
        String insert1 = "INSERT INTO person VALUES (1, 'Fritz Meier', "+
                "to_date('1965-10-12','YYYY-MM-DD'))";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(insert1);
        }

        String insert2 = "INSERT INTO person VALUES (2, 'Franz Schulze', ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insert2)) {
            Date gebTag = java.sql.Date.valueOf("1972-10-17");  // java.sql.Date !
            pstmt.setDate(1, gebTag);
            pstmt.executeUpdate();
        }

        String insert3 = "INSERT INTO person VALUES (3, 'Lena Müller', {d'1985-02-07'})";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(insert3);
        }
    }

    /**
     * ResultSetMetadata
     * @throws SQLException
     */
    public static void demo8() throws SQLException {
        String query = "SELECT * FROM person p";
        try (Statement stmt = conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(query)) {
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        System.out.printf("%s: Type %s, Value %s\n", rsmd.getColumnName(i), rsmd.getColumnTypeName(i), rs.getString(i));
                    }
                    System.out.println();
                }
            }
        }
    }

    /**
     * DatabaseMetadata
     * @throws SQLException
     */
    public static void demo9() throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        try (ResultSet rs = dbmd.getSchemas()) {
            while (rs.next()) {
                System.out.println("Schema: " + rs.getString("TABLE_SCHEM"));
            }
        }

        System.out.println("List of tables of the schema MOVIEDB:");
        try (ResultSet rs = dbmd.getTables(null, "MOVIEDB", null, null)) {
            while (rs.next()) {
                System.out.printf("Table: %s\n", rs.getString("TABLE_NAME"));
            }
        }

        System.out.println("Primary key of table MOVIEDB.PLAYS:");
        try (ResultSet rs = dbmd.getPrimaryKeys(null, "MOVIEDB", "PLAYS")) {
            while (rs.next()) {
                System.out.printf("%d: %s\n", rs.getInt("KEY_SEQ"), rs.getString("COLUMN_NAME"));
            }
        }

    }

}
