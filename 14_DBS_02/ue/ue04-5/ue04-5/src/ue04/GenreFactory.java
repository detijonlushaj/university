package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 
 * @author lushaj
 * GenreFactory. Returns objects of the genre table inside the database
 */
public class GenreFactory {

	/**
	 * search in the genre table after a tuple by the specified genreId
	 * @param genreId
	 * @return Genre object if genreId is inside the genre table else null  
	 * @throws SQLException
	 */
	public static Genre findByGenreId(Long genreId) throws SQLException {
		String genre = null;
		String SQL = "SELECT Genre FROM Genre WHERE GenreID = ?";

		try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
			stmt.setLong(1, genreId);

			try (ResultSet rs = stmt.executeQuery()) {
				// checking if ResultSet is empty
				if (rs.next()) {
					genre = rs.getString("Genre");
				} else {
					throw new SQLException("Datensatz mit genreId = " + genreId + " nicht vorhanden");
				}
			}
		}
		return new Genre(genreId, genre);
	}

	/**
	 * 
	 * @return ArrayList containing Genre objects. If table is empty then returning empty ArrayList
	 * @throws SQLException
	 */
	public static ArrayList<Genre> findByGenreAll() throws SQLException {
		ArrayList<Genre> genres = new ArrayList<Genre>(); 

		String SQL = "SELECT GenreId, Genre FROM Genre";

		try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Long genreId = rs.getLong("GenreId");
					String genre = rs.getString("Genre");
					genres.add(new Genre(genreId, genre));
				}            
			}
		} 
		if (genres.size() == 0) {
			System.out.println("Tabelle ist leer");
		}
		return genres;
	}

	/**
	 * find genreId by genre which is unique in this table
	 * @param genre
	 * @return
	 * @throws SQLException
	 */
	public static Long getGenreIdByGenre(String genre) throws SQLException {
		String SQL = "SELECT GenreId FROM Genre WHERE Genre = ?";

		try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
			stmt.setString(1, genre);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getLong("GenreId");
				} else {
					return null;
				}
			}
		}
	}
}
