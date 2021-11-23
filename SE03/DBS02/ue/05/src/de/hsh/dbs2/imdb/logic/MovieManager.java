package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import de.hsh.dbs2.imdb.logic.dto.*;
import records.ConnectionManager;
import records.Genre;
import records.Movie;
import records.MovieCharacter;
import records.MovieGenre;
import records.Person;

public class MovieManager {

	/**
	 * Ermittelt alle Filme, deren Filmtitel den Suchstring enthaelt.
	 * Wenn der String leer ist, sollen alle Filme zurueckgegeben werden.
	 * Der Suchstring soll ohne Ruecksicht auf Gross/Kleinschreibung verarbeitet werden.
	 * @param search Suchstring. 
	 * @return Liste aller passenden Filme als MovieDTO
	 * @throws Exception
	 */
	public List<MovieDTO> getMovieList(String search) throws Exception {
		System.out.println("getMovieList");
		
		 boolean ok = false;
		 
		 ArrayList<MovieDTO> mDTO = new ArrayList<MovieDTO>();
		 try {
		     ArrayList<Movie> ms = records.MovieFactory.findByMovieAll();
		     for (Movie m : ms) {
		         if (m.getTitle().contains(search) || search.equals("")) {
		             mDTO.add(getMovie(m.getMovieId()));
		         }
		     }
		     
		     ConnectionManager.getConnection().commit();
		     ok = true;
		 } finally {
		     if (!ok)
		         ConnectionManager.getConnection().rollback();
		 }
		 
		return mDTO;
	}

	/**
	 * Speichert die uebergebene Version des Films neu in der Datenbank oder aktualisiert den
	 * existierenden Film.
	 * Dazu werden die Daten des Films selbst (Titel, Jahr, Typ) beruecksichtigt,
	 * aber auch alle Genres, die dem Film zugeordnet sind und die Liste der Charaktere
	 * auf den neuen Stand gebracht.
	 * @param movie Film-Objekt mit Genres und Charakteren.
	 * @throws Exception
	 */
	public void insertUpdateMovie(MovieDTO movieDTO) throws Exception {
	    System.out.println("insertUpdateMovie");
        
        boolean ok = false;
    
		try {
	        Movie m = new Movie(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getYear(), movieDTO.getType().charAt(0));
	        
	        // if movieDTO exists in database delete all dependencies
	        if (movieDTO.getId() != null) {
	            deleteMovie(movieDTO.getId());
	        }
	        
	        m.insert();
	        
	        for (String genre : movieDTO.getGenres()) {
	            // get genreId for this specific genre. In table genre is unique constraint for genre
	            Long genreId = records.GenreFactory.getGenreIdByGenre(genre);
	            
	            // genreId null then genre does not exist and need to insert in genre table
	            if (genreId == null) {
	                Genre g = new Genre();
	                g.setGenre(genre);
	                g.insert();  // genre id automatically generated if null
	                genreId = g.getGenreId();
	            }
	            
	            MovieGenre mg = new MovieGenre(m.getMovieId(), genreId);
	            mg.insert();
	        }
	        
	        int position = 1;
	        for (CharacterDTO cDTO : movieDTO.getCharacters()) {
	            MovieCharacter mc = new MovieCharacter();
	            mc.setCharacter(cDTO.getCharacter());
	            mc.setAlias(cDTO.getAlias());
	            mc.setMovieId(m.getMovieId());
	            mc.setPosition(position);
	            ++position;
	            mc.setPersonId(records.PersonFactory.getPersonIdByName(cDTO.getPlayer()));
	            
	            // adding new person but not needed due to program setup. Want to get Person
	            // from existing person table and not add new Person
//	            Person p = new Person();
//	            p.setName(cDTO.getPlayer());
//	            
//	            p.insert();  // id generated too
//	          
//	            mc.setPersonId(p.getPersonId());
	            
	            // mc.position == null, will be inserted as null in database
	            mc.insert();
	        }
	        
	        ConnectionManager.getConnection().commit();
	        ok = true;
		} finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
        }
	}

	/**
	 * Loescht einen Film aus der Datenbank. Es werden auch alle abhaengigen Objekte geloescht,
	 * d.h. alle Charaktere und alle Genre-Zuordnungen.
	 * @param movie
	 * @throws Exception
	 */
	public void deleteMovie(long movieId) throws Exception {
	    System.out.println("deleteMovie");
	    
	    boolean ok = false;
	    
	    try {
    	    ArrayList<MovieGenre> mgs = records.MovieGenreFactory.findByMovieGenreAll();
    	    for (MovieGenre mg : mgs) {
    	        if (mg.getMovieId().equals(movieId)) {
    	            // Genre g = new Genre();
    	            // g.setGenreId(mg.getGenreId());
    	            
    	            //order important due to foreign key constraint
    	            mg.delete();
    	            
    	            // skip for now
    	            // if mg was last entry for this genre then delete corresponding genre tuple in genre table
//    	            if (!records.MovieGenreFactory.checkIfGenreIdExists(mg.getGenreId())) {
//    	                g.delete();
//    	            }
    	        }
    	    }
    	    
    	    ArrayList<MovieCharacter> mcs = records.MovieCharacterFactory.findByMovieCharacterAll();
    	    for (MovieCharacter mc : mcs) {
    	        if (mc.getMovieId().equals(movieId)) {
    	            // skip not deleting person 
//    	            Person p = new Person();
//    	            p.setPersonId(mc.getPersonId());
    	            
    	            // order important due to foreign key constraint 
    	            mc.delete();
    	            // p.delete();
    	        }
    	    }
    	    
    	    Movie m = new Movie();
    	    m.setMovieId(movieId);
    	    m.delete();
    	    
    	    ConnectionManager.getConnection().commit();
    	    ok = true;
	    } finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
        }
	}

	/**
	 * Liefert die Daten eines einzelnen Movies zurück
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public MovieDTO getMovie(long movieId) throws Exception {
	    System.out.println("getMovie");
	    
	    boolean ok = false;
	    
        MovieDTO mDTO = new MovieDTO();
	    try {
    		Movie movie = records.MovieFactory.findByMovieId(movieId);
    		
    		mDTO.setId(movie.getMovieId());
    		mDTO.setTitle(movie.getTitle());
    		mDTO.setType(String.valueOf(movie.getType()));
    		mDTO.setYear(movie.getYear());
    		
    		ArrayList<MovieGenre> mgs = records.MovieGenreFactory.findByMovieGenreAll();
    		for (MovieGenre mg : mgs) {
    		    if (mg.getMovieId().equals(movie.getMovieId())) {
    		        Genre genre = records.GenreFactory.findByGenreId(mg.getGenreId());
    		        mDTO.addGenre(genre.getGenre());
    		    }
    		}
    		
    		ArrayList<MovieCharacter> mcs = records.MovieCharacterFactory.findByMovieCharacterAllOrdered();
    		for (MovieCharacter mc : mcs) {
    		    if (mc.getMovieId().equals(movie.getMovieId())) {
    		        CharacterDTO cDTO = new CharacterDTO();
    		        cDTO.setCharacter(mc.getCharacter());
    		        cDTO.setAlias(mc.getAlias());
    		        
    		        Person person = records.PersonFactory.findByPersonId(mc.getPersonId());
    		        
    		        cDTO.setPlayer(person.getName());
    		        mDTO.addCharacter(cDTO); 
    		    }
    		}
    		
    		ConnectionManager.getConnection().commit();
    		ok = true;
	    } finally {
	        if (!ok)
                ConnectionManager.getConnection().rollback();
            }
		return mDTO;
	}
}
