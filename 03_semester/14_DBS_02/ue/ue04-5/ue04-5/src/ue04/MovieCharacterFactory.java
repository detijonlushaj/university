package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author lushaj
 * MovieCharacterFactory. Returns objects of the MovieCharacter table inside the database
 */
public class MovieCharacterFactory {
    
    /**
     * search in the MovieCharacter table after a tuple by the specified movieId
     * @param movCharId
     * @return MovieCharacter object if movCharId is inside the MovieCharacter table else null  
     * @throws SQLException
     */
    public static MovieCharacter findByMovieCharacterId(Long movCharId) throws SQLException {
        String character = null;
        String alias = null;
        Integer position = null;
        Long movieId = null;
        Long personId = null;
        String SQL = "SELECT Character, Alias, Position, MovieID, PersonID FROM MovieCharacter WHERE MovCharID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movCharId);
            try (ResultSet rs = stmt.executeQuery()) {
                // checking if ResultSet is empty
                if (rs.next()) {
                    character = rs.getString("Character");
                    alias = rs.getString("Alias");
                    position = rs.getInt("Position");
                    movieId = rs.getLong("MovieId");
                    personId = rs.getLong("PersonId");
                } else {
                    throw new SQLException("Datensatz mit movCharID = " + movCharId + " nicht vorhanden");
                }
            }
        }
        return new MovieCharacter(movCharId, character, alias, position, movieId, personId);
    }
    
    /**
     * 
     * @return ArrayList containing MovieCharacter objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<MovieCharacter> findByMovieCharacterAll() throws SQLException {
        ArrayList<MovieCharacter> movChars = new ArrayList<MovieCharacter>(); 
        
        String SQL = "SELECT MovCharID, Character, Alias, Position, MovieId, PersonId FROM MovieCharacter";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long movCharId = rs.getLong("MovCharID");
                    String character = rs.getString("Character");
                    String alias = rs.getString("Alias");
                    Integer position = rs.getInt("Position");
                    Long movieId = rs.getLong("MovieID");
                    Long personId = rs.getLong("PersonID");
                    movChars.add(new MovieCharacter(movCharId, character, alias, position, movieId, personId));
                }            
            } 
        }
        if (movChars.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return movChars;
    }
}
