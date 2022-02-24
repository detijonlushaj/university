package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;
import ue04.Person;
import ue04.PersonFactory;

public class PersonManager {

	/**
	 * Liefert eine Liste aller Personen, deren Name den Suchstring enthaelt.
	 * @param text Suchstring
	 * @return Liste mit passenden Personennamen, die in der Datenbank eingetragen sind.
	 * @throws Exception
	 */
	public static List<String> getPersonList(String text) throws Exception {
		// TODO
		ArrayList<Person> all = PersonFactory.findByPersonAll();
		
		ArrayList<String> inside = new ArrayList<String>();

		for (Person o : all) {
			if ( o.getName().toUpperCase().contains(text.toUpperCase())) {
				inside.add(o.getName());
			}
		}
		return inside;
	}

}
