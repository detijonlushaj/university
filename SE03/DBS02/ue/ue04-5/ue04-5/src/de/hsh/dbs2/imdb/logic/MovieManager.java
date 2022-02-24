package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import ue04.Genre;
import ue04.GenreFactory;
import ue04.Movie;
import ue04.MovieCharacter;
import ue04.MovieCharacterFactory;
import ue04.MovieFactory;
import ue04.MovieGenre;
import ue04.MovieGenreFactory;
import ue04.PersonFactory;
import de.hsh.dbs2.imdb.logic.dto.*;

public class MovieManager {

	/**
	 * Ermittelt alle Filme, deren Filmtitel den Suchstring enthaelt.
	 * Wenn der String leer ist, sollen alle Filme zurueckgegeben werden.
	 * Der Suchstring soll ohne Ruecksicht auf Gross/Kleinschreibung verarbeitet werden.
	 * @param search Suchstring. 
	 * @return Liste aller passenden Filme als MovieDTO
	 * @throws Exception
	 */
	public static List<MovieDTO> getMovieList(String search) throws Exception {
		// TODO
		ArrayList<Movie> allmov = MovieFactory.findByMovieAll();
		ArrayList<Movie> selectedmov = new ArrayList<Movie>();
		for (Movie o : allmov) {
			if ( o.getTitle().toUpperCase().contains(search.toUpperCase())) {
				selectedmov.add(o);
			}
		}
		ArrayList<MovieDTO> selctedmoviedto = new ArrayList<MovieDTO>();

		for (Movie scr : selectedmov) {
			MovieDTO res = new MovieDTO();

			res.setId(scr.getMovieId());
			res.setTitle(scr.getTitle());
			res.setType(scr.getType().toString());
			res.setYear(scr.getYear());

			ArrayList<MovieGenre> allmovgenre = MovieGenreFactory.findByMovieGenreAll();

			for (MovieGenre o : allmovgenre) {
				if ( o.getMovieId() == scr.getMovieId()) {
					res.addGenre( GenreFactory.findByGenreId(o.getGenreId()).getGenre() );
				}
			}

			ArrayList<MovieCharacter> allmovcar = MovieCharacterFactory.findByMovieCharacterAll();
			for (MovieCharacter o : allmovcar) {
				if ( o.getMovieId() == scr.getMovieId()) {
					CharacterDTO cdto = new CharacterDTO();
					cdto.setCharacter(o.getCharacter());
					cdto.setPlayer( PersonFactory.findByPersonId(o.getPersonId()).getName() );
					cdto.setAlias(o.getAlias());
					res.addCharacter(cdto);
				}
			}

			selctedmoviedto.add(res);
		}

		return selctedmoviedto;
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
	public static void insertUpdateMovie(MovieDTO movieDTO) throws Exception {
		// TODO
		Movie movinsr = MovieFactory.findByMovieId(movieDTO.getId());
		movinsr.setTitle(movieDTO.getTitle());
		movinsr.setType(movieDTO.getType().charAt(0));
		movinsr.setYear(movieDTO.getYear());

		if (movieDTO.getId() != null) {
			movinsr.setMovieId(movieDTO.getId());
			deleteMovie(movieDTO.getId());
		}
		movinsr.insert();

		//insert Genre
		for (String genre : movieDTO.getGenres()) {
			Long genreId = GenreFactory.getGenreIdByGenre(genre);

			if (genreId == null) {
				Genre g = new Genre();
				g.setGenre(genre);
				g.insert(); 
				genreId = g.getGenreId();
			}
			MovieGenre mg = new MovieGenre(movinsr.getMovieId(), genreId);
            mg.insert();
		}
		
        for (CharacterDTO cDTO : movieDTO.getCharacters()) {
            MovieCharacter mc = new MovieCharacter();
            mc.setCharacter(cDTO.getCharacter());
            mc.setAlias(cDTO.getAlias());
            mc.setMovieId(movinsr.getMovieId());            
            mc.setPersonId(PersonFactory.getPersonIdByName(cDTO.getPlayer()));
           
            mc.insert();
        }
	}

	/**
	 * Loescht einen Film aus der Datenbank. Es werden auch alle abhaengigen Objekte geloescht,
	 * d.h. alle Charaktere und alle Genre-Zuordnungen.
	 * @param movie
	 * @throws Exception
	 */
	public static void deleteMovie(long movieId) throws Exception {

		ArrayList<MovieGenre> allmovgen = MovieGenreFactory.findByMovieGenreAll();
		for (MovieGenre o : allmovgen) {
			if( o.getMovieId() == movieId) {
				o.delete();
			}
		}

		ArrayList<MovieCharacter> allmovch = MovieCharacterFactory.findByMovieCharacterAll();
		for (MovieCharacter o : allmovch) {
			if( o.getMovieId() == movieId) {
				o.delete();
			}
		}

		Movie movdel = MovieFactory.findByMovieId(movieId);
		movdel.delete();
	}

	/**
	 * Liefert die Daten eines einzelnen Movies zurück
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public static MovieDTO getMovie(long movieId) throws Exception {
		// TODO Auto-generated method stub
		Movie scr = MovieFactory.findByMovieId(movieId);
		MovieDTO res = new MovieDTO();

		res.setId(scr.getMovieId());
		res.setTitle(scr.getTitle());
		res.setType(scr.getType().toString());
		res.setYear(scr.getYear());

		ArrayList<MovieGenre> allmovgenre = MovieGenreFactory.findByMovieGenreAll();		
		for (MovieGenre o : allmovgenre) {
			if ( o.getMovieId() == movieId) {
				res.addGenre( GenreFactory.findByGenreId(o.getGenreId()).getGenre() );
			}
		}

		ArrayList<MovieCharacter> allmovcar = MovieCharacterFactory.findByMovieCharacterAll();
		for (MovieCharacter o : allmovcar) {
			if ( o.getMovieId() == movieId) {
				CharacterDTO cdto = new CharacterDTO();
				cdto.setCharacter(o.getCharacter());
				cdto.setPlayer( PersonFactory.findByPersonId(o.getPersonId()).getName() );
				cdto.setAlias(o.getAlias());

				res.addCharacter(cdto);
			}
		}


		return res;
	}

}
