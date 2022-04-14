package de.hsh.dbs2.imdb.util;

import javax.persistence.*;

public class EMConnection {
    private static EntityManagerFactory emf;

    static {
        emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("movie");
			System.out.println("Connect durchgefuehrt ....");
        } catch (Exception e) {
			System.err.println("Error while connecting to database");
			e.printStackTrace();
            System.exit(1);
        }
    }

    public static EntityManagerFactory getEntitymManager() {
        return emf;
    }
}
