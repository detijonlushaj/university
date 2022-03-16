package de.hsh.dbs2.ue08;

import javax.persistence.*;

@Entity
@Table(name = "personhib")
public class Person {
	
	@Id @Column @GeneratedValue //(nullable=false)
    private Long personid;
    
	@Column
    private String name;
    
	@Column
    private Character sex;
	
	
	public Person() {
		
	}
	
    public Person (Long personId, String name, char sex) {
        setPersonId(personId);
        setName(name);
        setSex(sex);
    }
	
	public void setPersonId(Long personId) 	{this.personid = personId;}
    public Long getPersonId() 	{return personid;}
    
    public void setName(String name) 		{this.name = name;}
    public String getName() 	{return name;}
    
    public void setSex(Character sex) 		{this.sex = sex;}
    public Character getSex() 	{return sex;}
    

}
