package de.hsh.dbs2.ue08;

import javax.persistence.*;

@Entity
@Table(name = "genrehib")
public class Genre {
	
	@Column @Id @GeneratedValue
    private Long genreid;
    
    @Column
    private String genre;
    
    
    public Genre() {
    	
    }

    public Genre (Long genreId, String genre) {
    	setGenreid(genreId);
        setGenre(genre);
    }

    public void setGenreid(Long genreId) 	{this.genreid = genreId;}
    public Long getGenreid() {return genreid;}

    public void setGenre(String genre) 		{this.genre = genre; }
    public String getGenre() {return genre;}
    
  }
