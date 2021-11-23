package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import records.ConnectionManager;
import records.Person;

public class PersonManager {

	/**
	 * Liefert eine Liste aller Personen, deren Name den Suchstring enthaelt.
	 * @param text Suchstring
	 * @return Liste mit passenden Personennamen, die in der Datenbank eingetragen sind.
	 * @throws Exception
	 */
	public List<String> getPersonList(String text) throws Exception {
	    System.out.println("getPersonList");
	    
	    boolean ok = false;
	    
	    ArrayList<String> persons = new ArrayList<String>();
	    try {
	        ArrayList<Person> ps = records.PersonFactory.findByPersonAll();	        
	        for (Person p : ps) {
	            if (p.getName().contains(text)) {
	                persons.add(p.getName());
	            }
	        }
	       
	        ConnectionManager.getConnection().commit();
            ok = true;
        } finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
        }
		return persons;
	}
}