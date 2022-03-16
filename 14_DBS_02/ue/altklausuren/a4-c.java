
@Enitity
@Table(name = "politiker")
public class Politiker{
    @Id @GeneratedValue @Column(name = "dd")
    private int id;

    @Column(name = "name")
    private string name;

    @ManyToMany(mappedBy "politiker")
    Set<Gremium> gremien = new HashSet<Gremium>();

    @ManyToOne
    Patrei pratei = new Partei();

}

@Enitity
@Table(name = "Gremium")
public class Gremium{
    @id @GeneratedValue @Column(name = "id")
    private int id;

    @ManyToMany
    Set<Politiker> politiker = new HashSet<Politiker>();
}

@Enitity
@Table(name = "Partei")
public class Partei{
    @id @GeneratedValue @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "partei")
    Set<Poltiker> pol = new HashSet<Poltiker>();
}


void neuerPolitiker(String Poltikername,String Parteiname){
    EntityManager em = emf.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        Politiker pol = new Politiker();
        pol.setName(PolitikerName);
        pol.getPartei().setName(Parteiname);
        em.persist(pol);
        tx.commit();
    } finally {
        if (tx.isActive()) tx.rollback();
        em.close();
    }
}