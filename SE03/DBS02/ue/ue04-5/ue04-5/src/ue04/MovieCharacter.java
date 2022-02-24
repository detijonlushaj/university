package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author lushaj
 * MovieCharacter record
 */
public class MovieCharacter {
    private Long movCharId;
    private String character;
    private String alias;
    private Integer position;
    private Long movieId;
    private Long personId;
    
    /**
     * constructor with parameters
     * @param movCharId
     * @param character
     * @param alias
     * @param type
     */
    MovieCharacter (Long movCharId, String character, String alias, Integer position, Long movieId, Long personId) {
        setMovCharId(movCharId);
        setCharacter(character);
        setAlias(alias);
        setPosition(position);
        setMovieId(movieId);
        setPersonId(personId);
    }
    
    /**
     * empty constructor
     */
    public MovieCharacter() {
        
    }
    
    /**
     * 
     * @param movCharId
     */
    public void setMovCharId(Long movCharId) {
        this.movCharId = movCharId;
    }
    
    /**
     * 
     * @param character
     */
    public void setCharacter(String character) {
        this.character = character;
    }
    
    /**
     * 
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    /**
     * 
     * @param position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 
     * @param movieId
     */
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    
    /**
     * 
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    /**
     * 
     * @return movCharId
     */
    public Long getMovCharId() {
        return movCharId;
    }
    
    /**
     * 
     * @return character
     */
    public String getCharacter() {
        return character;
    }
    
    /**
     * 
     * @return alias
     */
    public String getAlias() {
        return alias;
    }
    
    /**
     * 
     * @return position
     */
    public Integer getPosition() {
        return position;
    }
    
    /**
     * 
     * @return movieId
     */
    public Long getMovieId() {
        return movieId;
    }
    
    /**
     * 
     * @return personId
     */
    public Long getPersonId() {
        return personId;
    }
    
    /**
     * insert MovieCharacter object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {
        // this means no custom id was set thus using a sequence
        if (movCharId == null) {
            String getSeq = "SELECT mov_char_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
               try (ResultSet rs = seq.executeQuery()) {
                    rs.next();
                    movCharId = rs.getLong("nextval");
               }
            } 
        }
        
        String SQL = "INSERT INTO MovieCharacter VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movCharId);
            
            if (character != null) {
                stmt.setString(2, character);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            if (alias != null) {
                stmt.setString(3, alias);
            } else {
                stmt.setNull(3, Types.NULL);
            }
            if (position != null) {
                stmt.setInt(4, position);
            } else {
                stmt.setNull(4, Types.NULL);
            }
            if (movieId != null) {
                stmt.setLong(5, movieId);
            } else {
                stmt.setNull(5, Types.NULL);
            }
            if (personId != null) {
                stmt.setLong(6, personId);
            } else {
                stmt.setNull(6, Types.NULL);
            }
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * update existing tuples in table. Does not check if movCharId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        String SQL = "UPDATE MovieCharacter SET Character = ?, Alias = ?, Position = ? WHERE MovCharID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            if (character != null) {
                stmt.setString(1, character);
            } else {
                stmt.setNull(1, Types.NULL);
            }
            if (alias != null) {
                stmt.setString(2, alias);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            if (position != null) {
                stmt.setInt(3, position);
            } else {
                stmt.setNull(3, Types.NULL);
            }
            if (movieId != null) {
                stmt.setLong(4, movieId);
            } else {
                stmt.setNull(4, Types.NULL);
            }
            if (personId != null) {
                stmt.setLong(5, personId);
            } else {
                stmt.setNull(5, Types.NULL);
            }
            
            stmt.setLong(6, movCharId);
            
            int n = stmt.executeUpdate();           
            System.out.println("Updates made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if movCharId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM MovieCharacter WHERE MovCharID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movCharId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        } 
    }
}
