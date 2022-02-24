
@Entity
@Table(name = "E-Kunde")
public class Kunde{

    @Id @GeneratedValue @Column(name = "A-K_ID")
    private int id;

    @Column(name = "A-name")
    private string name;

	@OneToMany(mappedBy = "kunde") @Column(name = "A_journeys")
    private Set<Journy> journeys = new HashSet<Journy>();

}

@Entity
@Table(name = "E-Journey")
public class Journey{

    @Id @GeneratedValue @Colunm(name = "A-J_ID")
    private int id;

    @ManyToOne @Colunm(A-name)
    string name;
}

