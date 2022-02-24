package ue04;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

//import de.hsh.dbs2.imdb.logic.GenreManager;
//import de.hsh.dbs2.imdb.logic.PersonManager;
//import de.hsh.dbs2.imdb.logic.dto.MovieDTO;
//import de.hsh.dbs2.imdb.logic.MovieManager;


public class Main {

	public static void main(String[] args) throws SQLException {
//		testInsert();
//		testsearch();
	}

//	public static void testsearch() throws SQLException {
//		boolean ok = false;
//
//		try {
//			//Personmanager klappt
//			List<String> team = PersonManager.getPersonList("a");
//			System.out.println(team);
//			
//			//Genremanager klappt
//			List<String> gen = GenreManager.getGenres();
//			System.out.println(gen);
//			
//			//getMovieList() klappt auch
//			List<MovieDTO> MovList = MovieManager.getMovieList("s");
//			System.out.println(MovList.toString());
//			
//			//insertUpdateMovie klappt
//			MovieDTO ins = new MovieDTO(4,"testerfolgreich","c",1999);
//			MovieManager.insertUpdateMovie(ins);
//			
//			//deleteMovie klappt 
//			MovieManager.deleteMovie(4);
//			
//			//getMovie  
//			MovieDTO test = MovieManager.getMovie(1);
//			System.out.println(test.toString());
//
//			ConnectionManager.getConnection().commit();
//			ok = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (!ok)
//				ConnectionManager.getConnection().rollback();
//		};
//	}

	public static void testInsert() throws SQLException {
		insertPerson("Detijon");
		insertPerson("Schehat");
		insertPerson("Furkan");
		insertPerson("Jirro");
		insertMovie("Naruto",1999);
		insertMovie("Naruto Shipuden",2000);
		insertMovie("One Piece",2000);
		insertMovie("testobjekt",2000);
		insertGenre("Anime");
		insertGenre("Comedy");
		insertGenre("Bollywoodfilm");

		insertMovieChar(1,1,"Sasuke");
		insertMovieChar(1,3,"Naruto");
		insertMovieChar(2,1,"Sasuke");
		insertMovieChar(2,3,"Naruto");
		insertMovieChar(3,4,"Luffy");

		insertMovieGenre(1,1);
		insertMovieGenre(2,1);
		insertMovieGenre(3,1);
		insertMovieGenre(3,2);
		
		insertMovieChar(4,2,"Luffy");

		insertMovieGenre(4,3);
	}

	public static void insertPerson(String name) throws SQLException {
		boolean ok = false;
		try {
			Person person = new Person();
			person.setName(name);
			person.setSex('W');
			person.insert();

			Person p = PersonFactory.findByPersonId(person.getPersonId());
			System.out.println(p.getName());

			ArrayList<Person> ps = PersonFactory.findByPersonAll();
			for (Person p_s : ps) {
				System.out.println(p_s.getName());
			}

			ConnectionManager.getConnection().commit();
			ok = true;
		} finally {
			if (!ok)
				ConnectionManager.getConnection().rollback();
		}
	}

	public static void insertMovie(String name, int jahr) throws SQLException {
		boolean ok = false;
		try {

			Movie movie = new Movie();
			movie.setTitle(name);
			movie.setYear(jahr);
			movie.setType('C');
			movie.insert();

			Movie m = MovieFactory.findByMovieId(movie.getMovieId());
			System.out.println(m.getTitle());

			ArrayList<Movie> ms = MovieFactory.findByMovieAll();
			for (Movie m_s : ms) {
				System.out.println(m_s.getTitle());
			}

			ConnectionManager.getConnection().commit();
			ok = true;
		} finally {
			if (!ok)
				ConnectionManager.getConnection().rollback();
		}
	}
	public static void insertMovieChar(long movid, long persid, String name) throws SQLException {
		boolean ok = false;
		try {

			MovieCharacter chr = new MovieCharacter();
			chr.setMovieId(movid);
			chr.setPersonId(persid);
			chr.setCharacter(name);
			chr.setAlias(null);
			chr.setPosition(1);
			chr.insert();

			MovieCharacter mc = MovieCharacterFactory.findByMovieCharacterId(chr.getMovCharId());
			System.out.println(mc.getCharacter());

			ArrayList<MovieCharacter> mcs = MovieCharacterFactory.findByMovieCharacterAll();
			for (MovieCharacter mc_s : mcs) {
				System.out.println(mc_s.getCharacter());
			}

			ConnectionManager.getConnection().commit();
			ok = true;
		} finally {
			if (!ok)
				ConnectionManager.getConnection().rollback();
		}
	}
	public static void insertGenre(String name) throws SQLException {
		boolean ok = false;
		try {

			Genre genre = new Genre();
			genre.setGenre(name);
			genre.insert();

			Genre g = GenreFactory.findByGenreId(genre.getGenreId());
			System.out.println(g.getGenre());

			ArrayList<Genre> gs = GenreFactory.findByGenreAll();
			for (Genre g_s : gs) {
				System.out.println(g_s.getGenre());
			}

			ConnectionManager.getConnection().commit();
			ok = true;
		} finally {
			if (!ok)
				ConnectionManager.getConnection().rollback();
		}
	}
	public static void insertMovieGenre(long movieid , long genreid) throws SQLException {
		boolean ok = false;
		try {
			MovieGenre movieGenre = new MovieGenre();
			movieGenre.setGenreId(genreid);
			movieGenre.setMovieId(movieid);
			movieGenre.insert();

			MovieGenre mg = MovieGenreFactory.findByMovieIdAndGenreId(movieid, genreid);
			System.out.println(mg.getGenreId());

			ArrayList<MovieGenre> mgs = MovieGenreFactory.findByMovieGenreAll();
			for (MovieGenre mg_s : mgs) {
				System.out.println(mg_s.getGenreId());
			}

			ConnectionManager.getConnection().commit();
			ok = true;
		} finally {
			if (!ok)
				ConnectionManager.getConnection().rollback();
		}
	}


}
