package ue04;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author lushaj
 * Person record
 */
public class Person {
    private Long personId;
    private String name;
    private Character sex;
    
    /**
     * constructor with parameters
     * @param personId
     * @param name
     * @param sex
     */
    Person (Long personId, String name, Character sex) {
        setPersonId(personId);
        setName(name);
        setSex(sex);
    }
    
    /**
     * empty constructor
     */
    public Person() {

    }
    
    /**
     * 
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param sex
     */
    public void setSex(Character sex) {
        this.sex = sex;
    }
    
    /**
     * 
     * @return personId
     */
    public Long getPersonId() {
        return personId;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return sex
     */
    public Character getSex() {
        return sex;
    }
    
    /**
     * insert Person object to table 
     * @throws SQLException
     */
    public void insert() throws SQLException {
        // this means no custom id was set thus using a sequence
        if (personId == null) {
            String getSeq = "SELECT person_seq.nextval FROM DUAL";
            try (PreparedStatement seq = ConnectionManager.getConnection().prepareStatement(getSeq)) {
                try (ResultSet rs = seq.executeQuery()) {
                    rs.next();
                    personId = rs.getLong("nextval");
                }
            } 
        }
        
        String SQL = "INSERT INTO Person VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, personId);
            
            if (name != null) {
                stmt.setString(2, name);
            } else {
                stmt.setNull(2, Types.NULL);
            }
            if (sex != null) {
                stmt.setString(3, String.valueOf(sex));
            } else {
                stmt.setNull(3, Types.NULL);
            }
            
            int n = stmt.executeUpdate();
            System.out.println("Inserts made: " + n);
        }
    }
    
    /**
     * update existing tuples in table. Does not check if peronId exists (yet?)
     * @throws SQLException
     */
    public void update() throws SQLException {
        String SQL = "UPDATE Person SET Name = ?, Sex = ? WHERE PersonId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            if (name != null) {
                stmt.setString(1, name);
            } else {
                stmt.setNull(1, Types.NULL);
            }
            if (sex != null) {
                stmt.setString(2, String.valueOf(sex));
            } else {
                stmt.setNull(2, Types.NULL);
            }
            
            stmt.setLong(3, personId);
            
            int n = stmt.executeUpdate();           
            System.out.println("Updates made: " + n);
        }
    }
    
    /**
     * deletes existing tuples in table. Does not check if personId exists (yet?)
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String SQL = "DELETE FROM Person WHERE PersonId = ?";
        
        try (PreparedStatement stmt = ConnectionManager.getConnection().prepareStatement(SQL)) {
            stmt.setLong(1, personId);
            
            int n = stmt.executeUpdate();
            System.out.println("Deletions made: " + n);
        } 
    }
}
