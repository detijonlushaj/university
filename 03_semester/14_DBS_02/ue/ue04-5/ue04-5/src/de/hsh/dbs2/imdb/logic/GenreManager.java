package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ue04.Genre;
import ue04.GenreFactory;

public class GenreManager {

	/**
	 * Ermittelt eine vollstaendige Liste aller in der Datenbank abgelegten Genres
	 * Die Genres werden alphabetisch sortiert zurueckgeliefert.
	 * @return Alle Genre-Namen als String-Liste
	 * @throws Exception
	 */
	public static List<String> getGenres() throws Exception {
		// TODO
		ArrayList<Genre> all = GenreFactory.findByGenreAll();
		
		ArrayList<String> inside = new ArrayList<String>();
		for (Genre o : all) {
			inside.add(o.getGenre());
		}
		
		Collections.sort(inside);   
		return inside;
	}


}
