package ue04;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author lushaj
 * MovieGenre record
 */
public class MovieGenre {
    private Long movieId;
    private Long genreId;
    
    /**
     * constructor with parameters
     * @param genreId
     * @param movieId
     */
    public MovieGenre (Long movieId, Long genreId) {
        setMovieId(movieId);
        setGenreId(genreId);
    }
    
    /**
     * empty constructor
     */
    MovieGenre () {
        
    }
    
    /**
     * 
     * @param genreId
     */
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
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
     * @return genreId
     */
    public Long getGenreId() {
        return genreId;
    }
    
    /**
     * 
     * @return movieId
     */
    public Long getMovieId() {
        return movieId;
    }
    
    /**
     * insert MovieGenre object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {        
        String SQL = "INSERT INTO MovieGenre VALUES (?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if genreId or movieId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM MovieGenre WHERE MovieId = ? AND GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            stmt.setLong(2, genreId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        }
    }
}
