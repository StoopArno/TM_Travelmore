package be.thomasmore.travelmore.domain;

import javax.persistence.*;


@Entity
@Table(name = "SoortTransport")
@NamedQueries(
        {
                @NamedQuery(
                        name = SoortTransport.FIND_ALL,
                        query = "SELECT l FROM SoortTransport l"
                ),
                @NamedQuery(
                        name = SoortTransport.FIND_BY_ID,
                        query = "SELECT l FROM SoortTransport l WHERE l.id = :id"

                )
        }
)

public class SoortTransport {


    //properties
    public static final String FIND_ALL = "SoortTransport.findAll";
    public static final String FIND_BY_ID = "SoortTransport.findById";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "soort")
    private String soort;


    //getters en setters
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
