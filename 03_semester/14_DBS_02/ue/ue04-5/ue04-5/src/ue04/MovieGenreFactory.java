package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author lushaj
 * MovieGenreFactory. Returns objects of the genre table inside the database
 */
public class MovieGenreFactory {
    
    /**
     * search in the MovieGenre table after a tuple by the specified genreId & movieId
     * @param genreId
     * @param movieId
     * @return MovieGenre object if genreId & movieId is inside the MovieGenre table else null  
     * @throws SQLException
     */
    public static MovieGenre findByMovieIdAndGenreId(Long movieId, Long genreId) throws SQLException {
        String SQL = "SELECT movieId, genreId FROM MovieGenre WHERE MovieId = ? AND GenreId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            stmt.setLong(2, genreId);
            try (ResultSet rs = stmt.executeQuery()) {
                // checking if ResultSet is empty
                if (!rs.next()) {
                    throw new SQLException("Datensatz mit genreId = " + genreId + "  "
                            + "oder movieId = " + movieId + " nicht vorhanden");
                }
            }
        }
        return new MovieGenre(movieId, genreId);
    }
    
    /**
     * 
     * @return ArrayList containing Genre objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<MovieGenre> findByMovieGenreAll() throws SQLException {
        ArrayList<MovieGenre> movieGenres = new ArrayList<MovieGenre>(); 
        
        String SQL = "SELECT GenreId, MovieId FROM MovieGenre";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long movieId = rs.getLong("MovieId");
                    Long genreId = rs.getLong("GenreId");
                    movieGenres.add(new MovieGenre(movieId, genreId));
                }            
            } 
        }
        if (movieGenres.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return movieGenres;
    }
}
