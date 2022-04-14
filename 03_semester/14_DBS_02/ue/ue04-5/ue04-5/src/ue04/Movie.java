package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author lushaj
 * Movie record
 */
public class Movie {
    private Long movieId;
    private String title;
    private Integer year;
    private Character type;
    
    /**
     * constructor with parameters
     * @param movieId
     * @param title
     * @param year
     * @param type
     */
    Movie (Long movieId, String title, Integer year, Character type) {
        setMovieId(movieId);
        setTitle(title);
        setYear(year);
        setType(type);
    }
    
    /**
     * empty constructor
     */
    Movie() {
        
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
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * 
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * 
     * @param type
     */
    public void setType(Character type) {
        this.type = type;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * 
     * @return year
     */
    public Integer getYear() {
        return year;
    }
    
    /**
     * 
     * @return type
     */
    public Character getType() {
        return type;
    }
    
    /**
     * insert Movie object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {
        // this means no custom id was set thus using a sequence
        if (movieId == null) {
            String getSeq = "SELECT movie_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
                try (ResultSet rs = seq.executeQuery()) {
                    rs.next();
                    movieId = rs.getLong("nextval");
                }
            } 
        }
        
        String SQL = "INSERT INTO Movie VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            
            if (title != null) {
                stmt.setString(2, title);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            if (year != null) {
                stmt.setInt(3, year);
            } else {
                stmt.setNull(3, Types.NULL);
            }
            if (type != null) {
                stmt.setString(4, String.valueOf(type));
            } else {
                stmt.setNull(4, Types.NULL);
            }
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * update existing tuples in table. Does not check if movieId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        String SQL = "UPDATE Movie SET Title = ?, Year = ?, Type = ? WHERE MovieId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            if (title != null) {
                stmt.setString(1, title);
            } else {
                stmt.setNull(1, Types.NULL);
            }
            if (year != null) {
                stmt.setInt(2, year);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            if (type != null) {
                stmt.setString(3, String.valueOf(type));
            } else {
                stmt.setNull(3, Types.NULL);
            }
            
            stmt.setLong(4, movieId);
            
            int n = stmt.executeUpdate();           
            System.out.println("Updates made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if movieId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM Movie WHERE MovieId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        } 
    }
}

