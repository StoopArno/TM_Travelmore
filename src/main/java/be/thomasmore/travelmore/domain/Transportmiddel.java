package be.thomasmore.travelmore.domain;


import javax.persistence.*;

@Entity
@Table(name = "transportmiddel")
@NamedQueries(
        {
                @NamedQuery(
                        name = Transportmiddel.FIND_BY_ID,
                        query = "SELECT l FROM Transportmiddel l WHERE l.id = :id"
                ),
                @NamedQuery(
                        name = Transportmiddel.FIND_ALL,
                        query = "SELECT l FROM Transportmiddel"
                )

        }
)

public class Transportmiddel {


    //properties
    public static final String FIND_BY_ID = "Transportmiddel.findById";
    public static final String FIND_ALL = "Transportmiddel.findAll";

    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "naam")
    private int aantalPlaatsen;

    private Type type;


    //getters and setters


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

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

    public void setAantalPlaatsen(int aantalPlaatsen) {
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
