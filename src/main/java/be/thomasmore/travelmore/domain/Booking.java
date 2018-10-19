package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "booking")
@NamedQueries(
        {
                @NamedQuery(
                        name = Booking.FIND_ALL,
                        query = "SELECT b FROM Booking b"
                ),
                @NamedQuery(
                        name = Booking.FIND_BY_ID,
                        query = "SELECT b FROM Booking b WHERE b.id = :id"

                )
        }
)

public class Booking {

    //properties
    public static final String FIND_ALL = "Booking.findAll";
    public static final String FIND_BY_ID = "Booking.findById";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    private Reis terugReis;




    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Reis getHeenReis() {
        return heenReis;
    }

    public void setHeenReis(Reis heenReis) {
        this.heenReis = heenReis;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public Reis getTerugReis() {
        return terugReis;
    }

    public void setTerugReis(Reis terugReis) {
        this.terugReis = terugReis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }








}
