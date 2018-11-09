package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name="gebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.FIND_ALL_BY_EMAIL,
                        query = "SELECT l FROM Gebruiker l where l.email = :email"
                )
        }
)
public class Gebruiker {
    public static final String FIND_ALL_BY_EMAIL = "Gebruiker.findAllByEmail";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private  String voornaam;
    private String achternaam;
    private String adres;
    private String gemeente;
    private String geboorteDatum;
    private String email;
    private String wachtwoord;
    @ManyToOne
    private SoortGebruiker soortGebruiker;


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

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
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

    public SoortGebruiker getSoortGebruiker() {
        return soortGebruiker;
    }

    public void setSoortGebruiker(SoortGebruiker soortGebruiker) {
        this.soortGebruiker = soortGebruiker;
    }
}
