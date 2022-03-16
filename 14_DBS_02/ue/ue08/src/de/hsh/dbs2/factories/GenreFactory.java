package de.hsh.dbs2.factories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import de.hsh.dbs2.ue08.*;

public class GenreFactory {

    public static List<Genre> findByGenreAll(EntityManager em) {
    	//"jpa auf klassen ebene sql" Objektorientiert und nicht auf Tabellen
        TypedQuery<Genre> q = em.createQuery("SELECT g FROM Genre g", Genre.class);
        return q.getResultList();
    }
    
    public static Genre getGenreIdByGenre(EntityManager em, String genre) {
        TypedQuery<Genre> q = em.createQuery("SELECT g FROM Genre g WHERE g.genre = :genre", Genre.class);
        q.setParameter("genre", genre);
        return q.getSingleResult();
    }
    
}