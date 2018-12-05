package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;



@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT l FROM Reis l"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALLVERTREKLOCATIEIDS,
                        query = "SELECT r.vertrekLocatie.id FROM Reis r"
                ),
                @NamedQuery(
                        name = Reis.FIND_ALLAANKOMSTLOCATIEIDS,
                        query = "SELECT r.aankomstLocatie.id FROM Reis r"
                ),
                @NamedQuery(
                       name = Reis.FILTERVERTREKLOCATIE,
                        query = "SELECT r FROM Reis r Where lower(r.vertrekLocatie.naam) = :naam"
                )
        }
)
public class Reis {

    public Reis(){
        setVertrekLocatie(new Locatie());
        setAankomstLocatie(new Locatie());
    }

    //properties
    public static final String FIND_ALL = "Reis.findAll";
    public static final String FIND_ALLVERTREKLOCATIEIDS = "Reis.findVertrekLocatieIds";
    public static final String FIND_ALLAANKOMSTLOCATIEIDS = "Reis.findAankomstLocatieIds";
    public static final String FILTERVERTREKLOCATIE = "Reis.filtervertreklocatie";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "vertrekLocatieID")
    private Locatie vertrekLocatie;

    @ManyToOne
    @JoinColumn(name = "aankomstLocatieID")
    private Locatie aankomstLocatie;


    @Column(name = "vertrekTijd")
    private Date vertrekTijd;

    @Column(name = "aankomstTijd")
    private Date aankomstTijd;

    @Column(name = "prijsPerPersoon")
    private double prijsPerPersoon;

    @Column(name = "transportmiddel")
    private String transportmiddel;

    @Column(name = "plaatsen")
    private int plaatsen;

    public String toString(){
        return id + " - " + vertrekLocatie + " --> " + aankomstLocatie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locatie getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(Locatie vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public Locatie getAankomstLocatie() {
        return aankomstLocatie;
    }

    public void setAankomstLocatie(Locatie aankomstLocatie) {
        this.aankomstLocatie = aankomstLocatie;
    }

    public Date getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(Date vertrekTijd) {
        this.vertrekTijd = vertrekTijd;
    }

    public Date getAankomstTijd() {
        return aankomstTijd;
    }

    public void setAankomstTijd(Date aankomstTijd) {
        this.aankomstTijd = aankomstTijd;
    }

    public double getPrijsPerPersoon() {
        return prijsPerPersoon;
    }

    public void setPrijsPerPersoon(double prijsPerPersoon) {
        this.prijsPerPersoon = prijsPerPersoon;
    }

    public String getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(String transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public int getPlaatsen() {
        return plaatsen;
    }

    public void setPlaatsen(int plaatsen) {
        this.plaatsen = plaatsen;
    }



}
