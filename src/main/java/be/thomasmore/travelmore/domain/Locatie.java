package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "locatie")
@NamedQueries(
        {
                @NamedQuery(
                        name = Locatie.FIND_ALL,
                        query = "SELECT l FROM Locatie l"
                ),
                @NamedQuery(
                        name = Locatie.FIND_BY_ID,
                        query = "SELECT l FROM Locatie l WHERE l.id = :id"

                )
        }
)
public class Locatie {

    //properties
    public static final String FIND_ALL = "Locatie.findAll";
    public static final String FIND_BY_ID = "Locatie.findById";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "naam")
    private String naam;


    //getters en setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
