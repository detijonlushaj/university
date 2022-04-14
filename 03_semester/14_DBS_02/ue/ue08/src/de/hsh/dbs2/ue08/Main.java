package de.hsh.dbs2.ue08;

import java.io.IOException;
import javax.persistence.*;
import de.hsh.dbs2.imdb.util.*;

/**
SELECT * FROM genrehib;
SELECT * FROM MovieGenrehib;
SELECT * FROM Moviehib;
SELECT * FROM MovieCharacterhib;
SELECT * FROM Personhib;
 * @author lushaj
 *
 */
public class Main {

	private static EntityManager em;

	public static void main(String[] args) throws IOException {
		em = EMConnection.getEntitymManager().createEntityManager();


		insertPersons();
		insertGenres();
		insertMovie();



		em.close();
		System.out.println("finished");



	}

	public static void insertPersons() {
		insertPerson("Detijon", 'm');
		insertPerson("Furkan", 'w');
		insertPerson("Schehat", 'm');
		insertPerson("Jirro", 'w');
		System.out.println("insertPersons");

	}
	public static void insertGenres() {
		insertGenre("Anime");
		insertGenre("Action");
		insertGenre("Comedy");
		insertGenre("Romance");
		System.out.println("insertGenres");

	}
	public static void insertMovie() {
		insertMovie("Hangover 1", "c", 2000);
		insertMovie("Hangover 2", "c", 2005);
		insertMovie("Hangover 3", "c", 2010);
		insertMovie("Naruto", "s", 1999);
		System.out.println("insertMovie");		
	}
	public static void insertMovieChar() {
		//insertMovChar( "character", "alias", 1232);
	}
	public static void insertMovieGenre() {
	}

	public static void insertPerson(String name, char c) {
		Person p = new Person();
		p.setName(name);
		p.setSex(c);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	}

	public static void insertGenre(String name) {
		Genre g = new Genre();
		g.setGenre(name);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(g);
		tx.commit();
	}
	public static void insertMovie(String name, String type, int year) {
		Movie m = new Movie();
		m.setTitle(name);
		m.setType(type);
		m.setYear(year);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(m);
		tx.commit();
	}

	public static void insertMovChar(String character, String alias, Integer position) {
		MovieCharacter mc = new MovieCharacter();
		mc.setCharacter(character);
		mc.setAlias(alias);
		mc.setPosition(position);
		//		mc.setMovie(movie);
		//		mc.setPerson(person);


		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(mc);
		tx.commit();
	}


}
