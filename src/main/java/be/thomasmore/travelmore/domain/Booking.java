package be.thomasmore.travelmore.domain;


import com.sun.xml.internal.bind.v2.schemagen.episode.Klass;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@NamedQueries(
        {
                @NamedQuery(
                        name = Booking.FIND_ALL,
                        query = "SELECT b FROM booking b"
                ),
                @NamedQuery(
                        name = Booking.FIND_BY_ID,
                        query = "SELECT b FROM booking b WHERE b.id = :id"

                )
        }
)

public class Booking {

    //properties
    public static final String FIND_ALL = "Booking.findAll";
    public static final String FIND_BY_ID = "Booking.findById";


    @Id
    private int id;
    @ManyToOne
    private Gebruiker gebruiker;
    @ManyToOne
    private Reis heenReis;
    @ManyToOne
    private Periode periode;
    @ManyToOne
    private Hotel hotel;
    private int aantalVolwassenen;
    private int aantalKinderen;
    private boolean reisVerzekering;
    private int ruimBagage;
    @ManyToOne
    private Klasse klasse;
    @ManyToOne
    private int terugReisId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gebruiker getGebruiker() {
        return gebruikerId;
    }

    public void setGebruikerId(int gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public int getHeenReisId() {
        return heenReisId;
    }

    public void setHeenReisId(int heenReisId) {
        this.heenReisId = heenReisId;
    }

    public int getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(int periodeId) {
        this.periodeId = periodeId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getAantalVolwassenen() {
        return aantalVolwassenen;
    }

    public void setAantalVolwassenen(int aantalVolwassenen) {
        this.aantalVolwassenen = aantalVolwassenen;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }

    public boolean isReisVerzekering() {
        return reisVerzekering;
    }

    public void setReisVerzekering(boolean reisVerzekering) {
        this.reisVerzekering = reisVerzekering;
    }

    public int getRuimBagage() {
        return ruimBagage;
    }

    public void setRuimBagage(int ruimBagage) {
        this.ruimBagage = ruimBagage;
    }

    public int getKlasse() {
        return Klasse;
    }

    public void setKlasse(int klasse) {
        Klasse = klasse;
    }

    public int getTerugReisId() {
        return terugReisId;
    }

    public void setTerugReisId(int terugReisId) {
        this.terugReisId = terugReisId;
    }






}
