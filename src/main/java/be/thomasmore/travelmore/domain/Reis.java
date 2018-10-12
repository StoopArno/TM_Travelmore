package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;



@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.FIND_ALL,
                        query = "SELECT l FROM Reis l"
                )
        }
)
public class Reis {

    //properties
    public static final String FIND_ALL = "Reis.findAll";


    @Id
    private int id;
    private Locatie vertrekLocatie;
    private Locatie aankomstLocatie;
    private Transportmiddel transportmiddel;


    @Column(name = "vertrekTijd")
    private Date vertrekTijd;

    @Column(name = "aankomstTijd")
    private Date aankomstTijd;

    @Column(name = "prijs")
    private double prijs;



    //getters en setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
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


    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }
}
