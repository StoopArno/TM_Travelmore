package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="gebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_ALL,
                        query = "SELECT g FROM Gebruiker g ORDER BY achternaam,voornaam,gemeente"
                ),
                @NamedQuery(
                        name = Gebruiker.FIND_ALL_BY_EMAIL,
                        query = "SELECT l FROM Gebruiker l where l.email = :email"
                ),
                @NamedQuery(
                        name = Gebruiker.FIND_BY_EMAIL,
                        query = "select l from Gebruiker l where l.email = :email"
                )
        }
)
public class Gebruiker {
    public static final String FIND_ALL = "Gebruiker.findAll";
    public static final String FIND_ALL_BY_EMAIL = "Gebruiker.findAllByEmail";
    public static final String FIND_BY_EMAIL = "Gebruiker.findAllByName";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "voornaam")
    private  String voornaam;
    @Column(name = "achternaam")
    private String achternaam;
    @Column(name = "adres")
    private String adres;
    @Column(name = "gemeente")
    private String gemeente;
    @Column(name = "email")
    private String email;
    @Column(name = "wachtwoord")
    private String wachtwoord;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "soortGebruikerID")
    private SoortGebruiker soortGebruiker;

    public String toString(){
        return achternaam + " " + voornaam + " | " + gemeente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getNaam(){
        return voornaam + " "+ achternaam;
    }

    public SoortGebruiker getSoortGebruiker() {
        return soortGebruiker;
    }

    public void setSoortGebruiker(SoortGebruiker soortGebruiker) {
        this.soortGebruiker = soortGebruiker;
    }
}
