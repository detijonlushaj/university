package de.hsh.dbs2.ue08;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name = "moviehib")
public class Movie {
	
    @Id @Column(name = "movieId") @GeneratedValue
    private Long movieId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "year")
    private Integer year;
    
    @Column(name = "type")
    private String type;
    
    @ManyToMany(cascade = CascadeType.MERGE)			//Wird bei Moviemanager wichtig wegen den Charaktern, wegen dem persistieren 
    @JoinTable(name = "movieGenrehib")						//(persitierte objekte koennen nicht malmal perist werden)
    private Set<Genre> genres = new HashSet<Genre>();
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.MERGE)
    private Set<MovieCharacter> movChars = new HashSet<MovieCharacter>();
	
	public Movie() {}
	
    public Movie (Long movieId, String title, Integer year, String type) {
        setMovieId(movieId);
        setTitle(title);
        setYear(year);
        setType(type);
    }

	public void setMovieId(Long id) 	{this.movieId = id;}
    public Long getMovieId() 	{return movieId;}

    public void setTitle(String title) 	{this.title = title;}
    public String getTitle() 	{return title;}
    
    public void setYear(Integer year) 	{this.year = year;}
    public Integer getYear() 	{return year;}
    
    public void setType(String type) {this.type = type;}
    public String getType() 	{return type;}
    
    public void setGenres(Set<Genre> genres) {this.genres = new HashSet<Genre>(genres);}
    public Set<Genre> getGenres() {return genres;}
    
    public void setMovChars(Set<MovieCharacter> movChars) {this.movChars = new HashSet<MovieCharacter>(movChars);}
    public Set<MovieCharacter> getMovChars() {return movChars;}
    
}
