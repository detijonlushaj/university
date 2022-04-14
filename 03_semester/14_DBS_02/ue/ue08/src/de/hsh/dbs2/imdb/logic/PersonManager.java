package de.hsh.dbs2.imdb.logic;

import de.hsh.dbs2.ue08.*;
import de.hsh.dbs2.factories.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;
import de.hsh.dbs2.imdb.util.*;


public class PersonManager {

	/**
	 * Liefert eine Liste aller Personen, deren Name den Suchstring enthaelt.
	 * @param text Suchstring
	 * @return Liste mit passenden Personennamen, die in der Datenbank eingetragen sind.
	 * @throws Exception
	 */
	public List<String> getPersonList(String text) throws Exception {
	    System.out.println("getPersonList");
		EntityManager em = EMConnection.getEntitymManager().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ArrayList<String> PersonList = new ArrayList<>();
		try {
			tx.begin();
			
            List<Person> persons = PersonFactory.findByPersonAll(em);
			for(Person person : persons) {
				PersonList.add(person.getName());
			}
            Collections.sort(PersonList);
            
			tx.commit();
		} finally {
            if (tx.isActive()) {
                tx.rollback();
            }
			em.close();
		}
		return PersonList;
	}

}
