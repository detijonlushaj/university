package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author lushaj
 * MovieFactory. Returns objects of the genre table inside the database
 */
public class MovieFactory {
    
    /**
     * search in the movie table after a tuple by the specified movieId
     * @param movieId
     * @return Movie object if movieId is inside the movie table else null  
     * @throws SQLException
     */
    public static Movie findByMovieId(Long movieId) throws SQLException {
        String title = null;
        Integer year = null;
        Character type = null;
        String SQL = "SELECT Title, Year, Type FROM Movie WHERE MovieID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, movieId);
            try (ResultSet rs = stmt.executeQuery()) {
                // checking if ResultSet is empty
                if (rs.next()) {
                    title = rs.getString("Title");
                    year = rs.getInt("Year");
                    // convert String to char and then to Character object
                    type = Character.valueOf(rs.getString("Type").charAt(0));
                } else {
                    throw new SQLException("Datensatz mit movieID = " + movieId + " nicht vorhanden");
                }
            }
        }
        return new Movie(movieId, title, year, type);
    }
    
    /**
     * 
     * @return ArrayList containing Movie objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<Movie> findByMovieAll() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<Movie>(); 
        
        String SQL = "SELECT MovieId, Title, Year, Type FROM Movie";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long movieId = rs.getLong("MovieID");
                    String title = rs.getString("Title");
                    Integer year = rs.getInt("Year");
                    Character type = Character.valueOf(rs.getString("Type").charAt(0));
                    movies.add(new Movie(movieId, title, year, type));
                }            
            }
        }
        if (movies.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return movies;
    }
}
