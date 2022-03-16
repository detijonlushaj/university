package de.hsh.dbs2.ue08;

import javax.persistence.*;

@Entity
@Table(name = "moviecharacterhib")
public class MovieCharacter {
	
	@Column @Id @GeneratedValue
    private Long movCharId;
    
	@Column
    private String character;
    
	@Column
    private String alias;
    
	@Column
    private Integer position;
    
	@Column
    private Long movieId;
    
	@Column
    private Long personId;
	
    @ManyToOne
    private Movie movie;
    
    @ManyToOne
    private Person person;

    
    public MovieCharacter() {
        
    }
    
    public MovieCharacter (Long movCharId, String character, String alias, Integer position, Movie movie, Person person) {
        setMovCharId(movCharId);
        setCharacter(character);
        setAlias(alias);
        setPosition(position);
        setMovie(movie);
        setPerson(person);
    }

    public void setMovCharId(Long movCharId) 	{this.movCharId = movCharId;}
    public Long getMovCharId() 		{return movCharId;}
    
    public void setCharacter(String character) 	{this.character = character;}
    public String getCharacter() 	{return character;}
    
    public void setAlias(String alias) 			{this.alias = alias;}
    public String getAlias() 		{return alias;}
    
    public void setPosition(Integer position) 	{this.position = position;}
    public Integer getPosition() 	{return position;}

    public void setMovieId(Long movieId) 		{this.movieId = movieId;}
    public Long getMovieId() 		{return movieId;}

    public void setPersonId(Long personId) 		{this.personId = personId;}
    public Long getPersonId() 		{return personId;}

    public void setMovie(Movie movie) 			{this.movie = movie;}
    public Movie getMovie() 		{return movie;}
    
    public void setPerson(Person person) 		{this.person = person;}
    public Person getPerson() 		{return person;}

    
}
