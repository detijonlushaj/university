package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import records.ConnectionManager;
import records.Genre;

public class GenreManager {

	/**
	 * Ermittelt eine vollstaendige Liste aller in der Datenbank abgelegten Genres
	 * Die Genres werden alphabetisch sortiert zurueckgeliefert.
	 * @return Alle Genre-Namen als String-Liste
	 * @throws Exception
	 */
	public List<String> getGenres() throws Exception {
	    System.out.println("getGenres");
	    
	    boolean ok = false;
	    
	    ArrayList<String> genresS = new ArrayList<String>();
	    try  {
    	    ArrayList<Genre> genres = records.GenreFactory.findByGenreAll();
    	    
    	    for (Genre gs : genres) {
    	        genresS.add(gs.getGenre());
    	    }
    	    
    	    Collections.sort(genresS);
    	    
    	    ConnectionManager.getConnection().commit();
    	    ok = true;
	    } finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
        }
	    return genresS;
	}
}
