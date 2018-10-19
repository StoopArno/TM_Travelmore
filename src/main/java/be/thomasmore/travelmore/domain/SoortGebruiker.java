package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "SoortGebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = SoortGebruiker.FIND_ALL,
                        query = "SELECT l FROM SoortGebruiker l"
                ),
                @NamedQuery(
                        name = SoortGebruiker.FIND_BY_ID,
                        query = "SELECT l FROM SoortGebruiker l WHERE l.id = :id"

                )
        }
)
public class SoortGebruiker {

    //properties
    public static final String FIND_ALL = "SoortGebruiker.findAll";
    public static final String FIND_BY_ID = "SoortGebruiker.findById";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "soort")
    private String soort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
}
