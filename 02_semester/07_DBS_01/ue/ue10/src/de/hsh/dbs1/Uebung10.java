package de.hsh.dbs1;

import java.sql.*;

public class Uebung10 {

    private static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", 
                    "KT0-NGF-U1", "testit2_");

            //DatenEinfuegen();
            //neueDatenEinfuegen();

            //rezeptUmbenennen(1, "Pizzateig");

            //rezeptAusgeben(1);
            //rezeptAusgeben(2);
            //rezeptAusgeben(3);
            //rezeptAusgeben(4);
            
            //schrittLoeschen(1, 2);
            //rezeptLoeschen(1);
            
            schrittEinfuegen(5, 5, "Teig gut durchkneten");
            
            conn.close();
            
            /*i) Kein Fehler: umbennen & löschen 
                 Fehler: ausgeben z.B. wegen der Zeile rsR.getString("name") => nicht vorhanden
                         neues Schritt wegen FK_REZEPTID Constraint
            */

        } catch (SQLException e) {
            System.out.println("Fehler beim Ausführen einer Datenbank-Anfrage: ");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Errorcode: " + e.getErrorCode());
            e.printStackTrace();
        }

    }

    public static void datenEinfuegen() throws SQLException {
        rezeptEinfuegen(1, "Pizza");
        schrittEinfuegen(1, 1, "Wasser leicht erwärmen");
        schrittEinfuegen(1, 2, "Hefe im Wasser auflösen");
        schrittEinfuegen(1, 3, "Mehl und Salz vermischen");
        schrittEinfuegen(1, 4, "Hefewasser ins Mehl kippen");
        schrittEinfuegen(1, 5, "Teig gut durchkneten");
        schrittEinfuegen(1, 6, "Öl zum Teig hinzugeben");
        schrittEinfuegen(1, 7, "Teig erneut gut durchkneten");

        rezeptEinfuegen(2, "Pfannkuchen");
        schrittEinfuegen(2, 1, "Milch, Eier, Zucker in eine Schüssel geben");
        schrittEinfuegen(2, 2, "schaumig rühren");
        schrittEinfuegen(2, 3, "Mehl langsam dazugeben, dabei rühren");
        schrittEinfuegen(2, 4, "Teig in einer Pfanne braten, einmal wenden");
    }

    public static void neueDatenEinfuegen() throws SQLException {
        rezeptEinfuegen(3, "Pink-Drink");
        schrittEinfuegen(3, 1, "Hibiskus-Tee kochen und kalt stellen");
        schrittEinfuegen(3, 2, "gefrorene Himbeeren, Eiswürfel und Holunderblütensyrup ins Glas geben");
        schrittEinfuegen(3, 3, "Hibiskus-Tee einführen");
        schrittEinfuegen(3, 4, "Kokosmilch ins Glas kippen");
        schrittEinfuegen(3, 5, "Bisschen rühren");

        rezeptEinfuegen(4, "Spagetti");
        schrittEinfuegen(4, 1, "Wasser im Topf kochen");
        schrittEinfuegen(4, 2, "wenn das Wasser aufgekocht ist, Salz dazu geben");
        schrittEinfuegen(4, 3, "Spagetti dazu geben");
        schrittEinfuegen(4, 4, "Spagetti 10 min auf mittlerer Hitze kochen");
        schrittEinfuegen(4, 5, "das Wasser weg sieben und Butter in die Spagetti einrühren");
    }

    /**
     * Fuegt einen Datensatz in die Tabelle rezept ein.
     * @param id
     * @param name
     * @throws SQLException
     */
    public static void rezeptEinfuegen(int id, String name) throws SQLException {
        int num = 0;
        String insertItem = "INSERT INTO rezept VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertItem)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            num += stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(num, "Zeilen in Rezept eingefügt");
    }

    /**
     * Fuegt einen Datensatz in die Tabelle schritt ein.
     * @param id
     * @param nummer
     * @param beschreibung
     * @throws SQLException
     */
    public static void schrittEinfuegen(int id, int nummer, String beschreibung) throws SQLException {
        int num = 0;
        String insertItem = "INSERT INTO schritt VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertItem)) {
            stmt.setInt(1, id);
            stmt.setInt(2, nummer);
            stmt.setString(3, beschreibung);
            num += stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(num, "Zeilen in Schritt eingefügt");
    }

    /**
     * Loescht einen Datensatz aus der Tabelle schritt.
     * Passt die Nummern der Schritte nicht an
     * Wenn nummer = 0 bedeutet das, dass alle Schritte gelöscht werden sollen
     * @param id if id = 0 then delete everything
     * @param nummer
     * @throws SQLException
     */
    public static void schrittLoeschen(int id, int nummer) throws SQLException {
        int num = 0;
        String deleteItem = null;
        if (nummer != 0) {
            deleteItem = "DELETE FROM schritt WHERE id = ? and nummer = ?";
        } else {
            deleteItem = "DELETE FROM schritt WHERE id = ?";
        }
        try (PreparedStatement stmt = conn.prepareStatement(deleteItem)) {
            stmt.setInt(1, id);
            if (nummer != 0) {
                stmt.setInt(2, nummer);
            }
            num += stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(num, "Zeilen in Schritt gelöscht");
    }

    /**
     * Gibt dem Rezept mit der id einen neuen Namen.
     * @param id
     * @param neuerName
     * @throws SQLException
     */
    public static void rezeptUmbenennen(int id, String neuerName) throws SQLException {
        int num = 0;
        String changeItem = "UPDATE rezept SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(changeItem)) {
            stmt.setString(1, neuerName);
            stmt.setInt(2, id);
            num += stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(num, "Zeilen in Rezept umbenannt");
    }

    /**
     * Gibt das Rezept und die Rezeptschritte zu dem Rezept mit der id aus.
     * @param id
     * @throws SQLException
     */
    public static void rezeptAusgeben(int id) throws SQLException {
        String queryR = "SELECT * FROM rezept WHERE id = ?";
        String queryS = "SELECT * FROM schritt WHERE id = ?";
        try (PreparedStatement stmtR = conn.prepareStatement(queryR)) {
            stmtR.setInt(1, id);
            try (ResultSet rsR = stmtR.executeQuery()) {
                rsR.next();
                String rezept = rsR.getString("name");
                System.out.println("Rezept " + rezept + ":");
                try (PreparedStatement stmtS = conn.prepareStatement(queryS)) {
                    stmtS.setInt(1, id);
                    try (ResultSet rsS = stmtS.executeQuery()) {
                        while (rsS.next()) {
                            int nr = rsS.getInt("nummer");
                            String beschreibung = rsS.getString("beschreibung");
                            System.out.println(" Schritt " + nr + ": " + beschreibung);
                        }
                    }
                }
            }
        }
    }

    /**
     * Löscht das Rezept und alle Rezeptschritte zu dem Rezept mit der id aus der Datenbank.
     * @param id
     * @throws SQLException
     */
    public static void rezeptLoeschen(int id) throws SQLException {
        schrittLoeschen(id, 0);
        int num = 0;
        String deleteItem = "DELETE FROM rezept WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteItem)) {
            stmt.setInt(1, id);
            num += stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(num, "Zeilen in Rezept gelöscht");
    }
    
    public static void print(int num, String text) {
        System.out.println(num + " " + text);
    }
}