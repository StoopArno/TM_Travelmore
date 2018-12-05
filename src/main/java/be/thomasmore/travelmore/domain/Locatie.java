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

                ),
                @NamedQuery(
                        name = Locatie.FIND_VERTREKLOCATIES,
                        query = "SELECT l FROM Locatie l WHERE l.id IN :ids"
                ),
                @NamedQuery(
                        name = Locatie.FIND_AANKOMSTLOCATIES,
                        query = "SELECT l FROM Locatie l WHERE l.id IN :ids"
                )
        }
)
public class Locatie {

    //properties
    public static final String FIND_ALL = "Locatie.findAll";
    public static final String FIND_BY_ID = "Locatie.findById";
    public static final String FIND_VERTREKLOCATIES = "Locatie.findAllVertrekLocaties";
    public static final String FIND_AANKOMSTLOCATIES = "Locatie.findAllAankomstLocaties";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "land")
    private String land;
    @Column(name = "stad")
    private String stad;
    @Column(name = "naam")
    private String naam;
    @Column(name = "code")
    private String code;


    public String toString(){
        return stad + " | " + naam;
    }

    //getters en setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }
    public void setLand(String land) {
        this.land = land;
    }

    public String getStad() {
        return stad;
    }
    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}