package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author lushaj
 * PersonFactory. Returns objects of the person table inside the database
 */
public class PersonFactory {
    
    /**
     * search in the person table after a tuple by the specified movieId
     * @param personId
     * @return Person object if personId is inside the person table else null  
     * @throws SQLException
     */
    public static Person findByPersonId(Long personId) throws SQLException {
        String name = null;
        Character sex = null;
        String SQL = "SELECT Name, Sex FROM Person WHERE PersonID = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, personId);
            try (ResultSet rs = stmt.executeQuery()) {
                // checking if ResultSet is empty
                if (rs.next()) {
                    name = rs.getString("Name");
                    // convert String to char and then to Character object
                    sex = Character.valueOf(rs.getString("Sex").charAt(0));
                } else {
                    throw new SQLException("Datensatz mit personId = " + personId + " nicht vorhanden");
                }
            }
        }
        return new Person(personId, name, sex);
    }
    
    /**
     * 
     * @return ArrayList containing Person objects. If table is empty then returning empty ArrayList
     * @throws SQLException
     */
    public static ArrayList<Person> findByPersonAll() throws SQLException {
        ArrayList<Person> persons = new ArrayList<Person>(); 
        
        String SQL = "SELECT PersonId, Name, Sex FROM Person";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long personId = rs.getLong("PersonId");
                    String name = rs.getString("Name");
                    Character sex = Character.valueOf(rs.getString("Sex").charAt(0));
                    persons.add(new Person(personId, name, sex));
                }            
            }
        }
        if (persons.size() == 0) {
            System.out.println("Tabelle ist leer");
        }
        return persons;
    }

    public static Long getPersonIdByName(String name) throws SQLException {
        String SQL = "SELECT PersonId FROM Person WHERE Name = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("PersonId");
                } else {
                    return null;
                }
            }
        }
    }

}
