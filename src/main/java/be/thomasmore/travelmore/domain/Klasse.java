package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "klasse")
@NamedQueries(
        {
                @NamedQuery(
                        name = Klasse.FIND_ALL,
                        query = "SELECT k FROM Klasse k"
                ),
                @NamedQuery(
                        name = Klasse.FIND_BY_ID,
                        query = "SELECT k FROM Klasse k WHERE k.id = :id"
                )
        }
)
public class Klasse {

    //properties
    public static final String FIND_ALL = "Klasse.findAll";
    public static final String FIND_BY_ID = "Klasse.findById";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    @Column(name="klasse")
    private String klasse;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
