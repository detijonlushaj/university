package de.hsh.dbs2.imdb.logic;

import de.hsh.dbs2.ue08.*;
import de.hsh.dbs2.factories.*;
import java.util.ArrayList;
import java.util.Collections;
import de.hsh.dbs2.imdb.util.EMConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class GenreManager {

	/**
	 * Ermittelt eine vollstaendige Liste aller in der Datenbank abgelegten Genres
	 * Die Genres werden alphabetisch sortiert zurueckgeliefert.
	 * @return Alle Genre-Namen als String-Liste
	 * @throws Exception
	 */
	public List<String> getGenres() throws Exception {
	    System.out.println("getGenres");
		EntityManager em = EMConnection.getEntitymManager().createEntityManager();
		EntityTransaction tx = em.getTransaction();				//transaktionssteuerung

		ArrayList<String> GenreList = new ArrayList<>();
		try {
			tx.begin();
			
	        List<Genre> genres = GenreFactory.findByGenreAll(em);
			for( Genre gerne : genres) {
				GenreList.add(gerne.getGenre());
			}
			
			Collections.sort(GenreList);
			tx.commit();
		} finally {

	        if (tx.isActive()) {
	            tx.rollback();
	        }
			em.close();
		}
		return GenreList;
	}

}
