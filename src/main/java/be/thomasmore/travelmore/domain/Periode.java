package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "periode")
@NamedQueries(
        {
                @NamedQuery(
                        name = Periode.FIND_ALL,
                        query = "SELECT p FROM Periode p"
                ),
                @NamedQuery(
                        name = Periode.FIND_BY_ID,
                        query = "SELECT p FROM Periode p WHERE p.id = :id"

                )
        }
)
public class Periode {

    //properties
    public static final String FIND_ALL = "Periode.findAll";
    public static final String FIND_BY_ID = "Periode.findById";


    @Id //Many To One met booking
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "beginDatum")
    private Date beginDatum;
    @Column(name = "eindDatum")
    private Date eindDatum;


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

    public Date getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }



}
