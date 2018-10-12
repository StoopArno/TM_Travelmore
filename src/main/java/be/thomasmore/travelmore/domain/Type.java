package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "Type")
@NamedQueries(
        {
                @NamedQuery(
                        name = Type.FIND_ALL,
                        query = "SELECT l FROM Type l"
                ),
                @NamedQuery(
                        name = Type.FIND_BY_ID,
                        query = "SELECT l FROM Type l WHERE l.id = :id"

                )
        }
)
public class Type {

    //properties
    public static final String FIND_ALL = "Type.findAll";
    public static final String FIND_BY_ID = "Type.findById";

    @Id
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
