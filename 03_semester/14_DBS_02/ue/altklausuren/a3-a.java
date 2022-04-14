
public void bestimmte_bonus(int m_id, double bonus) {
    boolean ok = false;
    String SQL = "SELECT gehalt FROM mitarbeiter WHERE id = ?";
    double gehalt;
    try {
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setLong(1, m_id);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                gehalt = rs.getDouble("gehalt");
            }
            if( bonus < 0 && (gehalt*0.5) > bonus ) {
                throw new SQLException("Exception message"); 
            }
        }

        SQL = "UPDATE mitarbeiter SET bonus = ? WHERE m_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(1, bonus);
            stmt.setLong(2, m_id);
        }
        conn.commit();
        ok = true;
    } finally {
        if (!ok)
            conn.rollback();
    }
}