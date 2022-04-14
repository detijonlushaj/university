
public void ausleihen(int fahrrad_id, int kunde_id) {
    boolean ok = false;
    String SQL = "SELECT K_id FROM Fahrrad WHERE F_id = ?";
    try {
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setLong(1, fahrrad_id);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                rs.getInt("K_id");
                
                if (!(rs.wasNull())) {
                    throw new SQLException("Fahrrad ist nicht verfuegbar!");			
                }
            }
        }
        SQL = "UPDATE Fahrrad SET FK-K_id = ? WHERE PK-F_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, kunde_id);
            stmt.setLong(2, fahrrad_id);
        }
        conn.commit();
        ok = true;
    } finally {
        if(!ok) 
            conn.rollback();
    }
}
