//a.) JAVA CODE MIT PROJEKT, KUNDE UND GESCHÄFTSKUNDE
//Fügen Sie nur die nötigen Annotationen ein. Wenn nötig, streichen Sie Zeilen.

@Entity
@TABLE(name = “Projekt”);
public class Projekt{ 
	@ID @GeneratedValue
	@Column(name= “test”)
    private int id;

	@Column
    private String name;

	@ManyToOne
    private Kunde kunde;

}
@Entity
@TABLE(name = “Kunde”);
public class Kunde{
	@ID @GeneratedValue
	@Column
    private int id;

	@Column
    private String name;

	@Column
    @OneToMany(mappedby = „
    private List<Projekt> hatBeauftragt = new ArrayList<Projekt>();

}

public class Geschäftskunde extends Kunde{
   
    //private int id;

    @Column(name = „test“)
    private String rechtsform;
}

