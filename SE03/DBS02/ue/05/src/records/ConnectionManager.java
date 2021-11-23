import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

        private static Connection conn;

        static {
            conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", 
                        "KT0-NGF-U1", "testit2_");
                conn.setAutoCommit(false);
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

